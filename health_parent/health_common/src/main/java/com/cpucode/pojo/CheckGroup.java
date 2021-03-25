package com.cpucode.pojo;

import java.util.List;

/**
 * 检查组
 *
 * @author : cpucode
 * @date : 2021/3/25
 * @time : 16:10
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public class CheckGroup {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 助记
     */
    private String helpCode;
    /**
     * 适用性别
     */
    private String sex;
    /**
     * 介绍
     */
    private String remark;
    /**
     * 注意事项
     */
    private String attention;
    /**
     * 一个检查组合包含多个检查项
     */
    private List<CheckItem> checkItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelpCode() {
        return helpCode;
    }

    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }

    @Override
    public String toString() {
        return "CheckGroup{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", helpCode='" + helpCode + '\'' +
                ", sex='" + sex + '\'' +
                ", remark='" + remark + '\'' +
                ", attention='" + attention + '\'' +
                ", checkItems=" + checkItems +
                '}';
    }
}
