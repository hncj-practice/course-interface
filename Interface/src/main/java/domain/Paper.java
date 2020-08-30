package domain;

public class Paper {
    private Integer paperid;        //试卷编号
    private Integer courseid;       //课程编号
    private String papername;   //试卷名称
    private Integer choicepoints;   //选择题分值
    private Integer judgepoints;    //判断题分值
    private Integer fillpoints;     //填空题分值
    private String starttime;   //考试开始时间
    private String endtime;     //考试结束时间
    private Integer status;         //试卷状态

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public Integer getChoicepoints() {
        return choicepoints;
    }

    public void setChoicepoints(Integer choicepoints) {
        this.choicepoints = choicepoints;
    }

    public Integer getJudgepoints() {
        return judgepoints;
    }

    public void setJudgepoints(Integer judgepoints) {
        this.judgepoints = judgepoints;
    }

    public Integer getFillpoints() {
        return fillpoints;
    }

    public void setFillpoints(Integer fillpoints) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
