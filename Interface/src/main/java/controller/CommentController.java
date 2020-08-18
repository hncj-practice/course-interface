package controller;

import dao.ICommentDao;
import dao.ITopicDao;
import domain.Comment;
import domain.Topic;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

//控制器类
@Controller
@RequestMapping(path = "/comment")
public class CommentController {


    /**
     * 添加评论
     * @param comment
     * @return
     */
    @RequestMapping(path = "/addcomment",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addComment(Comment comment){
        //查询数据库
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
     * 删除评论
     * @param commentid
     * @return
     */
    @RequestMapping(path = "/delcomment", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String commentid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        ICommentDao commentDao = session.getMapper(ICommentDao.class);
        status=commentDao.delComment(commentid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }
}
