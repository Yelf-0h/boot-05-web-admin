package edu.springboot.amdin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * 这是@ResponseStatus+自定义异常 ；
 * 底层是 ResponseStatusExceptionResolver ，
 * 把responsestatus注解的信息底层调用 response.sendError(statusCode, resolvedReason)
 * @author Yelf
 * @create 2022-09-04-23:56
 */
@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT,reason = "用户添加过多")
public class UserTooManyException extends RuntimeException{
    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
