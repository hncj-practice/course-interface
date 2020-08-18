package dao;

import domain.Comment;
import domain.Course;
import domain.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICommentDao {
    @Select("select * from pl")
    List<Comment> findAll();


    //添加评论
    @Insert("insert into pl(xs_xh,ht_bh,pl_nr,pl_sj) values(#{sno},#{topicid},#{commentcontent},#{commenttime})")
    void addComment(Comment comment);

    //删除评论
    @Delete("delete from pl where pl_bh=#{commentid}")
    int delComment(@Param("commentid") String commentid);
}
