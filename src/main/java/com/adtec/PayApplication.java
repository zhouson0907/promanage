package com.adtec;

import com.adtec.base.util.SpringContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


@MapperScan("com.adtec.*.*.dao")
@SpringBootApplication
public class PayApplication  implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PayApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
//        SpringApplication.run(PayApplication.class, args);
    }


    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/template");
        return configurer;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        SpringContextHolder springContextHolder = new SpringContextHolder();
        springContextHolder.setApplicationContext(event.getApplicationContext());
    }
}
