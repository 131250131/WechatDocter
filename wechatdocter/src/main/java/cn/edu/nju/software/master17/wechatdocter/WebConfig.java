package cn.edu.nju.software.master17.wechatdocter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by csc on 2017/12/8.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CORS Configuration Works!");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","HEAD","PUT","PATCH","DELETE","OPTIONS","TRACE");
    }

}

