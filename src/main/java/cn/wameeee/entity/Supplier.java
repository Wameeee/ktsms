package cn.wameeee.entity;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable {

    private static final long serialVersionUID = 4183573755631564473L;

    private Long id ;
    private String supCode;
    private String supName;
    private String supDesc;
    private String supContact;
    private String supPhone;
    private String supFax;
    private String bizPicPath;
    private Long createdUserId;
    private Date createdTime;
    private Long updatedUserId;
    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupDesc() {
        return supDesc;
    }

    public void setSupDesc(String supDesc) {
        this.supDesc = supDesc;
    }

    public String getSupContact() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact = supContact;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public String getSupFax() {
        return supFax;
    }

    public void setSupFax(String supFax) {
        this.supFax = supFax;
    }

    public String getBizPicPath() {
        return bizPicPath;
    }

    public void setBizPicPath(String bizPicPath) {
        this.bizPicPath = bizPicPath;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
