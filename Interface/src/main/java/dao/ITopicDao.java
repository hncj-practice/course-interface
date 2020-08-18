package dao;

import domain.Chapter;
import domain.Course;
import domain.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ITopicDao {
    @Results(id = "courseMap",value = {
            @Result(column = "kc_bh",property = "cid",id = true),
            @Result(column = "xq_bh",property = "semester"),
            @Result(column = "js_gh",property = "tno"),
            @Result(column = "kc_mc",property = "cname"),
            @Result(column = "kc_fm",property = "coverimg"),
            @Result(column = "kc_zt",property = "status"),
            @Result(column = "count(xskc.xs_xh)",property = "snum")
    })
    @Select("select * from ht")
    List<Course> findAll();


    //添加话题
    @Insert("insert into ht(kc_bh,ht_bt,ht_nr,ht_fbsj,ht_zt) values(#{courseid},#{topictitle},#{topiccontent},#{committime},#{topicstatus})")
    void addTopic(Topic topic);

    //删除话题
    @Delete("delete from ht where ht_bh=#{topicid}")
    int delTopic(@Param("topicid") String topicid);
}
