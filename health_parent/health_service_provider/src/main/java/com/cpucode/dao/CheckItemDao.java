package com.cpucode.dao;

import com.cpucode.pojo.CheckItem;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 持久层Dao接口
 *
 * @author : cpucode
 * @date : 2021/3/29
 * @time : 16:05
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public interface CheckItemDao {
    public void add(CheckItem checkItem);

    public Page<CheckItem> selectByCondition(String queryString);

    public void deleteById(Integer id);

    public long findCountByCheckItemId(Integer checkItemId);

    public void edit(CheckItem checkItem);

    public CheckItem findById(Integer id);

    public List<CheckItem> findAll();
}
