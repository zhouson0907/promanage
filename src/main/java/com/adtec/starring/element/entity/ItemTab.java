package com.adtec.starring.element.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "ItemTab",propOrder = {})
public class ItemTab {

    @XmlAttribute(name = "RecNum")
    private String recNum;

    @XmlElement(name = "Item")
    private List<Item> item;

    public String getRecNum() {
        return recNum;
    }

    public void setRecNum(String recNum) {
        this.recNum = recNum;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

}
