package com.zyj.springmvc.handler;

import com.zyj.springmvc.bean.Department;
import com.zyj.springmvc.bean.Employee;
import com.zyj.springmvc.dao.DepartmentDao;
import com.zyj.springmvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RestCrudHandler
 * @Auther: YaJun
 * @Date: 2021 - 04 - 14 - 12:36
 * @Description: com.zyj.springmvc.handler
 * @version: 1.0
 */
@Controller
public class RestCrudHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    /**
     * 文件的上传
     * 使用 @RequestParam 注解来指定参数
     * 上传的原理：将本地的文件上传到服务器端
     */
    @RequestMapping("upload")
    public String testUploadFile(@RequestParam("desc") String desc,
                                 @RequestParam("uploadFile") MultipartFile uploadFile,
                                 HttpSession session) throws Exception {
        // 获取到上传文件的名字
        String uploadFileName = uploadFile.getOriginalFilename();
        // 获取输入流
        InputStream in = uploadFile.getInputStream();
        // 获取服务器端的 upload 文件夹的真实路径。
        ServletContext sc = session.getServletContext();

        String realPath = sc.getRealPath("/upload");


        File targetFile = new File(realPath + "/" + uploadFileName);

        /*if (!targetFile.exists()) {
            targetFile.mkdir();
        }

        FileOutputStream os = new FileOutputStream(targetFile);

        // 写文件
        int i;
        while ((i = in.read()) != -1) {
            os.write(i);
        }
        in.close();
        os.close();*/

        uploadFile.transferTo(targetFile);
        return "success";
    }

    /**
     * 使用 HttpMessageConverter 完成下载功能
     *
     * HttpMessageConverter 支持  @RequestBody  @ResponseBody   HttpEntity  ResponseEntity
     *
     * 下载的原理：将服务器端的文件 以流 的形式 写到 客户端
     * ResponseEntity：将要下载的文件数据，以及响应信息封装到 ResponseEntity 对象中，浏览器端通过解析
     *                  发送回去的响应数据，就可以进行下载操作。
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> testDownload(HttpSession session) throws Exception {
        // 将要下载的文件读取成一个字节数据
        byte[] img;
        // 获取上下文对象
        ServletContext sc = session.getServletContext();
        // 将文件读取到流中
        InputStream in = sc.getResourceAsStream("image/test.jpg");
        // 根据 流中数据大小 给 byte 数组赋动态的值
        img = new byte[in.available()];
        // 将流中的数据写入到 byte 数组中
        in.read(img);
        
        // 将响应数据，以及一些响应头信息封装到 ResponseEntity 中
        /**
         * 参数：
         *  1.发送给浏览器端的数据
         *  2.设置响应头
         *  3.设置响应码
         */
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=test.jpg");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> re = new ResponseEntity<>(img, headers,statusCode);
        return re;
    }

    /**
     * 处理JSON
     */
    @ResponseBody   // 负责将方法的返回值转化成json字符串，响应给浏览器端
    @RequestMapping("/testJson")
    public Collection<Employee> testJSON() {
        Collection<Employee> emps = employeeDao.getAll();
        return emps;
    }

    /**
     * 修改功能：具体的修改操作
     */
    @RequestMapping(value = "emp", method = RequestMethod.PUT)
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 修改功能：去往修改页面
     */
    @RequestMapping(value = "emp/{id}", method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id") Integer id, Map<String,Object> map) {
        // 查询要修改的员工信息
        Employee employee = employeeDao.get(id);
        map.put("employee", employee);

        // 页面中显示部门下拉列表的数据
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);
        // 页面中显示单选框的数据
        Map<String,String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);
        // 去往修改页面
        return "input";
    }


    /**
     * 删除功能
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        // 删除员工
        employeeDao.delete(id);
        // 重定向到列表
        return "redirect:/emps";
    }


    /**
     * 添加功能：具体的添加操作
     * @param employee
     * @return
     */
    @RequestMapping(value = "emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        // 添加员工
        employeeDao.save(employee);
        // 回到列表页面
        // 重定向到列表页面：重定向到显示所有员工信息列表的请求
        return "redirect:/emps";
    }

    /**
     * 添加功能：去往添加页面
     *
     * 添加页面需要部门数据
     */
    @RequestMapping(value = "emp", method = RequestMethod.GET)
    public String toAddPage(Map<String,Object> map) {
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);

        // 2.构造页面中生成单选框的数据
        Map<String,String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);

        // 3.设置页面回显的数据
        map.put("employee", new Employee());
        return "input";
    }


    /**
     * 显示所有的员工信息列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String listAllEmps(Map<String,Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);
        return "list";
    }

}
