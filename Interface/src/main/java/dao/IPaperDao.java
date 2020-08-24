package dao;

import domain.Data;
import domain.Paper;
import domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IPaperDao {
    @Results(id = "paperMap", value = {
            @Result(column = "sj_bh",property = "paperid",id = true),
            @Result(column = "kc_bh",property = "courseid"),
            @Result(column = "js_mc",property = "papername"),
            @Result(column = "sj_xzfz",property = "choicepoints"),
            @Result(column = "sj_pdfz",property = "judgepoints"),
            @Result(column = "sj_tkfz",property = "fillpoints"),
            @Result(column = "sj_kssj",property = "starttime"),
            @Result(column = "sj_jssj",property = "endtime"),
            @Result(column = "sj_zt",property = "status")
    })
    @Select("select * from sj")
    List<Paper> findAll();


    //添加试卷
    @Insert("insert into sj(kc_bh,sj_mc,sj_xzfz,sj_pdfz,sj_tkfz,sj_kssj,sj_jssj,sj_zt) values(#{courseid},#{papername},#{choicepoints},#{judgepoints},#{fillpoints},#{starttime},#{endtime},#{status})")
    void addPaper(Paper data);

    //按课程号查找试卷
    @Select("select * from sj " +
            "where kc_bh=#{courseid}")
    @ResultMap(value = {"paperMap"})
    List<Paper> getPaperByCourseid(@Param("courseid") int courseid);

    //删除试卷
    @Delete("delete from sj where sj_bh=#{paperid}")
    int delPaper(@Param("paperid") int paperid);

    //向指定试卷中添加若干试题（手动组卷）
    @Insert("<script>"  +
            "INSERT INTO sjst(sj_bh,tm_bh) VALUES" +
            "<foreach collection=\"problemids\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{paperid},#{item})" +
            "</foreach>" +
            "</script>")
    void addProblemsToPaper(@Param("paperid") int paperid,@Param("problemids") int [] problemids);


    //教师发布时间
    //向所有学习本课程的学生添加试卷
    @Insert("insert into xssj(xs_xh,sj_bh) select xs_xh,#{paperid} from xskc\n" +
            "where kc_bh=#{courseid};")
    void ReleasePaper(@Param("paperid") int paperid,@Param("courseid") String courseid);


    //更新学生测验成绩
    @Update("update xssj set xssj_cj=#{grade} where xs_xh=#{sno} and sj_bh=#{paperid}")
    void UpdateTestGrade(@Param("sno") String sno,@Param("paperid") int paperid,@Param("grade") Float grade);
}
