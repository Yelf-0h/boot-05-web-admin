package edu.springboot.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yelf
 * @create 2022-09-10-2:40
 */
@Component
public class ExampleInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> map = new HashMap<>();
        map.put("appName","MyBoot-admin");
        map.put("appVersion","1.0.0");
        map.put("msg","hello,你好啊");
        builder.withDetails(map);
    }
}
