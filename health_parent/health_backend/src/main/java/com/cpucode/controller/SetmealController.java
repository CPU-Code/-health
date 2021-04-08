package com.cpucode.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cpucode.constant.MessageConstant;
import com.cpucode.constant.RedisConstant;
import com.cpucode.entity.Result;
import com.cpucode.service.SetmealService;
import com.cpucode.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.UUID;

/**
 *  套餐管理
 *
 * @author : cpucode
 * @date : 2021/4/8
 * @time : 11:36
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    /**
     * 使用JedisPool操作Redis服务
     */
    @Autowired
    private JedisPool jedisPool;

    @Reference
    private SetmealService setmealService;

    /**
     * 图片上传
     * @param imgFile
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile){
        //获取原始文件名
        String originalFilename = imgFile.getOriginalFilename();

        int lastIndexOf = originalFilename.lastIndexOf(".");
        //获取文件后缀
        String suffix = originalFilename.substring(lastIndexOf);

        //使用UUID随机产生文件名称，防止同名文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;

        try {
            //将文件上传到七牛云服务器
            QiniuUtils.upload2Qiniu(imgFile.getBytes(), fileName);
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES, fileName);

        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }

        //图片上传成功
        return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS, fileName);
    }
}
