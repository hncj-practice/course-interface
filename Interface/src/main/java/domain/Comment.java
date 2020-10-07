package domain;

public class Comment {
    private Integer commentid;          //评论编号
    private String sno;             //学生学号
    private String sname;               //学生姓名
    private String savatar;             //学生头像
    private Integer topicid;            //话题编号
    private String commentcontent;  //评论内容
    private String commenttime;     //评论时间
    private Integer total;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

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

    public String getSavatar() {
        return savatar;
    }

    public void setSavatar(String savatar) {
        this.savatar = savatar;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", savatar='" + savatar + '\'' +
                ", topicid=" + topicid +
                ", commentcontent='" + commentcontent + '\'' +
                ", commenttime='" + commenttime + '\'' +
                ", total=" + total +
                '}';
    }
}
