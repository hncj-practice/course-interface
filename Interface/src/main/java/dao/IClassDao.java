package dao;

import domain.Admin;
import domain.Clase;
import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IClassDao {
    @Results(id = "classMap",value = {
            @Result(column = "bj_bh",property = "classid",id = true),
            @Result(column = "bj_mc",property = "classname")
    })
    //查询所有班级信息
    @Select("select * " +
            "from bj " +
            "${limit}")
    List<Clase> findAll(@Param("limit") String limit);

    //统计班级的总数
    @Select("select count(*) from bj")
    int Total();

    //添加班级
    @Insert("insert into bj values(#{classid},#{classname})")
    void addClase(Clase clase);





    //删除班级
    @Delete("delete from bj where bj_bh=#{classid}")
    int delClase(@Param("classid") String classid);

    //修改班级名称
    @Update("update bj set bj_mc=#{classname} where bj_bh=#{classid}")
    void changeClassname(@Param("classid") int classid,@Param("classname") String classname);
}
