package domain;

public class Topic {
    private int topicid;            //话题编号
    private int courseid;           //课程编号
    private String topictitle;      //话题标题
    private String topiccontent;    //话题内容
    private String committime;      //话题发布时间
    private int topicstatus;        //话题状态

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getTopictitle() {
        return topictitle;
    }

    public void setTopictitle(String topictitle) {
        this.topictitle = topictitle;
    }

    public String getTopiccontent() {
        return topiccontent;
    }

    public void setTopiccontent(String topiccontent) {
        this.topiccontent = topiccontent;
    }

    public String getCommittime() {
        return committime;
    }

    public void setCommittime(String committime) {
        this.committime = committime;
    }

    public int getTopicstatus() {
        return topicstatus;
    }

    public void setTopicstatus(int topicstatus) {
        this.topicstatus = topicstatus;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicid=" + topicid +
                ", courseid=" + courseid +
                ", topictitle='" + topictitle + '\'' +
                ", topiccontent='" + topiccontent + '\'' +
                ", committime='" + committime + '\'' +
                ", topicstatus=" + topicstatus +
                '}';
    }
}
