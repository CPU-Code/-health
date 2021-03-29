package com.cpucode.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cpucode.dao.CheckItemDao;
import com.cpucode.pojo.CheckItem;
import com.cpucode.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 检查项服务
 *
 * @author : cpucode
 * @date : 2021/3/29
 * @time : 16:03
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    CheckItemDao checkItemDao;

    /**
     * 新增
     * @param checkItem
     */
    public void add(CheckItem checkItem){
        checkItemDao.add(checkItem);
    }
}
