package net.chanrich.fileconverter.enums;

import net.chanrich.fileconverter.common.ResultMessage;

/**
 * @author: Effort
 * @date: 2021-04-21
 * @time: 2:01 下午
 * @description: 数据返回对象枚举
 */
public enum ResultEnum {
    /**
     * 请求成功
     */
    SUCCESS(200, ResultMessage.REQUEST_SUCCESS),

    /**
     * 请求参数不符合要求
     */
    PARAMS_ERROR(101, ResultMessage.PARAMS_ERROR),

    /**
     * 文件上传失败
     */
    FILE_UPLOAD_FAILED(108, ResultMessage.FILE_UPLOAD_FAILED),

    /**
     * 服务器处理失败
     */
    FAIL(500, ResultMessage.PROCESS_ERROR);

    public int code;
    public String message;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
