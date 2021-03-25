package com.cpucode.pojo;

import java.util.Date;

/**
 * 体检预约信息
 *
 * @author : cpucode
 * @date : 2021/3/25
 * @time : 15:32
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public class Order {
    public static final String ORDERTYPE_TELEPHONE = "电话预约";
    public static final String ORDERTYPE_WEIXIN = "微信预约";

    public static final String ORDERSTATUS_YES = "已到诊";
    public static final String ORDERSTATUS_NO = "未到诊";

    private Integer id;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 预约日期
     */
    private Date orderDate;
    /**
     * 预约类型 电话预约/微信预约
     */
    private String orderType;
    /**
     * 预约状态（是否到诊）
     */
    private String orderStatus;
    /**
     * 体检套餐id
     */
    private Integer setmealId;

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer memberId, Date orderDate, String orderType, String orderStatus, Integer setmealId) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.setmealId = setmealId;
    }

    public Order(Integer id, Integer memberId, Date orderDate, String orderType, String orderStatus, Integer setmealId) {
        this.id = id;
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.setmealId = setmealId;
    }

    public static String getOrdertypeTelephone() {
        return ORDERTYPE_TELEPHONE;
    }

    public static String getOrdertypeWeixin() {
        return ORDERTYPE_WEIXIN;
    }

    public static String getOrderstatusYes() {
        return ORDERSTATUS_YES;
    }

    public static String getOrderstatusNo() {
        return ORDERSTATUS_NO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getSetmealId() {
        return setmealId;
    }

    public void setSetmealId(Integer setmealId) {
        this.setmealId = setmealId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", orderDate=" + orderDate +
                ", orderType='" + orderType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", setmealId=" + setmealId +
                '}';
    }
}
