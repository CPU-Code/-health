package com.cpucode.dao;

import com.cpucode.pojo.Setmeal;

import java.util.Map;

/**
 * @author : cpucode
 * @date : 2021/4/8
 * @time : 15:59
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String, Integer> map);
}
