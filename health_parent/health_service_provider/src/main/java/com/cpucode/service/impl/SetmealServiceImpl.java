package com.cpucode.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cpucode.constant.RedisConstant;
import com.cpucode.dao.SetmealDao;
import com.cpucode.pojo.Setmeal;
import com.cpucode.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

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
@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;

    @Autowired
    private JedisPool jedisPool;

    /**
     * 新增套餐信息，同时需要关联检查组
     * @param setmeal
     * @param checkgroupIds
     */
    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);

        Integer setmealId = setmeal.getId();

        if(checkgroupIds != null && checkgroupIds.length > 0){
            //绑定套餐和检查组的多对多关系
            setSetmealAndCheckGroup(setmealId, checkgroupIds);
        }

        //将图片名称保存到Redis
        savePic2Redis(setmeal.getImg());
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

    /**
     * 将图片名称保存到 Redis
     *
     * @param pic
     */
    private void savePic2Redis(String pic){
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, pic);
    }
}
