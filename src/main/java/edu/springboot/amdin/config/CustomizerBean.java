package edu.springboot.amdin.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 *
 * 使用WebServerFactoryCustomizer定制化方法
 * 也可以使用配置application配置文件的方法（推荐使用这个，所以这个类注释掉）
 * @author Yelf
 * @create 2022-09-05-2:26
 */

//@Component //注释掉中，解开端口则变为8081
public class CustomizerBean implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8081);
    }



}
