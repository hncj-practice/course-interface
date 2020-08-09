package dao;

import domain.Chapter;
import domain.Course;
import domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICourseDao {
    @Results(id = "courseMap",value = {
            @Result(column = "kc_bh",property = "cid",id = true),
            @Result(column = "xq_bh",property = "semester"),
            @Result(column = "js_gh",property = "tno"),
            @Result(column = "kc_mc",property = "cname"),
            @Result(column = "kc_fm",property = "coverimg"),
            @Result(column = "kc_zt",property = "status"),
            @Result(column = "count(xskc.xs_xh)",property = "snum")
    })
    @Select("select * from kc")
    List<Course> findAll();


    //教师教授的所有课程
    @Select("select kc.kc_bh,kc.xq_bh,kc.js_gh,kc.kc_mc,kc.kc_fm,kc.kc_zt,count(xskc.xs_xh) \n" +
            "from js,kc,xskc \n" +
            "where js.js_gh=kc.js_gh and xskc.kc_bh=kc.kc_bh and js.js_gh=#{tno}\n" +
            "group by kc_bh")
    @ResultMap(value = {"courseMap"})
    List<Course> findTeachCourse(@Param("tno") String tno);

    //查询某课程的所有章节
    @Results(id = "chapterMap",value = {
            @Result(column = "zj_bh",property = "chapterid",id = true),
            @Result(column = "kc_bh",property = "cno"),
            @Result(column = "zj_mc",property = "chaptername")
    })
    @Select("select zj_bh,kc_bh,zj_mc\n" +
            "from zj\n" +
            "where zj.kc_bh=#{cno}")
    List<Chapter> findChapterByCno(@Param("cno") String cno);
}
