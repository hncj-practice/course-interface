package domain;

public class Topic {
    private String name;            //话题发布人
    private String avatar;          //话题发布人头像
    private int topicid;            //话题编号
    private int courseid;           //课程编号
    private String topictitle;      //话题标题
    private String topiccontent;    //话题内容
    private String committime;      //话题发布时间
    private int topicstatus;        //话题状态

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

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
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", topicid=" + topicid +
                ", courseid=" + courseid +
                ", topictitle='" + topictitle + '\'' +
                ", topiccontent='" + topiccontent + '\'' +
                ", committime='" + committime + '\'' +
                ", topicstatus=" + topicstatus +
                '}';
    }
}
