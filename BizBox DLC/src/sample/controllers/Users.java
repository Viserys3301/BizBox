package sample.controllers;

public class Users {
    private String PK_appsysUsers;
    private String userName;
    private String FK_appsysUserGroups;
    private String usercode;
    private String logdate;
    private String systemHIS;
    private String systemClinic;
    private String systemAIS;
    private String lockHIS;
    private String lockClinic;
    private String lockAIS;
    private String lockaccount;

    public Users(String PK_appsysUsers, String userName, String FK_appsysUserGroups, String usercode, String logdate, String systemHIS, String systemClinic, String systemAIS, String lockHIS, String lockClinic, String lockAIS, String lockaccount) {
        this.PK_appsysUsers = PK_appsysUsers;
        this.userName = userName;
        this.FK_appsysUserGroups = FK_appsysUserGroups;
        this.usercode = usercode;
        this.logdate = logdate;
        this.systemHIS = systemHIS;
        this.systemClinic = systemClinic;
        this.systemAIS = systemAIS;
        this.lockHIS = lockHIS;
        this.lockClinic = lockClinic;
        this.lockAIS = lockAIS;
        this.lockaccount = lockaccount;
    }

    public String getPK_appsysUsers() {
        return PK_appsysUsers;
    }

    public void setPK_appsysUsers(String PK_appsysUsers) {
        this.PK_appsysUsers = PK_appsysUsers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFK_appsysUserGroups() {
        return FK_appsysUserGroups;
    }

    public void setFK_appsysUserGroups(String FK_appsysUserGroups) {
        this.FK_appsysUserGroups = FK_appsysUserGroups;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getLogdate() {
        return logdate;
    }

    public void setLogdate(String logdate) {
        this.logdate = logdate;
    }

    public String getSystemHIS() {
        return systemHIS;
    }

    public void setSystemHIS(String systemHIS) {
        this.systemHIS = systemHIS;
    }

    public String getSystemClinic() {
        return systemClinic;
    }

    public void setSystemClinic(String systemClinic) {
        this.systemClinic = systemClinic;
    }

    public String getSystemAIS() {
        return systemAIS;
    }

    public void setSystemAIS(String systemAIS) {
        this.systemAIS = systemAIS;
    }

    public String getLockHIS() {
        return lockHIS;
    }

    public void setLockHIS(String lockHIS) {
        this.lockHIS = lockHIS;
    }

    public String getLockClinic() {
        return lockClinic;
    }

    public void setLockClinic(String lockClinic) {
        this.lockClinic = lockClinic;
    }

    public String getLockAIS() {
        return lockAIS;
    }

    public void setLockAIS(String lockAIS) {
        this.lockAIS = lockAIS;
    }

    public String getLockaccount() {
        return lockaccount;
    }

    public void setLockaccount(String lockaccount) {
        this.lockaccount = lockaccount;
    }
}
