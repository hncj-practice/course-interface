package dao;

import domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao {
    @Select("select * from xs")
    List<Student> findAll();

    @Select("select * from xs where xs_xh=#{username} and xs_mm=#{password}")
    Student findBySnoAndPwd(@Param("username") String username,@Param("password") String password);

//    List<Movie> findZ3();
}
