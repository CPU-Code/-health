package com.cpucode.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装对象
 *
 * @author : cpucode
 * @date : 2021/3/25
 * @time : 15:13
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public class PageResult implements Serializable {
    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页结果
     */
    private List rows;


    public PageResult(Long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
