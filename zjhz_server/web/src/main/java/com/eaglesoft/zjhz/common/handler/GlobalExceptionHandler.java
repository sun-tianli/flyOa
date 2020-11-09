package com.eaglesoft.zjhz.common.handler;

import com.eaglesoft.zjhz.common.constant.BaseEnum;
import com.eaglesoft.zjhz.common.exception.EgException;
import com.eaglesoft.zjhz.common.exception.LimitAccessException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.eaglesoft.zjhz.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理类
 * Created by lx on 2019/7/23
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = EgException.class)
    @ResponseBody
    public Result uiasExceptionHandler(HttpServletRequest req, EgException e){
        log.error("系统错误：", e);
        return Result.result(e.getErrorCode(),e.getErrorMsg());
    }


    /**
     * 处理空指针的异常
     * @param req
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("空指针异常：", e);
        return Result.result(BaseEnum.ResultCode.BODY_NOT_MATCH);
    }

    /**
     * 处理请求方法不支持的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e){
        log.error("HTTP请求异常：", e);
        return Result.result(BaseEnum.ResultCode.REQUEST_METHOD_SUPPORT_ERROR);
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, Exception e){
        log.error("系统内部异常：", e);
        return Result.result(BaseEnum.ResultCode.INTERNAL_SERVER_ERROR);
    }



    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result validExceptionHandler(BindException e) {
        log.error("请求参数异常：", e);
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return Result.result(BaseEnum.ResultCode.Exception.getCode(),message.toString());

    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return FebsResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        log.error("请求参数异常：", e);
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), StringPool.DOT);
            message.append(pathArr[1]).append(violation.getMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return Result.result(BaseEnum.ResultCode.Exception.getCode(),message.toString());
    }

    @ExceptionHandler(value = LimitAccessException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public Result handleLimitAccessException(LimitAccessException e) {
        log.error("请求异常：", e);
        return Result.result(BaseEnum.ResultCode.Exception.getCode(),e.getMessage());
    }

}
