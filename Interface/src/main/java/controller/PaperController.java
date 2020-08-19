package controller;

import dao.IDataDao;
import dao.IPaperDao;
import domain.Data;
import domain.Paper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

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
}
