package controller;

import dao.*;
import domain.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;
import util.AccountUtil;

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
     * @return
     */
    @RequestMapping(path = "/login",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult StudentLogin(Account account){

        SqlSession session=util.MyBatis.getSession();
        IStudentDao studentDao=session.getMapper(IStudentDao.class);
        Student student=studentDao.findBySnoAndPwd(account.getUsername(),account.getPassword());
        session.close();
        if(student!=null){
            return APIResult.createOk("登录成功",student);
        }else{
            return APIResult.createNg("用户名或密码错误");
        }

    }

    /**
     * 修改学生信息
     * @param sno
     * @param cla
     * @param password
     * @param name
     * @return
     */
    @RequestMapping(path = "/updatestudent",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult updateStudent(String sno,String cla,String password,String name,String sex,String email,String avatar,Integer status,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        IStudentDao studentDao=session.getMapper(IStudentDao.class);
        try {
            studentDao.UpdateCourse(sno,cla,password,name,sex,email,avatar,status);
            session.commit();
            return APIResult.createOKMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("修改失败");
        } finally {
            session.close();
        }
    }

    /**
     * 查询所有的学生信息
     * @return
     */
    @RequestMapping(path = "/allstudent",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult AllTeacher(Integer page,Integer num){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IStudentDao studentDao=session.getMapper(IStudentDao.class);
        List<Student> students=studentDao.findAll((page-1)*num,num);
        int total=0;
        total=studentDao.Total();
        session.close();
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
    @RequestMapping(path = "/getstudentbycid", method = {RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(String classid) {
        SqlSession session = util.MyBatis.getSession();
        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        List<Student> students = studentDao.findAllStudentByCid(classid);
        int total =0;
        total=studentDao.TotalByClassid(classid);
        session.close();
        if (!students.isEmpty()) {
            for(Student student:students){
                student.setTotal(total);
            }
            return APIResult.createOk("查找成功", students);
        } else {
            return APIResult.createNg("查询结果为空");
        }
    }


    /**
     * 将课程同学生教师关联
     * 指定某课程由哪个老师教、以及教哪些班级的学生
     * @param courseid
     * @param classid
     * @return
     */
    @RequestMapping(path = "/choicecourse",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult addProblems(Integer courseid,String [] classid,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        IStudentDao studentDao=session.getMapper(IStudentDao.class);
        try {
            studentDao.ChoiceCourse(courseid,classid);
            session.commit();
            return APIResult.createOk("添加成功", classid);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败,请检查是否已经添加");
        } finally {
            session.close();
        }
    }

    /**
     * 统计学生评论情况、试题完成情况
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/statistic", method = {RequestMethod.POST,RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(Integer courseid) {
        SqlSession session = util.MyBatis.getSession();
        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        int totalpaper=studentDao.findTotalPaperByCourseid(courseid);
        List<Statistic> students = studentDao.findAllStudentByCourseid(courseid);
        List<Score> scores=studentDao.findAverageScore(courseid);
        if (!students.isEmpty()) {
            for(Statistic student:students){
                student.setCommentnum(studentDao.findCommentNumBySno(student.getSno()));
                student.setFinpapernum(studentDao.findFinPaperNumBySnoAndCourseid(student.getSno(),courseid));
                student.setTotalpapernum(totalpaper);
                for(Score score:scores){
                    if(score.getSno().equals(student.getSno())){
                        student.setAverage(score.getAverage());
                    }
                }
                System.out.println(student.toString());
            }
            return APIResult.createOk("查找成功", students);
        } else {
            return APIResult.createNg("查询结果为空");
        }
    }



}
