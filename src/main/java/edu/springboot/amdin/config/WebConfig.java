package edu.springboot.amdin.config;

import edu.springboot.amdin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yelf
 * @create 2022-09-04-15:07
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/","/login","/css/**","/fonts/**","/js/**","/images/**");
    }
}
