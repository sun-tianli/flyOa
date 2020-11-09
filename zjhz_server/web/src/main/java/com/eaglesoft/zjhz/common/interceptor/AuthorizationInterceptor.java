package com.eaglesoft.zjhz.common.interceptor;


import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.common.constant.BaseConstant;
import com.eaglesoft.zjhz.common.constant.BaseEnum;
import com.eaglesoft.zjhz.common.token.JwtUtil;
import com.eaglesoft.zjhz.common.token.TokenService;
import com.eaglesoft.zjhz.service.jc.testIJcYhglService;
import com.eaglesoft.zjhz.common.exception.EgException;
import com.eaglesoft.zjhz.entity.jc.testJcYhgl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 权限(Token)验证
 *
 * @author zwj
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private testIJcYhglService jcYhglService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        IgnoreAuth methodAnnotation = method.getAnnotation(IgnoreAuth.class);

        //如果有@IgnoreAuth注解，则不验证token
        if (methodAnnotation != null) {
            return true;
        }

        //从header中获取token
        String token = request.getHeader(BaseConstant.TOKEN_AUTH_HEADER);

        //token为空
        if (StringUtils.isBlank(token)) {
            throw new EgException(BaseEnum.ResultCode.ErrTokenUnValid, "无token，请重新登录");
        }

        Object object = tokenService.getTokenByKey(BaseConstant.TOKEN_CACHE_PREFIX + token);
        // 如果找不到，说明已经失效
        if (object == null) {
            throw new EgException(BaseEnum.ResultCode.ErrTokenExpire, "token已经过期，请重新登录");
        }
        String username = JwtUtil.getUsername(token);
        if (StringUtils.isBlank(username)) {
            throw new EgException(BaseEnum.ResultCode.ErrTokenUnValid, "token无效，请重新登录");
        }

        // 通过用户名查询用户信息
        testJcYhgl user = jcYhglService.selectByUsername(username);

        if (user == null) {
            throw new EgException(BaseEnum.ResultCode.ErrUserNotExist, "用户不存在，请重新登录");
        }
        //校验token
        if (!JwtUtil.verify(token, username, user.getMm())) {
            throw new EgException(BaseEnum.ResultCode.ErrTokenUnValid, "token无效，请重新登录");
        }
        request.setAttribute("currentUser", user);
        return true;
    }

}
