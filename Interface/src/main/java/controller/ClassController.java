package controller;

import dao.IAdminDao;
import dao.IClassDao;
import dao.IStudentDao;
import dao.ITeacherDao;
import domain.Account;
import domain.Clase;
import domain.Course;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

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
}
