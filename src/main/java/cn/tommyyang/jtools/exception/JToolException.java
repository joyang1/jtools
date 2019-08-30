package cn.tommyyang.jtools.exception;

/**
 * @Author : TommyYang
 * @Time : 2019-08-30 12:12
 * @Software: IntelliJ IDEA
 * @File : JToolException.java
 */
public class JToolException extends Exception {

    private ErrorCode errorCode;

    public JToolException(ErrorCode code, String message) {
        super(message);
        this.errorCode = code;
    }


    @Override
    public String toString() {
        return String.format("ErrorCode:%d", ErrorCode.INVALID_PARAMS.getCode()) + super.toString();
    }

}
