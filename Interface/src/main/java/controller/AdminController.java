package controller;

import dao.IAdminDao;
import dao.ITeacherDao;
import domain.Account;
import domain.Admin;
import domain.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

//控制器类
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
        @RequestMapping(path = "/login",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
        @ResponseBody
        public APIResult AdminLogin(Account account){
            //查询数据库
            SqlSession session=util.MyBatis.getSession();
            IAdminDao iAdminDao=session.getMapper(IAdminDao.class);
            Admin admin=iAdminDao.findByTnoAndPwd(account.getUsername(),account.getPassword());
//            List<Teacher> teacher=teacherDao.findAll();

            if(admin!=null){
                System.out.println(admin.toString());
//                for(Teacher t:teacher)
//                    System.out.println(t.toString());
                return APIResult.createOk("登录成功",admin);
            }else{
                return APIResult.createNg("用户名或密码错误");
            }
        }
    }
