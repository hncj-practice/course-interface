package controller;

import dao.ICourseDao;
import dao.ITopicDao;
import domain.Course;
import domain.Topic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/topic")
public class TopicController {


    /**
     * 添加话题
     * @param topic
     * @return
     */
    @RequestMapping(path = "/addtopic",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addTopic(Topic topic){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ITopicDao topicDao=session.getMapper(ITopicDao.class);
        try {
            topicDao.addTopic(topic);
            session.commit();
            return APIResult.createOk("添加成功", topic);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 修改话题
     * @param topicid
     * @param title
     * @param content
     * @param status
     * @return
     */
    @RequestMapping(path = "/updatetopic",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult changeData(Integer topicid,String title,String content,Integer status){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ITopicDao topicDao=session.getMapper(ITopicDao.class);
        try {
            topicDao.UpdateTopic(topicid,title,content,status);
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
     * 删除话题
     * @param topicid
     * @return
     */
    @RequestMapping(path = "/deltopic", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String topicid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        ITopicDao topicDao = session.getMapper(ITopicDao.class);
        status=topicDao.delTopic(topicid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 按课程号查找话题
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/gettopicbycid",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult GetTopicByCid(int courseid){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ITopicDao topicDao=session.getMapper(ITopicDao.class);
        List<Topic> topics=topicDao.getTopicByCid(courseid);
        if(!topics.isEmpty()){
            return APIResult.createOk("查询成功",topics);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }
}
