package util;

import dao.IAdminDao;
import dao.ITeacherDao;
import domain.Admin;
import domain.Teacher;
import org.apache.ibatis.session.SqlSession;

public class AccountUtil {


    /**
     * 判断输入用户是否为管理员
     * @param username 用户名
     * @param password 密码
     * @return 该账户是否为管理员
     */
    public static boolean isAdmin(String username,String password){
        SqlSession session = util.MyBatis.getSession();
        IAdminDao adminDao=session.getMapper(IAdminDao.class);
        Admin admin=adminDao.findByAdminAndPwd(username,password);
        session.close();
        if(admin!=null){//是管理员
            System.out.println("是管理员");
            return true;
        }else{//不是管理员
            System.out.println("不是管理员");
            return false;
        }
    }

    /**
     * 判断输入用户是否为教师
     * @param username 用户名
     * @param password 密码
     * @return 该账户是否为教师
     */
    public static boolean isTeacher(String username,String password){
        SqlSession session = util.MyBatis.getSession();
        ITeacherDao teacherDao=session.getMapper(ITeacherDao.class);
        Teacher teacher=teacherDao.findByTnoAndPwd(username,password);
        session.close();
        if(teacher!=null){//是教师
            System.out.println("是教师");
            return true;
        }else{//不是教师
            System.out.println("不是教师");
            return false;
        }
    }
}
