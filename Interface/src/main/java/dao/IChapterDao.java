package dao;

import domain.Chapter;
import domain.Problem;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IChapterDao {
    @Results(id = "examinationMap",value = {
            @Result(column = "tm_bh",property = "pid",id = true),
            @Result(column = "zj_bh",property = "chapterid"),
            @Result(column = "tmlx_bh",property = "ptype"),
            @Result(column = "tm_tg",property = "question"),
            @Result(column = "tm_da",property = "panswer")
    })
    @Select("select * from tm")
    List<Problem> findAll();

    //添加章节
    @Insert("insert into zj(kc_bh,zj_mc) values(#{cid},#{chaptername})")
    void addChapter(Chapter chapter);

    //删除章节
    @Delete("delete from zj where zj_bh=#{chapterid}")
    int delChapter(@Param("chapterid") String chapterid);


    //按课程号查找章节
    @Results(id = "chapterMap",value = {
            @Result(column = "zj_bh",property = "chapterid",id = true),
            @Result(column = "kc_bh",property = "courseid"),
            @Result(column = "zj_mc",property = "chaptername")
    })
    @Select("select zj_bh,kc_bh,zj_mc\n" +
            "from zj\n" +
            "where zj.kc_bh=#{courseid}")
    List<Chapter> findChapterByCourseid(@Param("courseid") int courseid);




}
