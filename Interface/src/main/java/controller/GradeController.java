package controller;

import dao.ICourseDao;
import dao.IGradeDao;
import domain.Course;
import domain.Grade;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

//控制器类
@Controller
@RequestMapping(path = "/grade")
public class GradeController {

    /**
     * 按班级编号查找某次测验的某班所有学生的成绩（按学号/成绩进行排序）
     * @param classid
     * @return
     */
    @RequestMapping(path = "/gettestgradebyclassidandpaperid",method = {RequestMethod.POST,RequestMethod.GET},headers = {"Accept"})
    @ResponseBody
    public APIResult GetTestGradeByClassidAndPaperid(String classid,Integer paperid,Integer sort){
        //查询数据库
        if(classid==null||paperid==null){//班级编号和试卷编号为必传参数
            return APIResult.createNg("参数不合法，请检查");
        }
        String sorttype;
        System.out.println(sort+"*******************************");
        if(sort==null){//默认按成绩降序查询
            sorttype=" xssj_cj desc";
        }else if(sort==0){//按成绩降序查询
            sorttype=" xssj_cj desc";
        }else if(sort==1){//按成绩升序查询
            sorttype=" xssj_cj ";
        }else if(sort==2){//按学号升序查询
            sorttype="xs_xh";
        }else if(sort==3){//按学号降序查询
            sorttype="xs_xh desc";
        }else {//带该参数，但参数不正确，则不允许查询
            return APIResult.createNg("参数不合法，请检查");
        }
        SqlSession session=util.MyBatis.getSession();
        IGradeDao gradeDao=session.getMapper(IGradeDao.class);
        List<Grade> grades=gradeDao.GetTestGradeByClassidAndPaperid(classid,paperid,sorttype);
        session.close();
        if(!grades.isEmpty()){
            return APIResult.createOk("查询成功",grades);
        }else{
            return APIResult.createNg("查询结果为空");
        }
    }
}
