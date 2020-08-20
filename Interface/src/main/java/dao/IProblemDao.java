package dao;

import domain.Comment;
import domain.Problem;
import domain.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProblemDao {
    @Results(id = "chapterMap",value = {
            @Result(column = "tm_bh",property = "pid",id = true),
            @Result(column = "zj_bh",property = "chapterid"),
            @Result(column = "bmlx_bh",property = "ptype"),
            @Result(column = "tm_tg",property = "question"),
            @Result(column = "tm_da",property = "panswer")
    })
    @Select("select * from tm")
    List<Problem> findAll();


    //添加题目
    @Insert("insert into tm(zj_bh,tmlx_bh,tm_tg,tm_da) values(#{chapterid},#{ptype},#{question},#{panswer})")
    void addProblem(Problem problem);

    //删除题目
    @Delete("delete from tm where tm_bh=#{problemid}")
    int delProblem(@Param("problemid") String problemid);

    //按章节查找题目
    @Select("select * from tm where zj_bh=#{chapterid}")
    @ResultMap(value = {"chapterMap"})
    List<Problem> getProblemByChapterid(@Param("chapterid") int chapterid);
}
