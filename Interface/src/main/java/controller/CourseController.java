package controller;

import dao.ICourseDao;
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
    }
