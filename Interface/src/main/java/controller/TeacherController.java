package controller;

import dao.ICourseDao;
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
@RequestMapping(path = "/teacher")
public class TeacherController {
    /**
     * 查询某教师教授的所有课程
     * @param tno
     * @return
     */
    @RequestMapping(path = "/teach",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult StudentLogin(String tno){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ICourseDao iCourseDao=session.getMapper(ICourseDao.class);
        List<Course> courses=iCourseDao.findTeachCourse(tno);
        if(!courses.isEmpty()){
            for(Course course:courses)
                System.out.println(course.toString());
            return APIResult.createOk("查询成功",courses);
        }else{
            return APIResult.createNg("没有授课记录，请先添加课程");
        }
    }
}
