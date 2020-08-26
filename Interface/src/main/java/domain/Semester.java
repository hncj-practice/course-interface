package domain;

public class Semester {
    private int semesterid;
    private String semestername;


    public int getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(int semesterid) {
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
