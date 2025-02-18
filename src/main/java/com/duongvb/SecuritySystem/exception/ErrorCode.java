package com.duongvb.SecuritySystem.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception"),
    USER_EXISTED(1001, "user exited."),
    INVALID_USERNAME(1002, "username is required."),
    INVALID_PASSWORD(1003, "Password is required."),
    INVALID_EMAIL(1004, "Email is required."),
    INVALID_KEY(1005, "Key is invalid."),
    ;


    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
