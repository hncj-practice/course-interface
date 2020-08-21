package dao;

import domain.Data;
import domain.Paper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPaperDao {
    @Select("select * from sj")
    List<Paper> findAll();


    //添加试卷
    @Insert("insert into sj(kc_bh,sj_mc,sj_xzfz,sj_pdfz,sj_tkfz,sj_kssj,sj_jssj,sj_zt) values(#{courseid},#{papername},#{choicepoints},#{judgepoints},#{fillpoints},#{starttime},#{endtime},#{status})")
    void addPaper(Paper data);

    //删除试卷
    @Delete("delete from sj where sj_bh=#{paperid}")
    int delPaper(@Param("paperid") int paperid);

    //向指定试卷中添加若干试题
    @Insert("<script>"  +
            "INSERT INTO sjst(sj_bh,tm_bh) VALUES" +
            "<foreach collection=\"problemids\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{paperid},#{item})" +
            "</foreach>" +
            "</script>")
    void addProblemsToPaper(@Param("paperid") int paperid,@Param("problemids") int [] problemids);
}
