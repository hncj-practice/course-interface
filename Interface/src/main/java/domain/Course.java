package domain;

public class Course {
    private int cid;
    private String semester;
    private String tno;
    private String cname;
    private String coverimg;
    private String status;
    private String snum;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", semester='" + semester + '\'' +
                ", tno='" + tno + '\'' +
                ", cname='" + cname + '\'' +
                ", coverimg='" + coverimg + '\'' +
                ", status='" + status + '\'' +
                ", snum='" + snum + '\'' +
                '}';
    }
}
