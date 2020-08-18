package domain;

public class Data {
    private int dataid;         //资料编号
    private int courseid;       //课程编号
    private String dataname;    //资料名称
    private String datalink;    //资料链接

    public int getDataid() {
        return dataid;
    }

    public void setDataid(int dataid) {
        this.dataid = dataid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getDatalink() {
        return datalink;
    }

    public void setDatalink(String datalink) {
        this.datalink = datalink;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataid=" + dataid +
                ", courseid=" + courseid +
                ", dataname='" + dataname + '\'' +
                ", datalink='" + datalink + '\'' +
                '}';
    }
}
