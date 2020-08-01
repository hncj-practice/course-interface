package dao;

import domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao {
    @Select("select * from xs")
    List<Student> findAll();

//    List<Movie> findZ3();
}
