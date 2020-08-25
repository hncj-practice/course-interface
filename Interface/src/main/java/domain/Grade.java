package domain;

public class Grade {

    private String sno;         //学号
    private String sname;       //姓名
    private String papername;   //试卷名称
    private float grade;        //测验成绩

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", papername='" + papername + '\'' +
                ", grade=" + grade +
                '}';
    }
}
