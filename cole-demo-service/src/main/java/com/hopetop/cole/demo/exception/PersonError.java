package com.hopetop.cole.demo.exception;

import com.hopetop.cole.common.response.IMessage;

public enum PersonError implements IMessage {
    NOT_EMPTY(101, "用户ID不能为空");

    private final int code;
    private final String msg;

    PersonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
