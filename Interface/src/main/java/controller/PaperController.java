package controller;

import dao.IDataDao;
import dao.IPaperDao;
import dao.IProblemDao;
import dao.IStudentDao;
import domain.Data;
import domain.Paper;
import domain.Problem;
import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//控制器类
@Controller
@RequestMapping(path = "/paper")
public class PaperController {


    /**
     * 添加试卷
     * @param paper
     * @return
     */
    @RequestMapping(path = "/addpaper",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addPaper(Paper paper){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IPaperDao paperDao=session.getMapper(IPaperDao.class);
        try {
            paperDao.addPaper(paper);
            session.commit();
            return APIResult.createOk("添加成功", paper);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 按课程编号查找试卷
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/getpaperbycourseid", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult GetPaperByCourseid(int courseid) {
        SqlSession session = util.MyBatis.getSession();
        IPaperDao paperDao = session.getMapper(IPaperDao.class);
        List<Paper> papers = paperDao.getPaperByCourseid(courseid);
        if (!papers.isEmpty()) {
            return APIResult.createOk("查找成功", papers);
        } else {
            return APIResult.createNg("查询结果为空");
        }
    }

    /**
     * 删除试卷
     * @param paperid
     * @return
     */
    @RequestMapping(path = "/delpaper", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeletePaper(int paperid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        IPaperDao paperDao = session.getMapper(IPaperDao.class);
        status=paperDao.delPaper(paperid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 向指定试卷中添加若干试题
     * @param paperid
     * @param problemids
     * @return
     */
    @RequestMapping(path = "/addproblems",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addProblems(int paperid,int [] problemids){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IPaperDao paperDao=session.getMapper(IPaperDao.class);
        try {
            paperDao.addProblemsToPaper(paperid,problemids);
            session.commit();
            return APIResult.createOk("添加成功", problemids);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 随机组卷
     * @param chapterid
     * @param num
     * @return
     */
    @RequestMapping(path = "/randomgenerate",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult RandomGenerate(Integer[] chapterid,Integer num,String type,Integer choice,Integer fill,Integer judge){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IProblemDao problemDao=session.getMapper(IProblemDao.class);
        List<Problem> returnproblems=new ArrayList<>();
        Random random=new Random();
        int idx;
        if(type.equals("1")){//随机组卷
            try {
                List<Problem> problems;
                problems=problemDao.getProblemByChapterid(chapterid,null);
                if(problems.size()<num){
                    return APIResult.createNg("题库题目不足，请添加题目或减少生成题目数量后重试");
                }
                for(int i=0;i<num;i++){//随机出num道题目
                    idx=random.nextInt(problems.size());
                    returnproblems.add(problems.get(idx));
                    problems.remove(idx);
                }
                return APIResult.createOk("随机生成成功", returnproblems);
            } catch (Exception e) {
                e.printStackTrace();
                return APIResult.createNg("随机生成失败");
            } finally {
                session.close();
            }
        }else if(type.equals("2")){//按各类型数量组卷
            //选择题
            if(choice!=null){
                List<Problem> choicelist=problemDao.getProblemByChapterid(chapterid, 1);
                if(choicelist.size()< choice){
                    return APIResult.createNg("题库中选择题不足，请确认后重试");
                }
                for(int i=0;i<choice;i++){//随机出choice道选择题目
                    idx=random.nextInt(choicelist.size());
                    returnproblems.add(choicelist.get(idx));
                    choicelist.remove(idx);
                }
            }
            //填空题
            if(fill!=null){
                List<Problem> filllist=problemDao.getProblemByChapterid(chapterid, 2);
                if(filllist.size()<fill){
                    return APIResult.createNg("题库中填空题不足，请确认后重试");
                }
                for(int i=0;i<fill;i++){//随机出fill道填空题目
                    idx=random.nextInt(filllist.size());
                    returnproblems.add(filllist.get(idx));
                    filllist.remove(idx);
                }
            }
            //判断题
            if(judge!=null){
                List<Problem> judgelist=problemDao.getProblemByChapterid(chapterid, 3);
                if(judgelist.size()<judge){
                    return APIResult.createNg("题库中判断题不足，请确认后重试");
                }
                for(int i=0;i<judge;i++){//随机出judge道判断题目
                    idx=random.nextInt(judgelist.size());
                    returnproblems.add(judgelist.get(idx));
                    judgelist.remove(idx);
                }
            }
            return APIResult.createOk("按类型数量生成成功",returnproblems);
        }else {
            return APIResult.createNg("参数不合法");
        }

    }

    /**
     * 发布试卷
     * 向所有学习本课程的学生添加试卷
     * @param paperid
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/releasepaper",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addProblems(int paperid,String courseid){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IPaperDao paperDao=session.getMapper(IPaperDao.class);
        try {
            paperDao.ReleasePaper(paperid,courseid);
            session.commit();
            return APIResult.createOk("发布成功", courseid);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("发布失败,请检查是否已发布");
        } finally {
            session.close();
        }
    }


    /**
     * 更新学生测验成绩
     * @param sno
     * @param paperid
     * @param grade
     * @return
     */
    @RequestMapping(path = "/updatetestgrade",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult UpdateTestGrade(String sno,int paperid,Float grade){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IPaperDao paperDao=session.getMapper(IPaperDao.class);
        try {
            paperDao.UpdateTestGrade(sno,paperid,grade);
            session.commit();
            return APIResult.createOKMessage("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("更新失败");
        } finally {
            session.close();
        }
    }

}
