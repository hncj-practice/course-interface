package controller;

import dao.ICourseDao;
import dao.IDataDao;
import domain.Chapter;
import domain.Course;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/course")
public class CourseController {


    /**
     * 添加课程
     * @param course
     * @return
     */
    @RequestMapping(path = "/addcourse",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addClass(Course course){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ICourseDao courseDao=session.getMapper(ICourseDao.class);
        try {
            courseDao.addCourse(course);
            session.commit();
            return APIResult.createOk("添加成功", course);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

     /**
     * 修改课程
     * @param courseid
     * @param name
     * @param avatar
     * @param status
     * @return
     */
    @RequestMapping(path = "/updatecourse",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult changeData(Integer courseid,String name,String avatar,Integer status){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ICourseDao courseDao=session.getMapper(ICourseDao.class);
        try {
            courseDao.UpdateCourse(courseid,name,avatar,status);
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
     * 删除课程
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/delcourse", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String courseid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;       //学生
        ICourseDao courseDao = session.getMapper(ICourseDao.class);
        status=courseDao.delCourse(courseid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 按课程号查找课程
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/getcoursebycid",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult GetCourseByCid(int courseid){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ICourseDao courseDao=session.getMapper(ICourseDao.class);
        Course course=courseDao.getCourseByCid(courseid);
        if(course!=null){
            return APIResult.createOk("查询成功",course);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }


    /**
     * 按教师号查找课程或按课程名称模糊查询
     * @param condition 可以为教师号或者课程名称
     * @param page
     * @param num
     * @param type
     * @return
     */
    @RequestMapping(path = "/getcoursebytnoorcoursename",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult StudentLogin(String condition,Integer page,Integer num,Integer type){
        //查询数据库
        if(page==null||num==null||page<1||num<1){
            return APIResult.createNg("参数不合法");
        }
        if(type==1){//按教师号查询
            condition="js.js_gh="+condition;
        }else if(type==2){//按课程名称模糊查询
            condition="kc.kc_mc like "+"'%"+condition+"%'";
        }else{
            return APIResult.createNg("参数不合法，请检查");
        }
        SqlSession session=util.MyBatis.getSession();
        ICourseDao iCourseDao=session.getMapper(ICourseDao.class);
        List<Course> courses=iCourseDao.findTeachCourse(condition,(page-1)*num,num);
        if(!courses.isEmpty()){
            for(Course course:courses)
                if(course.getTname()==null){
                    course.setTname("暂未分配教师");
                }
            return APIResult.createOk("查询成功",courses);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }

}
