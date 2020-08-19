package controller;

import dao.IClassDao;
import dao.IStudentDao;
import domain.Account;
import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/student")
public class StudentController {
//    ,params = {"sno","pwd"}
    @RequestMapping(path = "/login",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult StudentLogin(Account account, Model model){

        System.out.println(account.toString());

        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IStudentDao studentDao=session.getMapper(IStudentDao.class);
        Student student=studentDao.findBySnoAndPwd(account.getUsername(),account.getPassword());

//        List<Student> students =studentDao.findAll();
//        for(Student student:students)
//            System.out.println(student.toString());
        session.close();
        if(student!=null){
            System.out.println(student.toString());
            return APIResult.createOk("登录成功",student);
        }else{
            return APIResult.createNg("用户名或密码错误");
        }

    }

    /**
     * 查找某班级的所有学生
     * @param classid
     * @return 账号信息或错误信息
     */
    @RequestMapping(path = "/allstudent", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(String classid) {
        SqlSession session = util.MyBatis.getSession();
        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        List<Student> students = studentDao.findAllStudentByCid(classid);
        if (!students.isEmpty()) {
            return APIResult.createOk("查找成功", students);
        } else {
            return APIResult.createNg("查询结果为空");
        }
    }

}
