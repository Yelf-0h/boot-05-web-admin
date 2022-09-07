package edu.springboot.admin.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义异常解析器
 * 自定义实现 HandlerExceptionResolver 处理异常；可以作为默认的全局异常处理规则
 * @author Yelf
 * @create 2022-09-05-1:02
 */

//@Order(value = Ordered.HIGHEST_PRECEDENCE) //设置优先级最高，不设置的话不会运行到，设置的话只会运行到这个
//@Component
@Deprecated
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        try {
            response.sendError(511,"我喜欢的异常，自定义511");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
