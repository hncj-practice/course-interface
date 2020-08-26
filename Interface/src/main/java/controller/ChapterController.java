package controller;

import dao.IChapterDao;
import dao.ICourseDao;
import dao.IDataDao;
import domain.Chapter;
import domain.Problem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/chapter")
public class ChapterController {
    /**
     * 添加章节
     * @param chapter
     * @return
     */
    @RequestMapping(path = "/addchapter",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult AddChapter(Chapter chapter){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IChapterDao iChapterDao=session.getMapper(IChapterDao.class);
        try {
            iChapterDao.addChapter(chapter);
            session.commit();
            return APIResult.createOk("添加成功", chapter);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 更新章节信息
     * @param chapterid
     * @param name
     * @return
     */
    @RequestMapping(path = "/updatechapter",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult updateChapter(Integer chapterid,String name){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IChapterDao chapterDao=session.getMapper(IChapterDao.class);
        try {
            chapterDao.updateChapter(chapterid,name);
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
     * 删除章节
     * @param chapterid
     * @return
     */
    @RequestMapping(path = "/delchapter", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String chapterid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;       //学生
        IChapterDao chapterDao = session.getMapper(IChapterDao.class);
        status=chapterDao.delChapter(chapterid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }


    /**
     * 按课程号查找章节
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/getchapterbycourseid",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult GetChapterByCid(int courseid){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IChapterDao chapterDao=session.getMapper(IChapterDao.class);
        List<Chapter> chapters=chapterDao.findChapterByCourseid(courseid);
        if(!chapters.isEmpty()){
            return APIResult.createOk("查询成功",chapters);
        }else{
            return APIResult.createNg("暂无章节，请添加章节");
        }
    }
}
