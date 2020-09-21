package com.adtec.pay.entity;

public class COM_HTTP {
//    "COM_HTTP":{"IfKeepAlive":"N","Port":"8060","QueryStr":"","HostName":"10.10.10.10","URL":"http://10.10.10.10:8060/JavaFrame-web/HttpServer/MEDICAL_INPUT"},"PartId":"800002","PartVersion":"V1.0"}
    private String IfKeepAlive;
    private String Port;
    private String QueryStr;
    private String HostName;
    private String URL;
    private String PartId;
    private String PartVersion;

    public String getIfKeepAlive() {
        return IfKeepAlive;
    }

    public void setIfKeepAlive(String ifKeepAlive) {
        IfKeepAlive = ifKeepAlive;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String getQueryStr() {
        return QueryStr;
    }

    public void setQueryStr(String queryStr) {
        QueryStr = queryStr;
    }

    public String getHostName() {
        return HostName;
    }

    public void setHostName(String hostName) {
        HostName = hostName;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getPartId() {
        return PartId;
    }

    public void setPartId(String partId) {
        PartId = partId;
    }

    public String getPartVersion() {
        return PartVersion;
    }

    public void setPartVersion(String partVersion) {
        PartVersion = partVersion;
    }
}
