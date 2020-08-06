package dao;

import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ITeacherDao {
    @Results(id = "teacherMap",value = {
            @Result(column = "js_gh",property = "tno",id = true),
            @Result(column = "js_mm",property = "pwd"),
            @Result(column = "js_xm",property = "name"),
            @Result(column = "js_xb",property = "sex"),
            @Result(column = "js_yx",property = "email"),
            @Result(column = "js_tx",property = "avatar"),
            @Result(column = "js_zt",property = "status")
    })
    @Select("select * from js")
    List<Teacher> findAll();


    @Select("select * from js where js_gh=#{username} and js_mm=#{password}")
    @ResultMap(value = {"teacherMap"})
    Teacher findByTnoAndPwd(@Param("username") String username, @Param("password") String password);

}
