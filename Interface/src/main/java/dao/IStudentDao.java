package dao;

import domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IStudentDao {
    @Results(id = "studentMap", value = {
            @Result(column = "xs_xh",property = "sno",id = true),
            @Result(column = "bj_bh",property = "cla"),
            @Result(column = "xs_mm",property = "pwd"),
            @Result(column = "xs_xm",property = "name"),
            @Result(column = "xs_xb",property = "sex"),
            @Result(column = "xs_yx",property = "email"),
            @Result(column = "xs_tx",property = "avatar"),
            @Result(column = "xs_zt",property = "status")
    })

    @Select("select * from xs")
    List<Student> findAll();

    @Select("select * from xs where xs_xh=#{username} and xs_mm=#{password}")
    @ResultMap(value = {"studentMap"})
    Student findBySnoAndPwd(@Param("username") String username,@Param("password") String password);

//    @Insert("insert into xs values(#{student.sno},#{student.cla},#{student.pwd},#{student.name},#{student.sex},#{student.email},#{student.avatar},#{student.status})")
    @Insert("insert into xs(xs_xh,bj_bh,xs_mm,xs_xm,xs_xb,xs_yx,xs_tx,xs_zt) values(#{sno},#{cla},#{pwd},#{name},#{sex},#{email},#{avatar},#{status})")
    int addStudent(Student student);
//    @Insert("insert into xs values(#{sno},#{cla},#{pwd},#{name},#{sex},#{email},#{avatar},#{status})")
//    void addStudent(@Param("sno") String sno,@Param("cla") String cla,
//                    @Param("pwd") String pwd,@Param("name") String name,
//                    @Param("sex") String sex,@Param("email") String email,
//                    @Param("avatar") String avatar,@Param("status") String status);
//    List<Movie> findZ3();
}
