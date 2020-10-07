package dao;

import domain.FinalGrade;
import domain.Grade;
import domain.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IGradeDao {
    @Results(id = "gradeMap",value = {
            @Result(column = "xs_xh",property = "sno",id = true),
            @Result(column = "xs_xm",property = "sname"),
            @Result(column = "sj_mc",property = "papername"),
            @Result(column = "xssj_cj",property = "grade")
    })
    //按班级编号查找某次测验的某班所有学生的成绩（按学号/成绩进行排序）
    @Select("select xssj.xs_xh,xs.xs_xm,sj.sj_mc,xssj.xssj_cj from xssj,xs,sj\n" +
            "where xssj.xs_xh in(select xs_xh from xs where bj_bh=#{classid}) and xssj.xs_xh=xs.xs_xh and xssj.sj_bh=sj.sj_bh and sj.sj_bh=#{paperid}\n" +
            "order by ${sorttype}")
    List<Grade> GetTestGradeByClassidAndPaperid(@Param("classid") String classid, @Param("paperid") Integer paperid, @Param("sorttype") String sorttype);


    //查询某学生某学期的全部课程的期末成绩
    @Select("select kc_mc,xskc_qmcj " +
            "from kc,xskc " +
            "where kc.kc_bh=xskc.kc_bh and xskc.xs_xh=#{sno} and xq_bh=#{semesterid} and kc.kc_bh in \n" +
            "(select kc_bh from xskc where xs_xh=#{sno});")
    @Results(value = {
            @Result(column = "kc_mc",property = "coursename"),
            @Result(column = "xskc_qmcj",property = "grade")
    })
    List<FinalGrade> getFinalGrade(@Param("sno") String sno, @Param("semesterid") Integer semesterid);

}
