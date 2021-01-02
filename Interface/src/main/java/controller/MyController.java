package controller;


import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Controller
public class MyController {

    @RequestMapping("/user")
    public String hello(){
        System.out.println("hello world");
        return "result";
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String showLoad(@RequestParam("a")String s){
        return s;
    }

    @ResponseBody
    @RequestMapping(value = "/doUpload",method = RequestMethod.POST)
    public String doUpload(@RequestParam("file")MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + ".png";
        String result = FileUtils.copyInputStreamToFile(file.getInputStream(),new File("F:\\Games\\IntelliJ IDEA 2019.3\\SpringLearning\\spring_mvc2\\src\\main\\webapp\\photo",name));
        return result;
    }

    /*@ResponseBody
    @RequestMapping(value = "/doUpload",method = RequestMethod.POST)
    public String doUpload(@RequestParam("img")String s) throws IOException, Base64DecodingException {
        byte[] decode = Base64.decode(s);
        InputStream is = new ByteArrayInputStream(decode);
        String name = String.valueOf(System.currentTimeMillis()) + ".png";
        String result = FileUtils.copyInputStreamToFile(is,new File("F:\\Games\\IntelliJ IDEA 2019.3\\SpringLearning\\spring_mvc2\\src\\main\\webapp\\photo",name));
        return result;
    }*/

}
