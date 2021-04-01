package com.cpucode.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cpucode.dao.CheckItemDao;
import com.cpucode.entity.PageResult;
import com.cpucode.pojo.CheckItem;
import com.cpucode.service.CheckItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    /**
     * 注入DAO对象
     */
    @Autowired
    CheckItemDao checkItemDao;

    /**
     * 新增
     * @param checkItem
     */
    public void add(CheckItem checkItem){
        checkItemDao.add(checkItem);
    }

    /**
     * 分页查询方法
     *
     * @param currentPage
     * @param pageSize
     * @param queryString
     * @return
     */
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString){
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 删除
     * @param id
     * @throws RuntimeException
     */
    public void deleteById(Integer id) throws RuntimeException{
        //查询当前检查项是否和检查组关联
        long count = checkItemDao.findCountByCheckItemId(id);

        if(count > 0){
            //当前检查项被引用，不能删除
            throw new RuntimeException("当前检查项被引用，不能删除");
        }

        checkItemDao.deleteById(id);
    }

    public void edit(CheckItem checkItem){
        checkItemDao.edit(checkItem);
    }

    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
