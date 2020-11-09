package com.eaglesoft.zjhz.common.task;

import com.eaglesoft.zjhz.service.base.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lx on 2019/9/18
 */
@Slf4j
@Component
public class CommonTask {

    @Autowired
    private CacheService cacheService;

    /**
     * redis更新 -- 00:05 统计
     */
//    @Scheduled(cron = "0 5 0 * * ?")
//    public void updateRedis() throws Exception{
//        //TODO clear old message
//        log.info("缓存更新 ······");
//        log.info("缓存用户数据 ······");
//
//    }
}
