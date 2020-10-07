package dao;

import domain.Chapter;
import domain.Course;
import domain.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ITopicDao {
    @Results(id = "topicMap",value = {
            @Result(column = "ht_bh",property = "topicid",id = true),
            @Result(column = "kc_bh",property = "courseid"),
            @Result(column = "ht_bt",property = "topictitle"),
            @Result(column = "ht_nr",property = "topiccontent"),
            @Result(column = "ht_fbsj",property = "committime"),
            @Result(column = "ht_zt",property = "topicstatus")
    })
    @Select("select * from ht")
    List<Topic> findAll();


    //添加话题
    @Insert("insert into ht(kc_bh,ht_bt,ht_nr,ht_fbsj,ht_zt) values(#{courseid},#{topictitle},#{topiccontent},#{committime},#{topicstatus})")
    void addTopic(Topic topic);

    //修改话题(话题标题、话题内容、话题状态)
    @Update("<script>" +
            "update ht" +
            "<set>" +
            "<if test='title!=null'> ht_bt=#{title},</if>" +
            "<if test='content!=null'> ht_nr=#{content},</if>" +
            "<if test='status!=null'> ht_zt=#{status},</if>" +
            "<if test='commenttime!=null'> ht_fbsj=#{commenttime},</if>" +
            "</set>" +
            "where ht_bh=#{topicid} " +
            "</script>")
    void UpdateTopic(@Param("topicid") Integer topicid,@Param("title") String title,@Param("content") String content,@Param("status") Integer status,@Param("commenttime") Integer commenttime);


    //删除话题
    @Delete("delete from ht where ht_bh=#{topicid}")
    int delTopic(@Param("topicid") String topicid);

    //按课程号查找话题
    @Select("select * from ht where kc_bh=#{courseid}")
    @ResultMap(value = {"topicMap"})
    List<Topic> getTopicByCid(@Param("courseid") Integer courseid);
}
