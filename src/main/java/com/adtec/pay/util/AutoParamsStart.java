package com.adtec.pay.util;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Component
@Order(value = 1)
public class AutoParamsStart implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--------------------------加载平台级服务-------------------");
        System.out.println("--------------------------加载Zookeeper-------------------");

    }
}

//@Component
//@Order(value = 2)
//class AutoParamsStart2 implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("--------------------------加载平台级服务-------------------");
//
//
//
//        System.out.println("--------------------------加载Zookeeper-------------------");
//        try {
//            // 启动ZK监听
//            ZKWatcher.getInstance().connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
