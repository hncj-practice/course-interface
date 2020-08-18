package dao;

import domain.Comment;
import domain.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IDataDao {
    @Select("select * from zl")
    List<Data> findAll();


    //添加资料
    @Insert("insert into zl(kc_bh,zl_mc,zl_lj) values(#{courseid},#{dataname},#{datalink})")
    void addData(Data data);

    //删除资料
    @Delete("delete from zl where zl_bh=#{dataid}")
    int delData(@Param("dataid") int dataid);
}
