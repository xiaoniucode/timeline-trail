package com.xiaoniucode.timeline.trail.config;


public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public BizException(String message) {
        super(message);
        this.code = Ajax.CODE_ERROR;
        this.message = message;
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
