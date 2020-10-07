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
            @Result(column = "sj_mc",property = "papername"),
            @Result(column = "sj_xzfz",property = "choicepoints"),
            @Result(column = "sj_pdfz",property = "judgepoints"),
            @Result(column = "sj_tkfz",property = "fillpoints"),
            @Result(column = "sj_kssj",property = "starttime"),
            @Result(column = "sj_jssj",property = "endtime"),
            @Result(column = "sj_zt",property = "status"),
            @Result(column = "xssj_zt",property = "spstatus")
    })
    @Select("select * from sj")
    List<Paper> findAll();


    //添加试卷
    @SelectKey(statement="select last_insert_id();",before=false,keyColumn="sj_bh",resultType=int.class,keyProperty="paperid")
    @Insert("insert into sj(kc_bh,sj_mc,sj_xzfz,sj_pdfz,sj_tkfz,sj_kssj,sj_jssj,sj_zt) values(#{courseid},#{papername},#{choicepoints},#{judgepoints},#{fillpoints},#{starttime},#{endtime},#{status})")
    void addPaper(Paper paper);

    //按课程号查找试卷
    @Select("select * from sj " +
            "where kc_bh=#{courseid}")
    @ResultMap(value = {"paperMap"})
    List<Paper> getPaperByCourseid(@Param("courseid") Integer courseid);

    //按课程号和学生号查找试卷
    @Select("select sj.sj_bh,sj.kc_bh,sj.sj_mc,sj.sj_xzfz,sj.sj_pdfz,sj.sj_tkfz,sj.sj_kssj,sj.sj_jssj,sj.sj_zt,xssj.xssj_zt \n" +
            "from sj,xssj\n" +
            "where xssj.xs_xh=#{sno} and sj.sj_bh=xssj.sj_bh and kc_bh=#{courseid};")
    @ResultMap(value = {"paperMap"})
    List<Paper> getPaperByCourseidAndSno(@Param("courseid") Integer courseid,@Param("sno") String sno);

    //查找某学生学习所有课程的所有试卷
//    @Select("select * from sj where kc_bh in " +
//            "(select kc_bh from xskc where xs_xh=#{sno}) ")
    @Select("select sj.sj_bh,sj.kc_bh,sj.sj_mc,sj.sj_xzfz,sj.sj_pdfz,sj.sj_tkfz,sj.sj_kssj,sj.sj_jssj,sj.sj_zt,xssj.xssj_zt " +
            "from sj,xssj where sj.sj_bh=xssj.sj_bh and xssj.xs_xh=#{sno} and kc_bh " +
            "in (select kc_bh from xskc where xs_xh=#{sno})")
    @ResultMap(value = {"paperMap"})
    List<Paper> findPaperBySno(@Param("sno") String sno);

    //查找某学生某次测试的成绩
    @Select("select xssj_cj from xssj where xs_xh=#{sno} and sj_bh=#{paperid};")
    Float findScoreBySnoAndPaperid(@Param("sno") String sno,@Param("paperid") Integer paperid);


    //修改试卷
    @Update("<script>" +
            "update sj" +
            "<set>" +
            "<if test='name!=null'> sj_mc=#{name},</if>" +
            "<if test='choice!=null'> sj_xzfz=#{choice},</if>" +
            "<if test='judge!=null'> sj_pdfz=#{judge},</if>" +
            "<if test='fill!=null'> sj_tkfz=#{fill},</if>" +
            "<if test='starttime!=null'> sj_kssj=#{starttime},</if>" +
            "<if test='endtime!=null'> sj_jssj=#{endtime},</if>" +
            "<if test='status!=null'> sj_zt=#{status},</if>" +
            "</set>" +
            "where sj_bh=#{paperid}" +
            "</script>")
    void UpdatePaper(@Param("paperid") Integer paperid,@Param("name") String name,@Param("choice") Integer choice,@Param("judge") Integer judge,@Param("fill") Integer fill,@Param("status") Integer status,@Param("starttime") String starttime,@Param("endtime") String endtime);


    //删除试卷
    @Delete("delete from sj where sj_bh=#{paperid}")
    int delPaper(@Param("paperid") Integer paperid);

    //向指定试卷中添加若干试题（手动组卷）
    @Insert("<script>"  +
            "INSERT INTO sjst(sj_bh,tm_bh) VALUES" +
            "<foreach collection=\"problemids\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{paperid},#{item})" +
            "</foreach>" +
            "</script>")
    void addProblemsToPaper(@Param("paperid") Integer paperid,@Param("problemids") Integer [] problemids);


    //教师发布时间
    //向所有学习本课程的学生添加试卷
    @Insert("insert into xssj(xs_xh,sj_bh) select xs_xh,#{paperid} from xskc\n" +
            "where kc_bh=#{courseid};")
    void ReleasePaper(@Param("paperid") Integer paperid,@Param("courseid") Integer courseid);


    //更新学生测验成绩
    @Update("update xssj set xssj_cj=#{grade},xssj_zt=1 where xs_xh=#{sno} and sj_bh=#{paperid}")
    void UpdateTestGrade(@Param("sno") String sno,@Param("paperid") Integer paperid,@Param("grade") Float grade);
}
