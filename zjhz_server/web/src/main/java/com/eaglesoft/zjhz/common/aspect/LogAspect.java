package com.eaglesoft.zjhz.common.aspect;

import com.eaglesoft.zjhz.common.properties.DemoProperties;
import com.eaglesoft.zjhz.common.utils.GetIPUtil;
import com.eaglesoft.zjhz.common.utils.HttpContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP 记录用户操作日志
 *
 * @author caicy
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private DemoProperties uiasProperties;


    @Pointcut("@annotation(com.eaglesoft.zjhz.common.annotation.Log)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        // 执行方法
        result = point.proceed();
        // 获取 request
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        // 设置 IP 地址
        String ip = GetIPUtil.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        if (uiasProperties.isOpenAopLog()) {
            // 保存日志
//            SysUser user = (SysUser) request.getAttribute(UiasConstant.LOGIN_USER_KEY);
//            if (user != null) {
//                SysLog log = new SysLog();
//                if (user.getYhzh() != null) {
//                    log.setYhxm(user.getYhzh());
//                }
//                log.setYhid(user.getId());
//                log.setIp(ip);
//                log.setCzhs(time);
//                log.setCzsj(LocalDateTime.now());
//                log.setUrl(request.getServletPath());
//                log.setScbz(0);
//                iSysLogService.saveLog(point, log);
//            }
        }
        return result;
    }

}
