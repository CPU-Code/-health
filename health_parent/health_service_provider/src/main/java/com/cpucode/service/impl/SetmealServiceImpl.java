package com.cpucode.service.impl;

import com.cpucode.dao.SetmealDao;
import com.cpucode.pojo.Setmeal;
import com.cpucode.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 体检套餐服务实现类
 *
 * @author : cpucode
 * @date : 2021/4/8
 * @time : 15:34
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;

    /**
     * 新增套餐
     * @param setmeal
     * @param checkgroupIds
     */
    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);

        if(checkgroupIds != null && checkgroupIds.length > 0){
            //绑定套餐和检查组的多对多关系
            setSetmealAndCheckGroup(setmeal.getId(),checkgroupIds);
        }
    }

    /**
     * 绑定套餐和检查组的多对多关系
     * @param id
     * @param checkgroupIds
     */
    private void setSetmealAndCheckGroup(Integer id, Integer[] checkgroupIds) {
        Map<String, Integer> map = null;

        for (Integer checkgroupId : checkgroupIds) {
            map = new HashMap<>();

            map.put("setmealId",id);
            map.put("checkgroupId",checkgroupId);

            setmealDao.setSetmealAndCheckGroup(map);
        }
    }
}
