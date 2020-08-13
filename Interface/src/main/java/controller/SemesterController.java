package controller;

import dao.IClassDao;
import dao.ISemesterDao;
import domain.Clase;
import domain.Semester;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

//控制器类
@Controller
@RequestMapping(path = "/semester")
public class SemesterController {
    /**
     * 添加学期
     * @param semester
     * @return
     */
    @RequestMapping(path = "/addsemester",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult addClass(Semester semester){
        //查询数据库
        SqlSession session=util.MyBatis.getSession();
        ISemesterDao semesterDao=session.getMapper(ISemesterDao.class);
        try {
            semesterDao.addSemester(semester);
            session.commit();
            return APIResult.createOk("添加成功", semester);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.createNg("添加失败");
        } finally {
            session.close();
        }
    }

    /**
     * 删除学期
     * @param semesterid
     * @return
     */
    @RequestMapping(path = "/delsemester", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept"})
    @ResponseBody
    public APIResult DeleteClase(String semesterid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        int status=0;       //学生
        ISemesterDao semesterDao = session.getMapper(ISemesterDao.class);
        status=semesterDao.delSemester(semesterid);
        session.commit();
        if(status!=0){
            return APIResult.createOKMessage("删除成功");
        }else{
            return APIResult.createNg("删除失败");
        }
    }
}
