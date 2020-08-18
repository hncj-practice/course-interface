package controller;

import dao.ICommentDao;
import dao.IProblemDao;
import domain.Comment;
import domain.Problem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

//控制器类
@Controller
@RequestMapping(path = "/problem")
public class ProblemController {


    /**
     * 添加题目
     * @param problem
     * @return
     */
    @RequestMapping(path = "/addproblem",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addComment(Problem problem){
        //查询数据库
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
     * 删除题目
     * @param problemid
     * @return
     */
    @RequestMapping(path = "/delproblem", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteProblem(String problemid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        IProblemDao problemDao = session.getMapper(IProblemDao.class);
        status=problemDao.delProblem(problemid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }
}
