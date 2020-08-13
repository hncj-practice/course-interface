package controller;

import dao.ICourseDao;
import dao.ISemesterDao;
import domain.Chapter;
import domain.Course;
import domain.Semester;
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
     * 查询某课程下的所有章节
     * @param cno
     * @return
     */
    @RequestMapping(path = "/chapter",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult StudentLogin(String cno){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ICourseDao iCourseDao=session.getMapper(ICourseDao.class);
        List<Chapter> chapters=iCourseDao.findChapterByCno(cno);
        if(!chapters.isEmpty()){
            for(Chapter chapter:chapters)
                System.out.println(chapter.toString());
            return APIResult.createOk("查询成功",chapters);
        }else{
            return APIResult.createNg("暂无章节，请添加章节");
        }
    }

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
}
