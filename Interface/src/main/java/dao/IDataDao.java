package dao;

import domain.Comment;
import domain.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDataDao {
    @Results(id = "dataMap",value = {
            @Result(column = "zl_bh",property = "dataid",id = true),
            @Result(column = "kc_bh",property = "courseid"),
            @Result(column = "zl_mc",property = "dataname"),
            @Result(column = "zl_lj",property = "datalink")
    })
    @Select("select * " +
            "from zl " +
            "limit #{start},#{end};")
    List<Data> findAll(@Param("start") int start, @Param("end") int end);


    //添加资料
    @Insert("insert into zl(kc_bh,zl_mc,zl_lj) values(#{courseid},#{dataname},#{datalink})")
    void addData(Data data);

    //删除资料
    @Delete("delete from zl where zl_bh=#{dataid}")
    int delData(@Param("dataid") int dataid);

    //按课程号查找资料
    @Select("select * from zl " +
            "where kc_bh=#{courseid} " +
            "limit #{start},#{end}")
    @ResultMap(value = {"dataMap"})
    List<Data> getDataByCourseid(@Param("courseid") int courseid,@Param("start") int start, @Param("end") int end);

    //统计某话题下的评论总数
    @Select("select count(*) from zl where kc_bh=#{courseid}")
    int Total(@Param("courseid") int courseid);

    //修改资料(资料名、资料链接)
    @Update("update zl set zl_mc=#{name},zl_lj=#{link} where zl_bh=#{dataid}")
    void changeData(@Param("dataid") int dataid,@Param("name") String name,@Param("link") String link);
}
