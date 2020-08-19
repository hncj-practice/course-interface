package dao;

import domain.Admin;
import domain.Clase;
import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IClassDao {
    @Select("select * from bj")
    List<Teacher> findAll();

    //添加班级
    @Insert("insert into bj values(#{classid},#{classname})")
    void addClase(Clase clase);

    //删除班级
    @Delete("delete from bj where bj_bh=#{classid}")
    int delClase(@Param("classid") String classid);


}
