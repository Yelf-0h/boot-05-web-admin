package edu.springboot.admin.config;

import edu.springboot.admin.interceptor.LoginInterceptor;
import edu.springboot.admin.interceptor.RedisUriCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yelf
 * @create 2022-09-04-15:07
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    RedisUriCountInterceptor redisUriCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/js/**", "/images/**");
        registry.addInterceptor(redisUriCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/js/**", "/images/**");
    }
}
