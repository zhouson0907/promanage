package com.adtec.starring.element.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "DataElementTab",propOrder = {})
public class DataElementTab {

    @XmlElement(name = "DataElement")
    private DataElement dataElement;

    @XmlAttribute(name = "RecNum")
    private String recNum;

    public DataElement getDataElement() {
        return dataElement;
    }

    public void setDataElement(DataElement dataElement) {
        this.dataElement = dataElement;
    }

    public String getRecNum() {
        return recNum;
    }

    public void setRecNum(String recNum) {
        this.recNum = recNum;
    }
}
