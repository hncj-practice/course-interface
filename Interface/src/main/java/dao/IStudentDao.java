package dao;

import domain.Student;
import domain.Teacher;
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

    //查询所有的学生信息
    @Select("select xs_xh,xs_xm,xs_xb,xs_yx,xs_tx,xs_zt " +
            "from xs " +
            "limit #{start},#{end};")
    List<Student> findAll(@Param("start") int start, @Param("end") int end);

    //统计学生的总数
    @Select("select count(*) from xs")
    int Total();


    //学生登录
    @Select("select * from xs where xs_xh=#{username} and xs_mm=#{password}")
    @ResultMap(value = {"studentMap"})
    Student findBySnoAndPwd(@Param("username") String username,@Param("password") String password);

    //添加学生
    @Insert("insert into xs(xs_xh,bj_bh,xs_mm,xs_xm,xs_xb,xs_yx,xs_tx,xs_zt) values(#{sno},#{cla},#{pwd},#{name},#{sex},#{email},#{avatar},#{status})")
    void addStudent(Student student);

    //删除学生
//    @Delete("delete from xs where xs_xh=#{username} and xs_mm=#{password}")
    @Delete("delete from xs where xs_xh=#{sno} and #{admin_pwd}=(select gly_mm from gly where gly_zh=#{admin_user} )")
    int deleteStudent(@Param("sno") String sno,@Param("admin_user") String admin_user,@Param("admin_pwd") String admin_pwd);

    //重置学生密码
    @Update("update xs set xs_mm=#{newpwd} where xs_xh=#{username} and xs_mm=#{oldpwd}")
    int updatePwd(@Param("username") String username,@Param("oldpwd") String oldpwd,@Param("newpwd") String newpwd);

    //查找某班级的所有学生
    @Select("select xs_xh,bj_bh,xs_xm,xs_xb,xs_yx from xs \n" +
            "where bj_bh=#{classid}")
    @ResultMap(value = {"studentMap"})
    List<Student> findAllStudentByCid(@Param("classid") String classid);
}
