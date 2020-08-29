package dao;

import domain.Admin;
import domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAdminDao {
    @Results(id = "adminMap",value = {
            @Result(column = "gly_zh",property = "adminAccount",id = true),
            @Result(column = "gly_mm",property = "adminPwd"),
    })
    @Select("select * from gly")
    List<Admin> findAll();


    //管理员登录
    //也可用于判断传入账号是否为管理员账号
    @Select("select * from gly where gly_zh=#{username} and gly_mm=#{password}")
    @ResultMap(value = {"adminMap"})
    Admin findByAdminAndPwd(@Param("username") String username, @Param("password") String password);

    //添加管理员
    @Insert("insert into gly values(#{adminAccount},#{adminPwd})")
    void addAdmin(Admin admin);

    //删除管理员
    @Delete("delete from gly where gly_zh=#{username}")
    int deleteAdmin(@Param("username") String username);

    //重置管理员密码
    @Update("update gly set gly_mm=#{newpwd} where gly_zh=#{username} and gly_mm=#{oldpwd}")
    int updatePwd(@Param("username") String username,@Param("oldpwd") String oldpwd,@Param("newpwd") String newpwd);





}
