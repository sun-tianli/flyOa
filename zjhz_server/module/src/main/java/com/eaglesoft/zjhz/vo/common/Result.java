package com.eaglesoft.zjhz.vo.common;

import com.eaglesoft.zjhz.common.constant.BaseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 统一的数据返回接口
 */
@ApiModel(value = "Result", description = "返回实体")
@Data
public class Result<T> {

    public static final String ACTION_ADD = "add";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_DELETE = "delete";


    @ApiModelProperty("返回code")
    private Integer code;
    @ApiModelProperty("信息")
    private String msg;
    @ApiModelProperty("类型")
    private T data;
    @ApiModelProperty("时间戳")
    private Long timestamp;

    public Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.timestamp = System.currentTimeMillis();
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 直接返回成功 不需要任何参数
     *
     * @return
     */
    public static Result success() {
        return new Result(BaseEnum.ResultCode.OK.getCode(), BaseEnum.ResultCode.OK.getMsg());
    }

    /**
     * 带默认参数的成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result success(T data) {
        return new Result(BaseEnum.ResultCode.OK.getCode(), BaseEnum.ResultCode.OK.getMsg(), data);
    }

    /**
     * 带参的成功--自定义结果用于新增修改删除等情况
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result result(BaseEnum.ResultCode resultCode, T data) {
        return new Result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static <T> Result result(Integer errCode, String errMsg, T data) {
        return new Result(errCode, errMsg, data);
    }

    public static Result result(BaseEnum.ResultCode resultCode) {
        return new Result(resultCode.getCode(), resultCode.getMsg());
    }

    public static Result result(Integer errCode, String errMsg) {
        return new Result(errCode, errMsg);
    }

    /**
     * 无参的失败
     *
     * @return
     */
    public static Result error() {
        return new Result(BaseEnum.ResultCode.Fail.getCode(), BaseEnum.ResultCode.Fail.getMsg());
    }

    /*public static Result error(UiasEnum.ResultCode errCode){
        return new Result(errCode.getCode(), errCode.getMsg());
    }

    public static Result error(Integer errCode, String errMsg){
        return new Result(errCode,errMsg);
    }*/

    /**
     * 综合性的增删改返回用于返回ID
     *
     * @param actiongResult：操作是成功
     * @param action:操作，add：新增，update：更新，delete：删除
     * @return
     */
    public static <T> Result actionResult(Boolean actiongResult, String action, T data) {
        BaseEnum.ResultCode resultCode = Result.resultCode(actiongResult, action);
        return Result.result(resultCode, data);
    }

    /**
     * @return cn.eaglesoft.cfxt.vo.common.Result
     * @Description //
     * @Param [actiongResult, action, data, module]
     **/
    public static <T> Result actionResult(Boolean actiongResult, String action, T data, String module) {
        BaseEnum.ResultCode resultCode = Result.resultCode(actiongResult, action);
        String msg = actiongResult ? module + "成功" : module + "失败";
        return Result.result(resultCode.getCode(), msg, data);
    }

    public static Result result(Boolean actiongResult, String action, String msg) {
        BaseEnum.ResultCode resultCode = Result.resultCode(actiongResult, action);
        msg = StringUtils.isBlank(msg) ? resultCode.getMsg() : msg;
        return Result.result(resultCode.getCode(), msg);
    }

    private static BaseEnum.ResultCode resultCode(Boolean actiongResult, String action) {
        BaseEnum.ResultCode resultCode = null;
        if (StringUtils.equals(action, ACTION_ADD)) {//插入
            resultCode = actiongResult ? BaseEnum.ResultCode.InsertSuccess : BaseEnum.ResultCode.ErrInsert;
        } else if (StringUtils.equals(action, ACTION_UPDATE)) {
            resultCode = actiongResult ? BaseEnum.ResultCode.UpdateSuccess : BaseEnum.ResultCode.ErrUpdate;
        } else if (StringUtils.equals(action, ACTION_DELETE)) {
            resultCode = actiongResult ? BaseEnum.ResultCode.DeleteSuccess : BaseEnum.ResultCode.ErrDelete;
        }
        return resultCode;
    }


}
