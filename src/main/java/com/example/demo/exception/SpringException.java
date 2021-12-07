package com.example.demo.exception;

import lombok.Getter;

@Getter
public class SpringException extends RuntimeException{
    /**
     * 错误码
     * 说明：
     * 1.默认 500 系统异常
     * 2.501 参数不合法
     */
    private int code = 500;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SpringException() {
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public SpringException(String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public SpringException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param code    错误 code
     * @param message 错误消息
     */
    public SpringException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 要求条件为{@code false}，若为{@code true}则抛出异常
     *
     * <p>参数校验，抛出 501 异常
     *
     * @param condition 条件 true、false
     * @param message   异常消息
     * @author 王超
     */
    public static void requireFalse(boolean condition, String message) {
        if (condition) {
            throw new SpringException(501, message);
        }
    }

    /**
     * 要求条件为{@code true}，若为{@code false}则抛出异常
     *
     * <p>参数校验，抛出 501 异常
     *
     * @param condition 条件 true、false
     * @param message   异常消息
     * @author 王超
     */
    public static void requireTrue(boolean condition, String message) {
        if (!condition) {
            // 501 参数不合法
            throw new SpringException(501, message);
        }
    }
}
