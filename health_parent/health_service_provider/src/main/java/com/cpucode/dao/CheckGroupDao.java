package com.cpucode.dao;

import com.cpucode.pojo.CheckGroup;
import com.github.pagehelper.Page;

import java.util.Map;

/**
 *  持久层Dao接口
 *
 * @author : cpucode
 * @date : 2021/4/1
 * @time : 16:19
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public interface CheckGroupDao {
    public void add(CheckGroup checkGroup);
    public void setCheckGroupAndCheckItem(Map map);
    public Page<CheckGroup> selectByCondition(String queryString);
}
