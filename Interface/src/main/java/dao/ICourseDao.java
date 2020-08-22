package dao;

import domain.Chapter;
import domain.Course;
import domain.Semester;
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




    //添加课程
    @Insert("insert into kc(xq_bh,js_gh,kc_mc,kc_fm,kc_zt) values(#{semester},#{tno},#{cname},#{coverimg},#{status})")
    void addCourse(Course course);

    //删除课程
    @Delete("delete from kc where kc_bh=#{courseid}")
    int delCourse(@Param("courseid") String courseid);

    //按课程号查找课程
    @Select("select * from kc where kc_bh=#{courseid}")
    @ResultMap(value = {"courseMap"})
    Course getCourseByCid(@Param("courseid") int courseid);

    //修改课程状态(未开课/进行中/归档)
    @Update("update kc set kc_zt=#{status} where kc_bh=#{courseid}")
    void changeStatus(@Param("courseid") int courseid,@Param("status") int status);
}
