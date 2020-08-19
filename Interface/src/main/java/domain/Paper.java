package domain;

public class Paper {
    private int paperid;        //试卷编号
    private int courseid;       //课程编号
    private String papername;   //试卷名称
    private int choicepoints;   //选择题分值
    private int judgepoints;    //判断题分值
    private int fillpoints;     //填空题分值
    private String starttime;   //考试开始时间
    private String endtime;     //考试结束时间
    private int status;         //试卷状态

    public int getPaperid() {
        return paperid;
    }

    public void setPaperid(int paperid) {
        this.paperid = paperid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public int getChoicepoints() {
        return choicepoints;
    }

    public void setChoicepoints(int choicepoints) {
        this.choicepoints = choicepoints;
    }

    public int getJudgepoints() {
        return judgepoints;
    }

    public void setJudgepoints(int judgepoints) {
        this.judgepoints = judgepoints;
    }

    public int getFillpoints() {
        return fillpoints;
    }

    public void setFillpoints(int fillpoints) {
        this.fillpoints = fillpoints;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperid=" + paperid +
                ", courseid=" + courseid +
                ", papername='" + papername + '\'' +
                ", choicepoints=" + choicepoints +
                ", judgepoints=" + judgepoints +
                ", fillpoints=" + fillpoints +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", status=" + status +
                '}';
    }
}
