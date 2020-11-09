package com.eaglesoft.zjhz.service.base.impl;

import com.eaglesoft.zjhz.service.base.CacheService;
import com.eaglesoft.zjhz.service.base.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisService redisService;


    @Override
    public void testConnect() throws Exception {
        this.redisService.exists("test");
    }


}
