package net.chanrich.fileconverter.handler;

import net.chanrich.fileconverter.common.Result;
import net.chanrich.fileconverter.common.ResultGenerator;
import net.chanrich.fileconverter.common.ServiceException;
import net.chanrich.fileconverter.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

/**
 * @author: Effort
 * @date: 2021-04-21
 * @time: 2:26 下午
 * @description: 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public static final String exception = "Exception:\r\n";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(exception, e);
        return ResultGenerator.genFailResult(getExceptionMessage(e.getBindingResult()), ResultEnum.PARAMS_ERROR.code);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result httpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error(exception, e);
        return ResultGenerator.genFailResult("参数类型存在错误");
    }

    @ExceptionHandler(ResourceAccessException.class)
    public Result httpMessageNotReadableException(ResourceAccessException e) {
        logger.error(exception, e);
        return ResultGenerator.genFailResult("内部错误");
    }


    @ExceptionHandler(ServiceException.class)
    public Result serviceException(ServiceException e) {
        logger.error(exception, e);
        return ResultGenerator.genFailResult(e);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result bindException(MissingServletRequestParameterException e) {
        return ResultGenerator.genFailResult(String.format("提交参数 {%s} 缺失。", e.getParameterName()), ResultEnum.PARAMS_ERROR.code);
    }


    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        logger.error(exception, e);
        return ResultGenerator.genFailResult(e.getMessage());
    }

    private String getExceptionMessage(BindingResult bindingResult) {
        try {
            for (FieldError error : bindingResult.getFieldErrors()) {
                return error.getDefaultMessage();
            }
        } catch (Exception e) {
            logger.error(exception, e);
        }
        return null;
    }
}
