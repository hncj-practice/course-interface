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
//
////    public String getId() {
////        return id;
////    }
////
////    public void setId(String id) {
////        this.id = id;
////    }
//
//    public String getXs_xh() {
//        return xs_xh;
//    }
//
//    public void setXs_xh(String xs_xh) {
//        this.xs_xh = xs_xh;
//    }
//
//    public String getBj_bh() {
//        return bj_bh;
//    }
//
//    public void setBj_bh(String bj_bh) {
//        this.bj_bh = bj_bh;
//    }
//
//    public String getXs_mm() {
//        return xs_mm;
//    }
//
//    public void setXs_mm(String xs_mm) {
//        this.xs_mm = xs_mm;
//    }
//
//    public String getXs_xm() {
//        return xs_xm;
//    }
//
//    public void setXs_xm(String xs_xm) {
//        this.xs_xm = xs_xm;
//    }
//
//    public String getXs_xb() {
//        return xs_xb;
//    }
//
//    public void setXs_xb(String xs_xb) {
//        this.xs_xb = xs_xb;
//    }
//
//    public String getXs_yx() {
//        return xs_yx;
//    }
//
//    public void setXs_yx(String xs_yx) {
//        this.xs_yx = xs_yx;
//    }
//
//    public String getXs_tx() {
//        return xs_tx;
//    }
//
//    public void setXs_tx(String xs_tx) {
//        this.xs_tx = xs_tx;
//    }
//
//    public int getXs_zt() {
//        return xs_zt;
//    }
//
//    public void setXs_zt(int xs_zt) {
//        this.xs_zt = xs_zt;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
////                "id='" + id + '\'' +
//                ", xs_xh='" + xs_xh + '\'' +
//                ", bj_bh='" + bj_bh + '\'' +
//                ", xs_mm='" + xs_mm + '\'' +
//                ", xs_xm='" + xs_xm + '\'' +
//                ", xs_xb='" + xs_xb + '\'' +
//                ", xs_yx='" + xs_yx + '\'' +
//                ", xs_tx='" + xs_tx + '\'' +
//                ", xs_zt=" + xs_zt +
//                '}';
//    }
//}



package domain;

public class Student {
    //    private String id;
    private String sno;
    private String cla;
    private String pwd;
    private String name;
    private String sex;
    private String email;
    private String avatar;
    private int status;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
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
        return "Student{" +
                "sno='" + sno + '\'' +
                ", cla='" + cla + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status=" + status +
                '}';
    }
}
