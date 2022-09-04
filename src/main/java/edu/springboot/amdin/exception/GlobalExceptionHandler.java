package edu.springboot.amdin.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * 这是@ControllerAdvice+@ExceptionHandler处理全局异常；底层是 ExceptionHandlerExceptionResolver 支持的
 * 设置当遇到@ExceptionHandler()中写的异常时，如何处理
 * @author Yelf
 * @create 2022-09-04-23:41
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public String handlerArithException(Model model){
        model.addAttribute("msg","出现异常请重新登录");
        return "login";
    }
}
