package domain;

public class Comment {
    private int commentid;          //评论编号
    private String sno;             //学生学号
    private int topicid;            //话题编号
    private String commentcontent;  //评论内容
    private String commenttime;     //评论时间

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
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

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", sno='" + sno + '\'' +
                ", topicid=" + topicid +
                ", commentcontent='" + commentcontent + '\'' +
                ", commenttime='" + commenttime + '\'' +
                '}';
    }
}
