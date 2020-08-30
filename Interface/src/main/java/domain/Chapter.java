package domain;

public class Chapter {
    private Integer chapterid;          //章节号
    private Integer courseid;           //课程号
    private String chaptername;     //章节名

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterid=" + chapterid +
                ", cno=" + courseid +
                ", chaptername='" + chaptername + '\'' +
                '}';
    }
}
