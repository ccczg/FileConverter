package net.chanrich.fileconverter.common;

import net.chanrich.fileconverter.enums.ResultEnum;

/**
 * @author: Effort
 * @date: 2021-04-21
 * @time: 2:15 下午
 * @description:
 */
public class ServiceException extends  RuntimeException {
    private Integer code = null;

    private Object data = null;

    public Integer getCode() {
        return code;
    }

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, int appointCode) {
        super(message);
        code = appointCode;
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.message);
        code = resultEnum.code;
    }

    public ServiceException(ResultEnum resultEnum, Object temp) {
        super(resultEnum.message);
        code = resultEnum.code;
        data = temp;
    }

    public Object getData() {
        return data;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
