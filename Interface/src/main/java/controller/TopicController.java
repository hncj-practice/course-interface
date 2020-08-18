package controller;

import dao.ITopicDao;
import domain.Topic;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

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
}
