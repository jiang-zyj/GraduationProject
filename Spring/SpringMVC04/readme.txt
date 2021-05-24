SpringMVC 工作流程描述

1.用户向服务器发送请求，请求被SpringMVC前端控制器 DispatcherServlet 捕获；
2.DispatcherServlet 对请求 URL 进行解析，得到请求资源标识符（URI）：
    判断请求 URI 对应的映射
    ① 不存在：
        再判断是否配置了 <mvc:default-servlet-handler/>;
        如果没有配置，则控制台报映射查找不到，客户端显示 404 错误。
        如果有配置，则执行目标资源（一般为静态资源，如：JS,CSS,HTML）但是必须要配置 <mvc:annotation-driven/>,否则会出现其他映射失效，
        因为配置了 <mvc:default-servlet-handler/> 之后，请求都是由 Tomcat 中的默认请求处理器来处理，配置 <mvc:annotation-driven/> 之后，
        会有一个 requestMappingHandler 来处理请求。
    ② 存在：
        执行以下流程
3. 根据该 URI，调用 HandlerMapping 获得该 Handler 配置的所有相关的对象(包括 Handler 对象以及拦截器对象),
最后以 HandlerExecutionChain 对象的形式返回，即 MappedHandler;在其中：
HandlerMapping 为 请求方法与请求处理器之间的映射(表)
HandlerExecutionChain(处理器执行链) 里面包含了所有的请求处理器以及拦截器。
通过 getHandler 方法，遍历整个映射表，获取请求方法 对应的 请求处理器 以及 拦截器，封装到 HandlerExecutionChain 对象中。最后返回 HandlerExecutionChain 对象 MappedHandler。
整个过程可以认为是：获取请求方法对应的请求处理器以及拦截器并封装到 HandlerExecutionChain 处理器执行链中。
4.DispatcherServlet 根据封装好的 HandlerExecutionChain 对象 MappedHandler(已经存储了请求方法对应的请求处理器)，通过 getHandler 方法获取到 HandlerAdapter 对象。
HandlerAdapter 对象是一个接口，通过调用接口中的 handle 方法来 调用请求处理器来 处理 请求处理方法，最后获取到 ModelAndView 对象
整个过程可以认为是：通过请求处理器执行请求方法并返回 ModelAndView 对象。
5. 如果成功获得 HandlerAdapter 后，此时将开始执行拦截器的 preHandler 方法【正向】
6. 提取 Request 中的模型数据，填充 Handler 入参，开始执行 Handler(Controller) 方法，处理请求。在填充 Handler 的
入参过程中，根据你的配置，Spring 将帮你做一些额外的工作：
    ① HttpMessageConverter：将请求消息（如Json、xml等数据）转换为一个对象，将对象转换为指定的响应信息。
    ② 数据转换：对请求消息进行数据转换。如 String 转换为 Integer、Double 等。
    ③ 数据格式化：对请求消息进行数据格式化。如将字符串转换为格式化数字或格式化日期等。
    ④ 数据验证：验证数据的有效性（长度、格式等），验证结果存储到 BindingResult 或 Error 中。
7. Handler 执行完成后，向 DispatcherServlet 返回一个 ModelAndView 对象；
8. 此时将开始执行拦截器的 postHandler 方法【逆向】
9. 根据返回的 ModelAndView（此时会判断是否存在异常，如果存在异常，则执行 HandlerExceptionResolver 进行异常处理）
选择一个合适的 ViewResolver（必须是已经注册到 Spring 容器中的 ViewResolver）返回给 DispatcherServlet，根据 Model 和 View，来渲染视图。
10. 在返回给客户端时需要执行拦截器的 AfterCompletion 方法【逆向】
11. 将渲染结构返回给客户端。


