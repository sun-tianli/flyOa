package com.eaglesoft.zjhz.common.exception;

import com.eaglesoft.zjhz.common.constant.BaseEnum;
import lombok.Data;

/**
 * Created by lx on 2019/7/23
 */
@Data
public class EgException extends RuntimeException {
    /**
     * 错误码
     */
    protected Integer errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public EgException(){
        super();
    }


    public EgException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public EgException(Integer errorCode, String errorMsg) {
        super(""+errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public EgException(BaseEnum.ResultCode errorCode, String errorMsg) {
        super("" + errorCode.getCode());
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorMsg;
    }

    public EgException(Integer errorCode, String errorMsg, Throwable cause) {
        super(""+errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
