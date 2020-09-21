package com.adtec.mintai.file.entity;

public class SysFile {
    private String sysCode;

    private String platDate;

    private String fileSer;

    private String fileNm;

    private String fileType;

    private String stat;

    private String filePath;

    private String crtTime;

    private String uptTime;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode == null ? null : sysCode.trim();
    }

    public String getPlatDate() {
        return platDate;
    }

    public void setPlatDate(String platDate) {
        this.platDate = platDate == null ? null : platDate.trim();
    }

    public String getFileSer() {
        return fileSer;
    }

    public void setFileSer(String fileSer) {
        this.fileSer = fileSer == null ? null : fileSer.trim();
    }

    public String getFileNm() {
        return fileNm;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm == null ? null : fileNm.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime == null ? null : crtTime.trim();
    }

    public String getUptTime() {
        return uptTime;
    }

    public void setUptTime(String uptTime) {
        this.uptTime = uptTime == null ? null : uptTime.trim();
    }
}