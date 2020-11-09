package com.eaglesoft.zjhz.common.token;

import cn.eaglesoft.tools.dateUtil.LocalDateUtil;
import com.eaglesoft.zjhz.common.constant.BaseConstant;
import com.eaglesoft.zjhz.service.base.RedisService;
import com.eaglesoft.zjhz.common.properties.DemoProperties;
import com.eaglesoft.zjhz.entity.jc.testJcYhgl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(rollbackFor = Exception.class)
public class TokenService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private DemoProperties demoProperties;


    public JwtToken getJwtToken(testJcYhgl user) throws Exception {
        Long jwtTimeout = demoProperties.getJwtTimeOut();
        String token = JwtUtil.sign(user.getZh(), user.getMm(), jwtTimeout * 1000);
        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(jwtTimeout);
        JwtToken jwtToken = new JwtToken(token, LocalDateUtil.formatLocalDateTime(expireTime, "yyyyMMddHHmmss"));
        //将token保存至redis
        redisService.set(BaseConstant.TOKEN_CACHE_PREFIX + jwtToken.getToken(), jwtToken.getToken(), jwtTimeout * 1000);
        return jwtToken;
    }

    public String getTokenByKey(String key) throws Exception {
        return redisService.get(key);
    }

    public void removeToken(String key) throws Exception {
        redisService.del(key);
    }
}
