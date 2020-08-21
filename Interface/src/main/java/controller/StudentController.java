package controller;

import dao.IClassDao;
import dao.IStudentDao;
import dao.ITeacherDao;
import domain.Account;
import domain.Student;
import domain.Teacher;
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

    /**
     * 学生登录
     * @param account
     * @param model
     * @return
     */
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
     * 查询所有的学生信息
     * @return
     */
    @RequestMapping(path = "/allstudent",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult AllTeacher(int page,int num){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IStudentDao studentDao=session.getMapper(IStudentDao.class);
        List<Student> students=studentDao.findAll((page-1)*num,num);
        int total=0;
        total=studentDao.Total();
        if(!students.isEmpty()&&total!=0){
            for(Student student:students)
                student.setTotal(total);
            return APIResult.createOk("查询成功",students);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }

    /**
     * 按班级编号查找学生
     * @param classid
     * @return 账号信息或错误信息
     */
    @RequestMapping(path = "/getstudentbycid", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
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
