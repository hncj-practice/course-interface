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
}
