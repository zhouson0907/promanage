package com.adtec.starring.element.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "Item",propOrder = {})
public class Item {

    @XmlElement(name = "ScopeExpr")
    private String scopeExpr;
    // 属性名称
    @XmlAttribute(name = "ItemName")
    private String itemName;
    // 描述
    @XmlAttribute(name = "ItemDesc")
    private String itemDesc;

    // 类型
    @XmlAttribute(name = "ItemType")
    private String itemType;
    // 类型名称
    @XmlAttribute(name = "TypeName")
    private String typeName;

    @XmlAttribute(name = "ItemDeft")
    private String itemDeft;

    @XmlAttribute(name = "ElemType")
    private String elemType;

    // 是否数组
    @XmlAttribute(name = "Array")
    private String array;

    @XmlAttribute(name = "NodeType")
    private String nodeType;

    @XmlAttribute(name = "Security")
    private String security;

    @XmlAttribute(name = "EnumName")
    private String enumName;

    @XmlAttribute(name = "EnumKvp")
    private String enumKvp;

    @XmlAttribute(name = "RelateItemName")
    private String relateItemName;

    public String getScopeExpr() {
        return scopeExpr;
    }

    public void setScopeExpr(String scopeExpr) {
        this.scopeExpr = scopeExpr;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getItemDeft() {
        return itemDeft;
    }

    public void setItemDeft(String itemDeft) {
        this.itemDeft = itemDeft;
    }

    public String getElemType() {
        return elemType;
    }

    public void setElemType(String elemType) {
        this.elemType = elemType;
    }

    public String getArray() {
        return array;
    }

    public void setArray(String array) {
        this.array = array;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public String getEnumKvp() {
        return enumKvp;
    }

    public void setEnumKvp(String enumKvp) {
        this.enumKvp = enumKvp;
    }

    public String getRelateItemName() {
        return relateItemName;
    }

    public void setRelateItemName(String relateItemName) {
        this.relateItemName = relateItemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "scopeExpr='" + scopeExpr + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemType='" + itemType + '\'' +
                ", typeName='" + typeName + '\'' +
                ", itemDeft='" + itemDeft + '\'' +
                ", elemType='" + elemType + '\'' +
                ", array='" + array + '\'' +
                ", nodeType='" + nodeType + '\'' +
                ", security='" + security + '\'' +
                ", enumName='" + enumName + '\'' +
                ", enumKvp='" + enumKvp + '\'' +
                ", relateItemName='" + relateItemName + '\'' +
                '}';
    }
}
