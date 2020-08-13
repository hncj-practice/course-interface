package dao;

import domain.Clase;
import domain.Semester;
import domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISemesterDao {

    @Select("select * from xq")
    List<Semester> findAll();

    //添加班级
    @Insert("insert into xq values(#{semesterid},#{semestername})")
    void addSemester(Semester semester);

    //删除班级
    @Delete("delete from xq where xq_bh=#{semesterid}")
    int delSemester(@Param("semesterid") String semesterid);
}
