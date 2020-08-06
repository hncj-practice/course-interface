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


    @Select("select * from gly where gly_zh=#{username} and gly_mm=#{password}")
    @ResultMap(value = {"adminMap"})
    Admin findByTnoAndPwd(@Param("username") String username, @Param("password") String password);

}
