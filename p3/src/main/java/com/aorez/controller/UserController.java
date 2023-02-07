package com.aorez.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aorez.domain.User;
import com.aorez.domain.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
//    @RequestMapping("/userSave")
    //举例三个参数的用法
    @RequestMapping(value = "/save", method = RequestMethod.GET, params = {"username", "username!=1"})
    public String save() {
//        return "userSave.jsp";

        //在类上和方法上一起加@RequestMapping时，网页资源要在user/save.jsp这样的路径中
//        return "forward:save.jsp";

        //自定义前缀和后缀，进行内部资源视图的解析
        return "save";
    }

    @RequestMapping(value = "/save2")
    //测试ModelAndView
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        //这里的view name用了自己配置的前缀后缀
        modelAndView.setViewName("save2");
        modelAndView.addObject("username", "save2");
        return modelAndView;
    }

    @RequestMapping(value = "/save3")
    //测试ModelAndView多种方式
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.setViewName("save2");
        modelAndView.addObject("username", "save3");
        return modelAndView;
    }

    @RequestMapping(value = "/save4")
    //测试ModelAndView多种方式
    public String save4(Model model) {
        model.addAttribute("username", "save4");
        return "save2";
    }

    @RequestMapping(value = "/save5")
    //需要request对象时，也可以在参数中直接加
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "save5");
        return "save2";
    }

    @RequestMapping(value = "/save6")
    //测试回写数据，getWriter().write方法写字符串，print方法可以写多种类型，也可以写对象
    public void save6(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("save6方法");
    }

    //produces中处理中文
    @RequestMapping(value = "/save7", produces = "application/json;charset=utf-8")
    //@ResponseBody可以让方法直接返回回写的字符串，如果不加，则是默认进行拼接url，然后进行跳转
    @ResponseBody
    //参数中不加response
    public String save7() {
        return "save7方法";
    }

    @RequestMapping(value = "/save8", produces = "application/json;charset=utf-8")
    @ResponseBody
    //测试json数据格式
    public String save8() {
        return "{\"username\":\"张三\",\"age\":18}";
    }

    @RequestMapping(value = "/save9", produces = "application/json;charset=utf-8")
    @ResponseBody
    //测试json格式数据，和对象转json
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("张三");
        user.setAge(18);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        //两种json转换包
        //fastjson
        //fastjson转换后age在username的前面
//        String json = JSON.toJSONString(user);

        return json;
    }

    @RequestMapping("/save10")
    @ResponseBody
    //SpringMVC自动转json的时候没有乱码问题
    public User save10() {
        User user = new User();
        user.setUsername("张三");
        user.setAge(18);

        return user;
    }

    //这里的乱码问题和前面的不一样，这里是接收参数的情况，上面是发送数据
    //加上字符集中文也乱码了
    //改tomcat的server.xml配置文件，在connector中加上URIEncoding="UTF-8"
    //由于我使用的是tomcat插件进行运行，所以要在pom.xml中配置
    @RequestMapping(value = "/save11", produces = "application/json;charset=utf-8")
    //没有要回写的数据，也要用这个注解，因为不是转发或重定向
    @ResponseBody
    //测试接收请求参数，直接在参数中加，变量名一样即可
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/save12")
    @ResponseBody
    //测试接收数据为User类型
    //?username=张三&age=18
    public void save12(User user) {
        System.out.println(user);
    }

    @RequestMapping("/save13")
    @ResponseBody
    public void save13(String[] strings) {
        System.out.println(Arrays.toString(strings));
    }

    @RequestMapping("/save14")
    @ResponseBody
    //测试接收集合类型数据的请求
    //需要将集合放在一个类VO中的属性中进行封装
    //form.jsp
    public void save14(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping("/save15")
    @ResponseBody
    //测试直接识别集合类型的数据，不用封装到VO中，要加@RequestBody
    //变量名可以不一样
    public void save15(@RequestBody List<User> users) {
        System.out.println(users);
    }

    @RequestMapping("/save16")
    @ResponseBody
    //测试@RequestParam
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "张三") String username) {
        System.out.println(username);
    }

    @RequestMapping("/save17{name}/{age}")
    @ResponseBody
    //测试restful风格数据
    //url可变
    //可以用斜杠分隔开多个参数
    //访问时url /save17张三/18 即可获得参数
    public void save17(@PathVariable(value = "name") String username, @PathVariable(value = "age") int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/save18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    @RequestMapping("/save19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/save20")
    @ResponseBody
    //获取cookie的key要一致，比如JSESSIONID要大写
    public void save20(@RequestHeader(value = "user-agent") String user_agent, @CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        System.out.println(user_agent);
        System.out.println(jsessionId);
    }

    @RequestMapping("/save21")
    @ResponseBody
    public void save21(String username, MultipartFile uploadFile) {
        System.out.println(username);
        System.out.println(uploadFile);

        String originalFilename = uploadFile.getOriginalFilename();
        System.out.println(originalFilename);
    }

    @RequestMapping("/save22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile, MultipartFile[] uploadFiles) {
        System.out.println(username);
        System.out.println(uploadFile.getOriginalFilename());

        for (MultipartFile file: uploadFiles) {
            System.out.println(file.getOriginalFilename());
        }
    }
}
