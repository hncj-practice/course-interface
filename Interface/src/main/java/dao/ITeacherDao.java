package dao;

import domain.Clase;
import domain.Course;
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
            @Result(column = "js_zt",property = "status"),
            @Result(column = "count(js_gh)",property = "status")
    })
    //查询所有教师的信息
    @Select("select js_gh,js_xm,js_xb,js_yx,js_tx,js_zt " +
            "from js " +
            "${limit}")
    List<Teacher> findAll(@Param("limit") String limit);

    //统计教师的总数
    @Select("select count(*) from js")
    int Total();

    //按教师编号查找教师
    @Select("select js_gh,js_xm,js_xb,js_yx,js_tx,js_zt from js where js_gh=#{tno}")
    @ResultMap(value = {"teacherMap"})
    List<Teacher> getTeacherByTno(@Param("tno") Integer tno);


    //教师登录
    @Select("select * from js where js_gh=#{username} and js_mm=#{password}")
    @ResultMap(value = {"teacherMap"})
    Teacher findByTnoAndPwd(@Param("username") String username, @Param("password") String password);

//    //添加教师
//    @Insert("insert into js values(#{tno},#{pwd},#{name},#{sex},#{email},#{avatar},#{status})")
//    void addTeacher(Teacher teacher);
    //添加教师
    @Insert("insert into js(js_gh,js_mm,js_xm,js_xb,js_yx,js_zt) values(#{tno},#{pwd},#{name},#{sex},#{email},#{status})")
    void addTeacher(Teacher teacher);

    //修改教师信息
    @Update("<script>" +
            "update js" +
            "<set>" +
            "<if test='password!=null'> js_mm=#{password},</if>" +
            "<if test='name!=null'> js_xm=#{name},</if>" +
            "<if test='sex!=null'> js_xb=#{sex},</if>" +
            "<if test='email!=null'> js_yx=#{email},</if>" +
            "<if test='avatar!=null'> js_tx=#{avatar},</if>" +
            "<if test='status!=null'> js_zt=#{status},</if>" +
            "</set>" +
            "where js_gh=#{tno}" +
            "</script>")
    void UpdateTeacher(@Param("tno") String tno,@Param("password") String password,
                      @Param("name") String name,@Param("sex") String sex,@Param("email") String email,
                      @Param("avatar") String avatar,@Param("status") Integer status);

    //删除教师
    @Delete("delete from js where js_gh=#{tno}")
    int deleteTeacher(@Param("tno") String tno);



    //重置教师密码
    @Update("update js set js_mm=#{newpwd} where js_gh=#{username} and js_mm=#{oldpwd}")
    int updatePwd(@Param("username") String username,@Param("oldpwd") String oldpwd,@Param("newpwd") String newpwd);

    //管理员重置教师密码（无需知道用户密码）
    @Update("update js set js_mm='000000' where js_gh=#{username}")
    int updatePwdByAdmin(@Param("username") String usernamed);
}
