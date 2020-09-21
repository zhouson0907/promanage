package com.adtec.pay.entity;

public class ZKStatusEntity {
    private String status;
    private String EnName;
    private String Name;
    private String DTA;
    private String PartInst;
    private String Tenant;
    private String Version;
    private String SvrName;
    private String ProtocolType;
    private String NodeId;
    private COM_HTTP COM_HTTP;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnName() {
        return EnName;
    }

    public void setEnName(String enName) {
        EnName = enName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDTA() {
        return DTA;
    }

    public void setDTA(String DTA) {
        this.DTA = DTA;
    }

    public String getPartInst() {
        return PartInst;
    }

    public void setPartInst(String partInst) {
        PartInst = partInst;
    }

    public String getTenant() {
        return Tenant;
    }

    public void setTenant(String tenant) {
        Tenant = tenant;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getSvrName() {
        return SvrName;
    }

    public void setSvrName(String svrName) {
        SvrName = svrName;
    }

    public String getProtocolType() {
        return ProtocolType;
    }

    public void setProtocolType(String protocolType) {
        ProtocolType = protocolType;
    }

    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    public COM_HTTP getCOM_HTTP() {
        return COM_HTTP;
    }

    public void setCOM_HTTP(COM_HTTP COM_HTTP) {
        this.COM_HTTP = COM_HTTP;
    }
}
