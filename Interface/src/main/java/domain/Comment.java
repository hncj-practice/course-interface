package domain;

public class Comment {
    private Integer commentid;          //评论编号
    private String sno;             //学生学号
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
                ", topicid=" + topicid +
                ", commentcontent='" + commentcontent + '\'' +
                ", commenttime='" + commenttime + '\'' +
                ", total=" + total +
                '}';
    }
}
