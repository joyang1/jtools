package cn.tommyyang.jtools.exception;

/**
 * @Author : TommyYang
 * @Time : 2019-08-30 12:13
 * @Software: IntelliJ IDEA
 * @File : ErrorCode.java
 */
public enum  ErrorCode {

    INVALID_PARAMS(100);

    private int code;

    public int getCode() {
        return code;
    }

    ErrorCode(int code) {
        this.code = code;
    }
}
