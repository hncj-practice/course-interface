package domain;

public class Semester {
    private String semesterid;
    private String semestername;

    public String getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(String semesterid) {
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
                "semesterid='" + semesterid + '\'' +
                ", semestername='" + semestername + '\'' +
                '}';
    }
}
