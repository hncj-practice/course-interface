package controller;

import dao.IStudentDao;
import domain.Account;
import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/student")
public class StudentController {
//    ,params = {"sno","pwd"}
    @RequestMapping(path = "/login",method = {RequestMethod.POST},headers = {"Accept"})
    public String StudentLogin(Account account){

        System.out.println(account.toString());

        SqlSession session=util.MyBatis.getSession();
        IStudentDao studentDao=session.getMapper(IStudentDao.class);
//        Student student=studentDao.findBySnoAndPwd(account.getUsername(),account.getPassword());

        List<Student> students =studentDao.findAll();
        for(Student student:students)
        System.out.println(student.toString());
        return "success";
    }
}
