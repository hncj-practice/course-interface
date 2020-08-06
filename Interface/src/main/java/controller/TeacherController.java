package controller;

import dao.ITeacherDao;
import domain.Account;
import domain.Student;
import domain.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/teacher")
public class TeacherController {
        @RequestMapping(path = "/login",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
        @ResponseBody
        public APIResult StudentLogin(Account account){
            //查询数据库
            SqlSession session=util.MyBatis.getSession();
            ITeacherDao teacherDao=session.getMapper(ITeacherDao.class);
            Teacher teacher=teacherDao.findByTnoAndPwd(account.getUsername(),account.getPassword());
//            List<Teacher> teacher=teacherDao.findAll();

            if(teacher!=null){
                System.out.println(teacher.toString());
//                for(Teacher t:teacher)
//                    System.out.println(t.toString());
                return APIResult.createOk("登录成功",teacher);
            }else{
                return APIResult.createNg("用户名或密码错误");
            }
        }
    }
