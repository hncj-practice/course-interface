package controller;

import dao.IAdminDao;
import dao.IStudentDao;
import dao.ITeacherDao;
import domain.Account;
import domain.Admin;
import domain.Student;
import domain.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

//控制器类
@Controller
@RequestMapping(path = "/account")
public class AccountController {

    /**
     * 账号登录接口
     * 传入帐号名、密码以及账号类型
     *
     * @param account
     * @return 账号信息或错误信息
     */
    @RequestMapping(path = "/login", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(Account account) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        if (account.getType() == 1) {//学生
            IStudentDao studentDao = session.getMapper(IStudentDao.class);
            Student student = studentDao.findBySnoAndPwd(account.getUsername(), account.getPassword());
            if (student != null) {
                System.out.println(student.toString());
                return APIResult.createOk("登录成功", student);
            } else {
                return APIResult.createNg("用户名或密码错误");
            }
        } else if (account.getType() == 2) {//教师
            ITeacherDao teacherDao = session.getMapper(ITeacherDao.class);
            Teacher teacher = teacherDao.findByTnoAndPwd(account.getUsername(), account.getPassword());
            if (teacher != null) {
                System.out.println(teacher.toString());
                return APIResult.createOk("登录成功", teacher);
            } else {
                return APIResult.createNg("用户名或密码错误");
            }
        } else if (account.getType() == 3) {//管理员
            IAdminDao adminDao = session.getMapper(IAdminDao.class);
            Admin admin = adminDao.findByTnoAndPwd(account.getUsername(), account.getPassword());
            if (admin != null) {
                System.out.println(admin.toString());
                return APIResult.createOk("登录成功", admin);
            } else {
                return APIResult.createNg("用户名或密码错误");
            }
        } else {
            return APIResult.createNg("请求参数不合法");
        }

    }


    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping(path = "/addstudent", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult StudentAdd(Student student) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        try {
            studentDao.addStudent(student);
            session.commit();
            return APIResult.createOk("添加成功", student);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    @RequestMapping(path = "/addteacher", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult TeacherAdd(Teacher teacher) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        ITeacherDao teacherDao = session.getMapper(ITeacherDao.class);
        try {
            teacherDao.addTeacher(teacher);
            session.commit();
            return APIResult.createOk("添加成功", teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping(path = "/addadmin", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult AdminAdd(Admin admin) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        IAdminDao iAdminDao = session.getMapper(IAdminDao.class);
        try {
            iAdminDao.addAdmin(admin);
            session.commit();
            return APIResult.createOk("添加成功", admin);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 删除用户
     * @param account
     * @return
     */
    @RequestMapping(path = "/delete", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult Delete(Account account) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        if (account.getType() == 1) {           //学生
            IStudentDao studentDao = session.getMapper(IStudentDao.class);
            status=studentDao.deleteStudent(account.getUsername(),account.getAdmin_user(),account.getAdmin_pwd());
        } else if (account.getType() == 2) {    //教师
            ITeacherDao teacherDao = session.getMapper(ITeacherDao.class);
            status=teacherDao.deleteTeacher(account.getUsername(),account.getAdmin_user(),account.getAdmin_pwd());
        } else if (account.getType() == 3) {    //管理员
            IAdminDao adminDao = session.getMapper(IAdminDao.class);
            status=adminDao.deleteAdmin(account.getAdmin_user(),account.getAdmin_pwd());
        } else {
            return APIResult.createNg("请求参数不合法");
        }
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 重置用户密码
     * @param account
     * @return
     */
    @RequestMapping(path = "/resetpwd", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult ResetPwd(Account account) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        if (account.getType() == 1) {           //学生
            IStudentDao studentDao = session.getMapper(IStudentDao.class);
            status=studentDao.updatePwd(account.getUsername(),account.getPassword(),account.getNewpwd());
        } else if (account.getType() == 2) {    //教师
            ITeacherDao teacherDao = session.getMapper(ITeacherDao.class);
            status=teacherDao.updatePwd(account.getUsername(),account.getPassword(),account.getNewpwd());
        } else if (account.getType() == 3) {    //管理员
            IAdminDao adminDao = session.getMapper(IAdminDao.class);
            status=adminDao.updatePwd(account.getUsername(),account.getPassword(),account.getNewpwd());
        } else {
            return APIResult.createNg("请求参数不合法");
        }
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("密码重置成功");
        }else{
            return APIResult.createNg("密码重置失败");
        }
    }
}