package util;

import dao.IStudentDao;
import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatis {

    public static SqlSession getSession(){
//        InputStream in = Resources.class.getResourceAsStream("/mybatis-config.xml");
        InputStream in = MyBatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        System.out.println("#"+in);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        return factory.openSession();

    }

}
