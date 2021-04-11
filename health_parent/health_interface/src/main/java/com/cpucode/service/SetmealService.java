package com.cpucode.service;

import com.cpucode.entity.PageResult;
import com.cpucode.pojo.Setmeal;

/**
 * 体检套餐服务接口
 *
 * @author : cpucode
 * @date : 2021/4/8
 * @time : 11:38
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
}
