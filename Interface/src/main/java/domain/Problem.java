package domain;

public class Problem {
    private int pid;            //题目编号
    private int chapterid;      //章节编号
    private int ptype;          //题目类型
    private String question;     //题目题干
    private String panswer;     //题目答案

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getChapterid() {
        return chapterid;
    }

    public void setChapterid(int chapterid) {
        this.chapterid = chapterid;
    }

    public int getPtype() {
        return ptype;
    }

    public void setPtype(int ptype) {
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

    @Override
    public String toString() {
        return "Problem{" +
                "pid=" + pid +
                ", chapterid=" + chapterid +
                ", ptype=" + ptype +
                ", question='" + question + '\'' +
                ", panswer='" + panswer + '\'' +
                '}';
    }
}
