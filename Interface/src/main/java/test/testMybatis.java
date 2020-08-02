package test;

import dao.IStudentDao;
import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testMybatis {
    public static void main(String[] args) {
        System.out.println("start");
        InputStream in = Resources.class.getResourceAsStream("/mybatis-config.xml");
        System.out.println(in);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        IStudentDao studentDao=session.getMapper(IStudentDao.class);


        List<Student> students=studentDao.findAll();

        for (Student student : students) {
            System.out.println(student.toString());
        }

        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
