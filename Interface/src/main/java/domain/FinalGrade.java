package domain;

//课程期末成绩
public class FinalGrade {
    private String coursename;      //课程名称
    private Float grade;            //课程期末成绩

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "FinalGrade{" +
                "coursename='" + coursename + '\'' +
                ", grade=" + grade +
                '}';
    }
}
