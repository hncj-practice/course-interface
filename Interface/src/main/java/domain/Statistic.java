package domain;

public class Statistic {
    private String sno;             //学号
    private String sname;           //姓名
    private Integer commentnum;     //评论次数
    private Integer finpapernum;    //完成试卷数
    private Integer totalpapernum;  //总共试卷数
    private Float average;          //所有试卷的平均分

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

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public Integer getFinpapernum() {
        return finpapernum;
    }

    public void setFinpapernum(Integer finpapernum) {
        this.finpapernum = finpapernum;
    }

    public Integer getTotalpapernum() {
        return totalpapernum;
    }

    public void setTotalpapernum(Integer totalpapernum) {
        this.totalpapernum = totalpapernum;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", commentnum=" + commentnum +
                ", finpapernum=" + finpapernum +
                ", totalpapernum=" + totalpapernum +
                '}';
    }
}
