package com.xiaoniucode.timeline.trail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

/**
 * @author liuxin
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Ajax handleAllExceptions(Exception ex) {
        logger.debug("系统异常", ex);
        ex.printStackTrace();
        return Ajax.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BizException.class)
    public Ajax handleCustomException(BizException ex) {
        logger.debug("业务异常", ex);
        ex.printStackTrace();
        return Ajax.error(ex.getCode(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Ajax bindExceptionHandler(BindException ex) {
        logger.debug("请求参数校验不通过", ex);
        return Ajax.error(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(ServerWebInputException.class)
    public Ajax handleServerWebInputException(ServerWebInputException ex) {
        String error = ((WebExchangeBindException) ex).getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        logger.debug("请求参数异常: {}", error);
        return Ajax.error(HttpStatus.BAD_REQUEST.value(), error);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Ajax methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        logger.debug("方法参数校验不通过", ex);
        return Ajax.error(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }
}
