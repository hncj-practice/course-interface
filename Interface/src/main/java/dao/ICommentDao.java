package dao;

import domain.Comment;
import domain.Course;
import domain.Student;
import domain.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICommentDao {
    @Results(id = "commentMap",value = {
            @Result(column = "pl_bh",property = "commentid",id = true),
            @Result(column = "xs_xh",property = "sno"),
            @Result(column = "ht_bh",property = "topicid"),
            @Result(column = "pl_nr",property = "commentcontent"),
            @Result(column = "pl_sj",property = "commenttime")
    })
    //查询所有的评论信息
    @Select("select * " +
            "from pl " +
            "limit #{start},#{end};")
    List<Comment> findAll(@Param("start") int start, @Param("end") int end);

    //修改评论
    @Update("<script>" +
            "update pl" +
            "<set>" +
            "<if test='content!=null'> pl_nr=#{content},</if>" +
            "</set>" +
            "where pl_bh=#{commentid}" +

            "</script>")
    void UpdateComment(@Param("commentid") Integer commentid,@Param("content") String content);


    //添加评论
    @Insert("insert into pl(xs_xh,ht_bh,pl_nr,pl_sj) values(#{sno},#{topicid},#{commentcontent},#{commenttime})")
    void addComment(Comment comment);

    //删除评论
    @Delete("delete from pl where pl_bh=#{commentid}")
    int delComment(@Param("commentid") String commentid);

    //按话题号查找评论
    @Select("select * from pl " +
            "where ht_bh=#{topicid} " +
            "limit #{start},#{end}")
    @ResultMap(value = {"commentMap"})
    List<Comment> getCommentByTopicid(@Param("topicid") int topicid,@Param("start") int start, @Param("end") int end);

    //统计某话题下的评论总数
    @Select("select count(*) from pl where ht_bh=#{topicid}")
    int Total(@Param("topicid") int topicid);
}
