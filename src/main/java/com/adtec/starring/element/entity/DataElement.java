package com.adtec.starring.element.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "DataElement",propOrder = {})
public class DataElement {

    @XmlAttribute(name = "DataType")
    private String dataType;

    // 数据对象名称
    @XmlAttribute(name = "ElemName")
    private String elemName;

    // 数据对象描述
    @XmlAttribute(name = "ElemDesc")
    private String elemDesc;

    @XmlAttribute(name = "NodeClassName")
    private String nodeClassName;

    @XmlAttribute(name = "NodeClassDesc")
    private String nodeClassDesc;

    // 数据对象节点名称
    @XmlAttribute(name = "XmlNodeName")
    private String xmlNodeName;

    @XmlElement(name = "ItemTab")
    private ItemTab itemTab;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getElemName() {
        return elemName;
    }

    public void setElemName(String elemName) {
        this.elemName = elemName;
    }

    public String getElemDesc() {
        return elemDesc;
    }

    public void setElemDesc(String elemDesc) {
        this.elemDesc = elemDesc;
    }

    public String getNodeClassName() {
        return nodeClassName;
    }

    public void setNodeClassName(String nodeClassName) {
        this.nodeClassName = nodeClassName;
    }

    public String getNodeClassDesc() {
        return nodeClassDesc;
    }

    public void setNodeClassDesc(String nodeClassDesc) {
        this.nodeClassDesc = nodeClassDesc;
    }

    public String getXmlNodeName() {
        return xmlNodeName;
    }

    public void setXmlNodeName(String xmlNodeName) {
        this.xmlNodeName = xmlNodeName;
    }

    public ItemTab getItemTab() {
        return itemTab;
    }

    public void setItemTab(ItemTab itemTab) {
        this.itemTab = itemTab;
    }
}
