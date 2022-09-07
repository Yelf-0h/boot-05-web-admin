package edu.springboot.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 * 自定义连接池Druid
 * 并设置Druid监控页面
 *
 * 导入druid的starter包即可自动配置
 * @author Yelf
 * @create 2022-09-05-16:46
 */

//@Configuration
@Deprecated
public class MyDataSourceConfig {


    /**
     * 新增Druid的datasource
     * 将配置文件配置属性绑定到这个自定义datasource
     * @return
     * @throws SQLException
     */

//    @ConfigurationProperties("spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 设置statViewServlet开启druid监控页面，设置路径为/druid/*
     * 添加登录所需的账号密码，没添加就是不用登录
     * @return
     */
//    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","root");
        return statViewServletServletRegistrationBean;
    }

    /**
     * 添加druid 的web监控 ，设置页面过滤器拦截所有，只排除资源文件
     * @return
     */
//    @Bean
    public FilterRegistrationBean DruidWebStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.addUrlPatterns("/*");
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return webStatFilterFilterRegistrationBean;
    }
}
