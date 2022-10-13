package entity;

public class Admin {
    private Integer admId;

    private String admAcct;

    private String admPswd;

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmAcct() {
        return admAcct;
    }

    public void setAdmAcct(String admAcct) {
        this.admAcct = admAcct == null ? null : admAcct.trim();
    }

    public String getAdmPswd() {
        return admPswd;
    }

    public void setAdmPswd(String admPswd) {
        this.admPswd = admPswd == null ? null : admPswd.trim();
    }

    public Admin() {}

    public Admin(Integer admId, String admAcct, String admPswd) {
        this.admId = admId;
        this.admAcct = admAcct;
        this.admPswd = admPswd;
    }

    @Override
    public String toString() {
        return "entity.Admin{" +
                "admId=" + admId +
                ", admAcct='" + admAcct + '\'' +
                ", admPswd='" + admPswd + '\'' +
                '}';
    }
}