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
    @Select("select xs_xh,bj_bh,xs_xm,xs_xb,xs_yx,xs_zt " +
            "from xs " +
            "limit #{start},#{end};")
    List<Student> findAll(@Param("start") Integer start, @Param("end") Integer end);

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

    //修改学生信息
    @Update("<script>" +
            "update xs" +
            "<set>" +
            "<if test='cla!=null'> bj_bh=#{cla},</if>" +
            "<if test='password!=null'> xs_mm=#{password},</if>" +
            "<if test='name!=null'> xs_xm=#{name},</if>" +
            "<if test='sex!=null'> xs_xb=#{sex},</if>" +
            "<if test='email!=null'> xs_yx=#{email},</if>" +
            "<if test='avatar!=null'> xs_tx=#{avatar},</if>" +
            "<if test='status!=null'> xs_zt=#{status},</if>" +
            "</set>" +
            "where xs_xh=#{sno}" +
            "</script>")
    void UpdateCourse(@Param("sno") String sno,@Param("cla") String cla,@Param("password") String password,
                      @Param("name") String name,@Param("sex") String sex,@Param("email") String email,
                      @Param("avatar") String avatar,@Param("status") Integer status);


    //删除学生
//    @Delete("delete from xs where xs_xh=#{username} and xs_mm=#{password}")
    @Delete("delete from xs where xs_xh=#{sno}")
    int deleteStudent(@Param("sno") String sno);

    //重置学生密码
    @Update("update xs set xs_mm=#{newpwd} where xs_xh=#{username} and xs_mm=#{oldpwd}")
    int updatePwd(@Param("username") String username,@Param("oldpwd") String oldpwd,@Param("newpwd") String newpwd);


    //管理员重置学生密码（无需知道用户密码）
    @Update("update xs set xs_mm='000000' where xs_xh=#{username}")
    int updatePwdByAdmin(@Param("username") String usernamed);


    //查找某班级的所有学生
    @Select("select xs_xh,bj_bh,xs_xm,xs_xb,xs_yx from xs \n" +
            "where bj_bh=#{classid}")
    @ResultMap(value = {"studentMap"})
    List<Student> findAllStudentByCid(@Param("classid") String classid);

    //统计某班级的学生的总数
    @Select("select count(*) from xs where bj_bh=#{classid}")
    int TotalByClassid(@Param("classid") String classid);


    //将课程同学生教师关联
    //指定某课程由哪个老师教、以及教哪些班级的学生
    @Insert("<script>"  +
            "INSERT INTO xskc(kc_bh,xs_xh) select #{courseid},xs_xh from xs where bj_bh=" +
            "<foreach collection=\"classid\" item=\"item\" index=\"index\" separator=\"or\">" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    void ChoiceCourse(@Param("courseid") Integer courseid,@Param("classid") String[] classid);
}
