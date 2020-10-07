package controller;

import dao.IDataDao;
import domain.Data;
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
@RequestMapping(path = "/data")
public class DataController {


    /**
     * 添加资料
     * @param data
     * @return
     */
    @RequestMapping(path = "/adddata",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult addComment(Data data,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
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
     * 更新资料信息(资料名称、资料链接)
     * @param dataid    资料编号
     * @param name      资料名称
     * @param link      资料链接
     * @return
     */
    @RequestMapping(path = "/updatedata",method = {RequestMethod.POST},headers = {"Accept"})
    @ResponseBody
    public APIResult changeData(Integer dataid,String name,String link,Integer type,String user,String pwd){
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session=util.MyBatis.getSession();
        IDataDao dataDao=session.getMapper(IDataDao.class);
        try {
            dataDao.updateData(dataid,name,link,type);
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
     * 删除资料
     * @param dataid
     * @return
     */
    @RequestMapping(path = "/deldata", method = {RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteData(Integer dataid,String user,String pwd) {
        if(!AccountUtil.isAdmin(user,pwd)&&!AccountUtil.isTeacher(user,pwd))
            return APIResult.createNg("无操作权限");
        SqlSession session = util.MyBatis.getSession();
        int status=0;
        IDataDao dataDao = session.getMapper(IDataDao.class);
        status=dataDao.delData(dataid);
        session.commit();
        session.close();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 按课程号查找资料
     * @param courseid
     * @return
     */
    @RequestMapping(path = "/getdatabycourseid",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult GetDataByCourseid(Integer courseid,Integer page,Integer num){
        if(page==null||num==null){
            page=1;num=9999;
        }
        SqlSession session=util.MyBatis.getSession();
        IDataDao dataDao=session.getMapper(IDataDao.class);
        List<Data> comments=dataDao.getDataByCourseid(courseid,(page-1)*num,num);
        int total=0;
        total=dataDao.Total(courseid);
        session.close();
        if(!comments.isEmpty()&&total!=0){
            for(Data data:comments){
                data.setTotal(total);
            }
            return APIResult.createOk("查询成功",comments);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }


}
