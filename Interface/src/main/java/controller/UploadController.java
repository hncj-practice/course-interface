package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtils;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(path = "upload")
public class UploadController {
    @ResponseBody
    @RequestMapping(value = "/doUpload",method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + ".png";
        String result = FileUtils.copyInputStreamToFile(file.getInputStream(),new File("./",name));
        return result;
    }
}
