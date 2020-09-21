package com.adtec.mintai.thirdPara.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class SysThirdPara {
    private String sysCode;

    private String sysName;

    private String stat;

    private String busiNo;

    private String sysNo;

    private String fileBathPath;

    private String ftpServer;

    private String ftpUser;

    private String ftpPasswd;

    private String ftpPort;

    private String encrypAlg;

    private String sysPublicKey;

    private String sysPrivateKey;

    private String createTime;

    private String createUser;

    private String updateTime;

    private String updateUser;

    private String remark1;

    private String remark2;

    private String remark3;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode == null ? null : sysCode.trim();
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getBusiNo() {
        return busiNo;
    }

    public void setBusiNo(String busiNo) {
        this.busiNo = busiNo == null ? null : busiNo.trim();
    }

    public String getSysNo() {
        return sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo == null ? null : sysNo.trim();
    }

    public String getFileBathPath() {
        return fileBathPath;
    }

    public void setFileBathPath(String fileBathPath) {
        this.fileBathPath = fileBathPath == null ? null : fileBathPath.trim();
    }

    public String getFtpServer() {
        return ftpServer;
    }

    public void setFtpServer(String ftpServer) {
        this.ftpServer = ftpServer == null ? null : ftpServer.trim();
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser == null ? null : ftpUser.trim();
    }

    public String getFtpPasswd() {
        return ftpPasswd;
    }

    public void setFtpPasswd(String ftpPasswd) {
        this.ftpPasswd = ftpPasswd == null ? null : ftpPasswd.trim();
    }

    public String getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(String ftpPort) {
        this.ftpPort = ftpPort == null ? null : ftpPort.trim();
    }

    public String getEncrypAlg() {
        return encrypAlg;
    }

    public void setEncrypAlg(String encrypAlg) {
        this.encrypAlg = encrypAlg == null ? null : encrypAlg.trim();
    }

    public String getSysPublicKey() {
        return sysPublicKey;
    }

    public void setSysPublicKey(String sysPublicKey) {
        this.sysPublicKey = sysPublicKey == null ? null : sysPublicKey.trim();
    }

    public String getSysPrivateKey() {
        return sysPrivateKey;
    }

    public void setSysPrivateKey(String sysPrivateKey) {
        this.sysPrivateKey = sysPrivateKey == null ? null : sysPrivateKey.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    @ResponseBody
    @RequestMapping(value = "/EditThird/editThirdPara", method = RequestMethod.POST)
    public String EditThirdParaMessage() {
        System.out.println("===================sysThirdPara.getFtpPort()====================="+ getFtpPort());
        return "success";
    }
}