package dao;

import domain.Comment;
import domain.Problem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProblemDao {
    @Select("select * from tm")
    List<Problem> findAll();


    //添加题目
    @Insert("insert into tm(zj_bh,tmlx_bh,tm_tg,tm_da) values(#{chapterid},#{ptype},#{question},#{panswer})")
    void addProblem(Problem problem);

    //删除题目
    @Delete("delete from tm where tm_bh=#{problemid}")
    int delProblem(@Param("problemid") String problemid);
}
