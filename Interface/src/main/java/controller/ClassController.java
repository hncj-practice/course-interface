package controller;

import dao.*;
import domain.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/class")
public class ClassController {
    /**
     * 添加班级
     * @param clase
     * @return
     */
    @RequestMapping(path = "/addclass",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addClass(Clase clase){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        try {
            classDao.addClase(clase);
            session.commit();
            return APIResult.createOk("添加成功", clase);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 删除班级
     * @param classid
     * @return
     */
    @RequestMapping(path = "/delclass", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String classid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;       //学生
        IClassDao classDao = session.getMapper(IClassDao.class);
        status=classDao.delClase(classid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }

    /**
     * 修改班级名称
     * @param classid    班级编号
     * @param classname      新的班级名称
     * @return
     */
    @RequestMapping(path = "/changeclassname",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult changeClassname(int classid,String classname){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        try {
            classDao.changeClassname(classid,classname);
            session.commit();
            return APIResult.createOKMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("修改失败");
        } finally {
            session.close();
        }
    }
}
