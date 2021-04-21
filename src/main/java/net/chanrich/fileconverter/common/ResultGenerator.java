package net.chanrich.fileconverter.common;

import net.chanrich.fileconverter.enums.ResultEnum;

/**
 * @author: Effort
 * @date: 2021-04-21
 * @time: 2:12 下午
 * @description: 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setCode(ResultEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }



    public static Result genFailResult(ResultEnum resultEnum) {
        return new Result()
                .setCode(resultEnum.getCode())
                .setMessage(resultEnum.getMessage());
    }


    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultEnum.FAIL)
                .setMessage(message);
    }

    public static Result genFailResult(ServiceException se) {
        int code;
        if (se.getCode() != null) {
            code = se.getCode();
        } else {
            code = ResultEnum.FAIL.code;
        }
        return new Result()
                .setCode(code)
                .setMessage(se.getMessage()).setData(se.getData());
    }

    public static Result genFailResult(String message, int code) {
        return new Result()
                .setCode(code)
                .setMessage(message);
    }

    public static <T> Result<T> genFailResult(String message, T data) {
        return new Result()
                .setCode(ResultEnum.FAIL)
                .setMessage(message)
                .setData(data);
    }
}
