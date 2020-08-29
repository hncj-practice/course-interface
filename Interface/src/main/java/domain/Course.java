package domain;

public class Course {
    private int cid;            //课程编号
    private int semester;       //学期编号
    private String tno;         //教师学号
    private String tname;       //教师姓名
    private String cname;       //课程名称
    private String coverimg;    //课程封面
    private String status;      //课程状态
    private String snum;        //学习本门课程的人数

    private Integer total;          //课程总数


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", semester='" + semester + '\'' +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", cname='" + cname + '\'' +
                ", coverimg='" + coverimg + '\'' +
                ", status='" + status + '\'' +
                ", snum='" + snum + '\'' +
                '}';
    }
}
