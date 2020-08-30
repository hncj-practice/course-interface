package domain;

public class Problem {
    private Integer pid;            //题目编号
    private Integer chapterid;      //章节编号
    private Integer ptype;          //题目类型
    private String question;    //题目题干
    private String panswer;     //题目答案

    private String ptypename;   //题目类型名称

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPanswer() {
        return panswer;
    }

    public void setPanswer(String panswer) {
        this.panswer = panswer;
    }

    public String getPtypename() {
        return ptypename;
    }

    public void setPtypename(String ptypename) {
        this.ptypename = ptypename;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "pid=" + pid +
                ", chapterid=" + chapterid +
                ", ptype=" + ptype +
                ", question='" + question + '\'' +
                ", panswer='" + panswer + '\'' +
                ", ptypename='" + ptypename + '\'' +
                '}';
    }
}
