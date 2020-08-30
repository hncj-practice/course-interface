package domain;

public class Semester {
    private Integer semesterid;
    private String semestername;

    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public String getSemestername() {
        return semestername;
    }

    public void setSemestername(String semestername) {
        this.semestername = semestername;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterid=" + semesterid +
                ", semestername='" + semestername + '\'' +
                '}';
    }
}
