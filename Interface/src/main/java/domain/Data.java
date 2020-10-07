package domain;

public class Data {
    private Integer dataid;         //资料编号
    private Integer courseid;       //课程编号
    private String dataname;    //资料名称
    private String datalink;    //资料链接
    private Integer datatype;       //资料类型
    private Integer total;

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
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

    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataid=" + dataid +
                ", courseid=" + courseid +
                ", dataname='" + dataname + '\'' +
                ", datalink='" + datalink + '\'' +
                ", datatype=" + datatype +
                ", total=" + total +
                '}';
    }
}
