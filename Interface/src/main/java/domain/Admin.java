package domain;

public class Admin {
    private String adminAccount;
    private String adminPwd;

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminAccount='" + adminAccount + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                '}';
    }
}
