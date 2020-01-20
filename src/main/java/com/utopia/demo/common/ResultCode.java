package com.utopia.demo.common;


import javax.print.DocFlavor;

public enum ResultCode implements ErrorCode {

    SUCCESS(200, "success"),
    FAILED(500, "failed"),
    VALIDATE_FAILED(404, "args validate failed"),
    UNAUTHORIZED(401, "authentication failed"),
    FORBIDDEN(403, "permission denied"),
    ;

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
