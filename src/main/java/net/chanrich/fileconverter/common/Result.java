package net.chanrich.fileconverter.common;

import com.alibaba.fastjson.JSON;
import net.chanrich.fileconverter.enums.ResultEnum;

/**
 * @author: Effort
 * @date: 2021-04-21
 * @time: 2:03 下午
 * @description:
 */
public class Result <T>{
    private int code;
    private String message;
    private T data;

    public Result setCode(ResultEnum resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
