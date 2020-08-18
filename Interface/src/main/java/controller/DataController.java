package controller;

import dao.ICommentDao;
import dao.IDataDao;
import domain.Comment;
import domain.Data;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

//控制器类
@Controller
@RequestMapping(path = "/data")
public class DataController {


    /**
     * 添加资料
     * @param data
     * @return
     */
    @RequestMapping(path = "/adddata",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addComment(Data data){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IDataDao dataDao=session.getMapper(IDataDao.class);
        try {
            dataDao.addData(data);
            session.commit();
            return APIResult.createOk("添加成功", data);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 删除资料
     * @param dataid
     * @return
     */
    @RequestMapping(path = "/deldata", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteData(int dataid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        IDataDao dataDao = session.getMapper(IDataDao.class);
        status=dataDao.delData(dataid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }
}
