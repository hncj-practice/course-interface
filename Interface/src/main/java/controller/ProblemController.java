package controller;

import dao.ICommentDao;
import dao.ICourseDao;
import dao.IProblemDao;
import domain.Comment;
import domain.Course;
import domain.Problem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;
import util.AccountUtil;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/problem")
public class ProblemController {


    /**
     * 添加题目
     * @param problem
     * @return
     */
    @RequestMapping(path = "/addproblem",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult addComment(Problem problem,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        IProblemDao problemDao=session.getMapper(IProblemDao.class);
        try {
            problemDao.addProblem(problem);
            session.commit();
            return APIResult.createOk("添加成功", problem);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 修改题目信息
     * @param problemid
     * @param ptype
     * @param content
     * @param answer
     * @return
     */
    @RequestMapping(path = "/updateproblem",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult changeData(Integer problemid,Integer ptype,String content,String answer,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        IProblemDao problemDao=session.getMapper(IProblemDao.class);
        try {
            problemDao.UpdateCourse(problemid,ptype,content,answer);
            session.commit();
            return APIResult.createOKMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("修改失败");
        } finally {
            session.close();
        }
    }

    /**
     * 删除题目
     * @param problemid
     * @return
     */
    @RequestMapping(path = "/delproblem", method = {RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteProblem(String problemid,String user,String pwd) {
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        IProblemDao problemDao = session.getMapper(IProblemDao.class);
        status=problemDao.delProblem(problemid);
        session.commit();
        session.close();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 按章节编号查找题目
     * @param chapterid
     * @return
     */
    @RequestMapping(path = "/getproblembychapterid",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult GetProblemByChapterid(Integer[] chapterid,Integer type,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        IProblemDao problemDao=session.getMapper(IProblemDao.class);
        List<Problem> problems=problemDao.getProblemByChapterid(chapterid,type);
        session.close();
        if(!problems.isEmpty()){
            return APIResult.createOk("查询成功",problems);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }

    /**
     * 按试卷编号查找题目
     * @param paperid
     * @return
     */
    @RequestMapping(path = "/getproblembypaperid",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult GetProblemByPaperid(Integer paperid,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        IProblemDao problemDao=session.getMapper(IProblemDao.class);
        List<Problem> problems=problemDao.getProblemByPaperid(paperid);
        session.close();
        if(!problems.isEmpty()){
            return APIResult.createOk("查询成功",problems);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }
}
