package com.eaglesoft.zjhz.common.constant;

public class BaseEnum {

    public enum ResultCode {//返回结果
        Exception(999, "未知异常，请联系管理员"),


        ErrTokenExpire(101, "Token令牌已经过期"),
        ErrTokenUnValid(102, "Token令牌校验不通过"),
        ErrTokenNull(103, "Token令牌为空"),

        OK(200, "成功"),
        InsertSuccess(201, "新增成功"),
        UpdateSuccess(202, "修改成功"),
        DeleteSuccess(203, "删除成功"),
        UploadSuccess(204, "上传成功"),
        SubmitSuccess(205, "提交成功"),

        ErrUserNotExist(301, "用户不存在"),
        ErrUserPwd(302, "用户名或密码错误"),

        BODY_NOT_MATCH(400, "请求的数据格式不符!"),
        SIGNATURE_NOT_MATCH(401, "请求的数字签名不匹配!"),
        NOT_FOUND(404, "未找到该资源!"),
        REQUEST_METHOD_SUPPORT_ERROR(405, "当前请求方法不支持!"),

        INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
        SERVER_BUSY(503, "服务器正忙，请稍后再试!"),

        Fail(600, "失败"),
        ErrInsert(601, "新增失败"),
        ErrUpdate(602, "更新失败"),
        ErrDelete(603, "删除失败"),
        ErrChange(604, "交换失败"),
        ErrSelect(605, "查询失败"),;


        private int code;
        private String msg;

        ResultCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public enum LimitType {
        // 传统类型
        CUSTOMER,
        // 根据 IP 限制
        IP;
    }

}
