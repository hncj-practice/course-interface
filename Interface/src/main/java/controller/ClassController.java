package controller;

import dao.*;
import domain.*;
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
@RequestMapping(path = "/class")
public class ClassController {
    /**
     * 添加班级
     * @param clase
     * @return
     */
    @RequestMapping(path = "/addclass",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addClass(Clase clase,String adminuser,String adminpwd){
        if(!AccountUtil.isAdmin(adminuser,adminpwd))
            return APIResult.createNg("无操作权限");
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
     * 查询所有的班级信息
     * @return
     */
    @RequestMapping(path = "/allclass",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult AllTeacher(Integer page,Integer num){
        //查询数据库
        String limit;
        if(page==null||num==null){
            limit="";
        }else{
            limit="limit "+(page-1)*num+","+num;
        }

        SqlSession session=util.MyBatis.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        List<Clase> clases=classDao.findAll(limit);
        int total=0;
        total=classDao.Total();
        session.close();
        if(!clases.isEmpty()&&total!=0){
            for(Clase clase:clases)
                clase.setTotal(total);
            return APIResult.createOk("查询成功",clases);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }


    /**
     * 删除班级
     * @param classid
     * @return
     */
    @RequestMapping(path = "/delclass", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String classid,String adminuser,String adminpwd) {
        if(!AccountUtil.isAdmin(adminuser,adminpwd))
            return APIResult.createNg("无操作权限");
        SqlSession session = util.MyBatis.getSession();
        int status=0;       //学生
        IClassDao classDao = session.getMapper(IClassDao.class);
        status=classDao.delClase(classid);
        session.commit();
        session.close();
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
    public APIResult changeClassname(String classid,String classname,String adminuser,String adminpwd){
        if(!AccountUtil.isAdmin(adminuser,adminpwd))
            return APIResult.createNg("无操作权限");
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
