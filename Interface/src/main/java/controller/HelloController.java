package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHellow(){
        System.out.println("hello world!!!");
        return "success";
    }
}
