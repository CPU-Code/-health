package com.cpucode.service;

import com.cpucode.entity.PageResult;
import com.cpucode.pojo.CheckItem;

import java.util.List;

/**
 * 检查项服务接口
 *
 * @author : cpucode
 * @date : 2021/3/29
 * @time : 13:00
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public interface CheckItemService {
    public void add(CheckItem checkItem);

    /**
     * 分页查询方法
     * @param currentPage
     * @param pageSize
     * @param queryString
     * @return
     */
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    /**
     * 删除方法
     *
     * @param id
     */
    public void deleteById(Integer id);

    public void edit(CheckItem checkItem);

    public CheckItem findById(Integer id);

    public List<CheckItem> findAll();
}
