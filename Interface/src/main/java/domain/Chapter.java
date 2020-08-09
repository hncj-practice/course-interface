package domain;

public class Chapter {
    private int chapterid;          //章节号
    private int cid;                //课程号
    private String chaptername;     //章节名

    public int getChapterid() {
        return chapterid;
    }

    public void setChapterid(int chapterid) {
        this.chapterid = chapterid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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
                ", cno=" + cid +
                ", chaptername='" + chaptername + '\'' +
                '}';
    }
}
