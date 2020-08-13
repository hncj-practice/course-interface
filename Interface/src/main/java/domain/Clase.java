package domain;

public class Clase {
    private String classid;
    private String classname;

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "classid='" + classid + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
