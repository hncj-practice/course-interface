package controller;

import dao.ICourseDao;
import dao.ITeacherDao;
import domain.Course;
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


    /**
     * 查询所有的教师信息
     * @return
     */
    @RequestMapping(path = "/allteacher",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult AllTeacher(){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ITeacherDao teacherDao=session.getMapper(ITeacherDao.class);
        List<Teacher> teachers=teacherDao.findAll();
        if(!teachers.isEmpty()){
            return APIResult.createOk("查询成功",teachers);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }
}
