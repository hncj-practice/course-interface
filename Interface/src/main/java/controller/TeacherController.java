package controller;

import dao.ICourseDao;
import dao.IStudentDao;
import dao.ITeacherDao;
import domain.Course;
import domain.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;
import util.AccountUtil;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/teacher")
public class TeacherController {

    /**
     * 修改教师信息
     * @param tno
     * @param password
     * @param name
     * @param sex
     * @param email
     * @param avatar
     * @param status
     * @return
     */
    @RequestMapping(path = "/updateteacher",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult updateTeacher(String tno,String password,String name,String sex,String email,String avatar,Integer status,String adminuser,String adminpwd){
        if(!AccountUtil.isAdmin(adminuser,adminpwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        ITeacherDao teacherDao=session.getMapper(ITeacherDao.class);
        try {
            teacherDao.UpdateTeacher(tno,password,name,sex,email,avatar,status);
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
     * 查询所有的教师信息
     * @return
     */
    @RequestMapping(path = "/allteacher",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult AllTeacher(Integer page,Integer num){
        //查询数据库
        String limit;
        if(page==null||num==null){
            limit="";
        }else{
            limit="limit "+(page-1)*num+","+num;
        }

        SqlSession session=util.MyBatis.getSession();
        ITeacherDao teacherDao=session.getMapper(ITeacherDao.class);
        List<Teacher> teachers=teacherDao.findAll(limit);
        int total=0;
        total=teacherDao.Total();
        if(!teachers.isEmpty()&&total!=0){
            for(Teacher teacher:teachers)
                teacher.setTotal(total);
            return APIResult.createOk("查询成功",teachers);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }

    /**
     * 按教师号查找教师信息
     * @param tno
     * @return
     */
    @RequestMapping(path = "/getteacherbytno",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult GetTeacherByTno(int tno){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ITeacherDao teacherDao=session.getMapper(ITeacherDao.class);
        List<Teacher> teachers=teacherDao.getTeacherByTno(tno);
        if(!teachers.isEmpty()){
            return APIResult.createOk("查询成功",teachers);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }
}
