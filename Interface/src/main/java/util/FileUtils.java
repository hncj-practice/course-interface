package util;

import java.io.*;

public class FileUtils {
    public static String copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

        byte[] buf = new byte[4096];
        int length = bis.read(buf);
        //保存文件
        while(length != -1)
        {
            bos.write(buf, 0, length);
            length = bis.read(buf);
        }
        bos.close();
        bis.close();

        String result = null;
        if (file.exists()){
            result = "{ 'code': '200', 'url':'http://192.168.1.100:8080/spring_mvc2_war/photo/" + file.getName()+"'}";
        } else {
            result = "{ 'code': '200', 'url':'error'}";
        }
        return result;
    }
}
