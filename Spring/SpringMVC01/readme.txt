SpringMVC的HelloWorld：
    1、创建web工程，导入核心的包（SpringMVC的jar包）
    2、在web.xml中配置SpringMVC的前端控制器：DispatcherServlet
    3、配置SpringMVC的核心配置文件：spring-config.xml
    4、编写请求处理器
    5、浏览器发送请求，请求处理器中处理请求
    6、测试

SpringMVC HelloWorld 执行流程：
    1、启动服务器。同时也就启动了DispatcherServlet前端控制器，在前端控制器中，设置了 load-on-start，即启动服务器后创建 DispatcherServlet，
DispatcherServlet 通过 init-param 读取 spring-config.xml，也就创建好了 SpringMVC 容器对象。且扫描到了所有加有注解的类、方法以及对象。
    2、访问index.jsp。进入首页，在 index.jsp 中有一个链接，通过该链接向服务器发起请求，由于 url-pattern 设置为 / ，所以任何请求都可以进来，
进来之后因为 DispatcherServlet 已经被创建好了，SpringMVC 容器对象已经就绪，所以请求就进入了 SpringMVC 容器对象中。
    在IOC容器中扫描组件，类 SpringMVCHandler 使用了注解 @Controller 控制器，所以被扫描了进去，进去之后就创建，在方法外部又通过注解 @RequestMapping
对请求做响应（通过设置值来精确的对请求做响应），在方法内部做逻辑处理，最后返回一个值，该值请求处理方法的返回值。通过视图解析器对返回值做处理。
视图解析器配置在 spring-config.xml 文件中，通过前缀 prefix + 请求处理返回值 + 后缀 suffix = 物理路径的方法实现跳转到 success.jsp 页面。

视频解析执行流程：
    1、启动 Tomcat 服务器，会加载 DispatcherServlet，然后就会读取 spring-config.xml,进而创建好 SpringMVC 容器对象。
    创建SpringMVC容器对象：组件扫描会扫描到请求处理器，以及请求处理中 @RequestMapping 注解，
    能得到具体的请求与请求处理器中 方法的映射。
    2、客户端发送请求：http://localhost:8080/SpringMVC01/hello
    3、请求到达web.xml中与<url-pattern>进行匹配，匹配成功，就将请求交给 DispatcherServlet。
    4、DispatcherServlet 根据请求 与 请求处理方法的映射，将请求交给具体的请求处理器中的请求处理方法来进行处理
    5、请求处理方法处理完请求，最终方法会返回一个字符串
    6、视图解析器根据请求处理方法返回的结果，prefix + returnValue + suffix，解析生成具体的物理视图路径
    再通过转发的方式去往视图。