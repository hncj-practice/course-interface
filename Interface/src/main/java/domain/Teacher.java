//package domain;
//
//public class Student {
////    private String id;
//    private String xs_xh;
//    private String bj_bh;
//    private String xs_mm;
//    private String xs_xm;
//    private String xs_xb;
//    private String xs_yx;
//    private String xs_tx;
//    private int xs_zt;




package domain;

public class Teacher {
    private String tno;
    private String pwd;
    private String name;
    private String sex;
    private String email;
    private String avatar;
    private int status;
//    private String js_xh;
//    private String js_mm;
//    private String js_xm;
//    private String js_xb;
//    private String js_yx;
//    private String js_tx;
//    private int js_zt;

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "js_xh='" + js_xh + '\'' +
//                ", js_mm='" + js_mm + '\'' +
//                ", js_xm='" + js_xm + '\'' +
//                ", js_xb='" + js_xb + '\'' +
//                ", js_yx='" + js_yx + '\'' +
//                ", js_tx='" + js_tx + '\'' +
//                ", js_zt=" + js_zt +
//                '}';
//    }
//
//    public String getJs_xh() {
//        return js_xh;
//    }
//
//    public void setJs_xh(String js_xh) {
//        this.js_xh = js_xh;
//    }
//
//    public String getJs_mm() {
//        return js_mm;
//    }
//
//    public void setJs_mm(String js_mm) {
//        this.js_mm = js_mm;
//    }
//
//    public String getJs_xm() {
//        return js_xm;
//    }
//
//    public void setJs_xm(String js_xm) {
//        this.js_xm = js_xm;
//    }
//
//    public String getJs_xb() {
//        return js_xb;
//    }
//
//    public void setJs_xb(String js_xb) {
//        this.js_xb = js_xb;
//    }
//
//    public String getJs_yx() {
//        return js_yx;
//    }
//
//    public void setJs_yx(String js_yx) {
//        this.js_yx = js_yx;
//    }
//
//    public String getJs_tx() {
//        return js_tx;
//    }
//
//    public void setJs_tx(String js_tx) {
//        this.js_tx = js_tx;
//    }
//
//    public int getJs_zt() {
//        return js_zt;
//    }
//
//    public void setJs_zt(int js_zt) {
//        this.js_zt = js_zt;
//    }


    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status=" + status +
                '}';
    }
}
