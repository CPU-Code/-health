package com.cpucode.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cpucode.dao.CheckGroupDao;
import com.cpucode.pojo.CheckGroup;
import com.cpucode.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 检查组服务
 *
 * @author : cpucode
 * @date : 2021/4/1
 * @time : 16:18
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService{
    @Autowired
    private CheckGroupDao checkGroupDao;

    /**
     * 新增检查组，同时需要让检查组关联检查项
     * @param checkGroup
     * @param checkitemIds
     */
    public void add(CheckGroup checkGroup, Integer[] checkitemIds){
        //新增检查组，操作t_checkgroup表
        checkGroupDao.add(checkGroup);

        //设置检查组和检查项的多对多的关联关系，操作 t_checkgroup_checkitem 表
        Integer checkGroupId = checkGroup.getId();

        this.setCheckGroupAndCheckItem(checkGroupId, checkitemIds);
    }

    /**
     * 建立检查组和检查项多对多关系
     * @param checkGroupId
     * @param checkitemIds
     */
    public void setCheckGroupAndCheckItem(Integer checkGroupId, Integer[] checkitemIds){
        if(checkitemIds != null && checkitemIds.length > 0){
            for (Integer checkitemId : checkitemIds){
                Map<String,Integer> map = new HashMap<>();

                map.put("checkgroupId",checkGroupId);
                map.put("checkitemId",checkitemId);

                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }
}
