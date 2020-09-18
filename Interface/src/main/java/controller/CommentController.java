package controller;

import dao.ICommentDao;
import dao.ICourseDao;
import dao.ITopicDao;
import domain.Comment;
import domain.Topic;
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
@RequestMapping(path = "/comment")
public class CommentController {


    /**
     * 添加评论
     * @param comment
     * @return
     */
    @RequestMapping(path = "/addcomment",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult addComment(Comment comment,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        ICommentDao commentDao=session.getMapper(ICommentDao.class);
        try {
            System.out.println(comment.toString());
            commentDao.addComment(comment);
            session.commit();
            return APIResult.createOk("添加成功", comment);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 修改评论
     * @param commentid
     * @param content
     * @return
     */
    @RequestMapping(path = "/updatecomment",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult updateComment(Integer commentid,String content,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        ICommentDao commentDao=session.getMapper(ICommentDao.class);
        try {
            commentDao.UpdateComment(commentid,content);
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
     * 删除评论
     * @param commentid
     * @return
     */
    @RequestMapping(path = "/delcomment", method = {RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String commentid,String user,String pwd) {
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        ICommentDao commentDao = session.getMapper(ICommentDao.class);
        status=commentDao.delComment(commentid);
        session.commit();
        session.close();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 按话题号查找评论
     * @param topicid
     * @return
     */
    @RequestMapping(path = "/getcommentbytopicid",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult GetCommentByTopicid(Integer topicid,Integer page,Integer num){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ICommentDao commentDao=session.getMapper(ICommentDao.class);
        List<Comment> comments=commentDao.getCommentByTopicid(topicid,(page-1)*num,num);
        int total=0;
        total=commentDao.Total(topicid);
        session.close();
        if(!comments.isEmpty()&&total!=0){
            for(Comment comment:comments){
                comment.setTotal(total);
            }
            return APIResult.createOk("查询成功",comments);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }
}
