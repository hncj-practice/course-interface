package dao;

import domain.Clase;
import domain.Semester;
import domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISemesterDao {
    @Results(value = {
            @Result(column = "xq_bh",property = "semesterid",id = true),
            @Result(column = "xq_mc",property = "semestername")
    })
    //查找全部学期
    @Select("select * from xq")
    List<Semester> findAll();

    //添加学期
    @Insert("insert into xq(xq_mc) values(#{semestername})")
    void addSemester(Semester semester);

    //修改学期
    @Update("<script>" +
            "update xq" +
            "<set>" +
            "<if test='name!=null'> xq_mc=#{name},</if>" +
            "</set>" +
            "where xq_bh=#{semesterid}" +
            "</script>")
    void UpdateSemester(@Param("semesterid") Integer semesterid,@Param("name") String name);


    //删除学期
    @Delete("delete from xq where xq_bh=#{semesterid}")
    int delSemester(@Param("semesterid") Integer semesterid);
}
