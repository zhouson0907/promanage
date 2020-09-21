package com.adtec.base.user.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PrivilegeVo implements Serializable
{
    private String id;
    private String parentId;
    private String code;
    private String title;
    private String icon;
    private String sortNo;
    private String enable;
    private boolean checked;
    private String href;
    private List<PrivilegeVo> children =new LinkedList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<PrivilegeVo> getChildren() {
        return children;
    }

    public void setChildren(List<PrivilegeVo> children) {
        this.children = children;
    }
}
