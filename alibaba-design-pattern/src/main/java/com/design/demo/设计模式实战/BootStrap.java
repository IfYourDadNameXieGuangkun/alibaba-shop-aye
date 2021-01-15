package com.design.demo.设计模式实战;

import com.design.demo.设计模式实战.使用注解_多渠道支付.Channel;
import com.design.demo.设计模式实战.使用注解_多渠道支付.IPay;
import com.design.demo.设计模式实战.使用注解_多渠道支付.PayCode;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootApplication(scanBasePackages = "com.design.demo.设计模式实战.使用注解_多渠道支付")
public class BootStrap  {
    public static void main(String[] args) {
        Map<String, IPay> payMap = new HashMap<>();
        ConfigurableApplicationContext context = new SpringApplicationBuilder(BootStrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        Map<String, IPay> map = context.getBeansOfType(IPay.class);//1.拿到所有实现IPay接口的实现类
       map.forEach((key,value)->{
           String channel = value.getClass().getAnnotation(PayCode.class).payChannel().getChannel();
           payMap.put(channel,value);
       });
        payMap.get(Channel.WX.getChannel()).pay();

    }


//    public static void main(String[] args) {
//         Map<String, IPay> payMap = new HashMap<>(); ;
//                ConfigurableApplicationContext context = new SpringApplicationBuilder(BootStrap.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);
//        Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(PayCode.class);
//
//        if (beansWithAnnotation != null) {
//            beansWithAnnotation.forEach((key, value) -> {
//                String bizType = value.getClass().getAnnotation(PayCode.class).payChannel();
//                payMap.put(bizType, (IPay) value);
//            });
//        }
//        payMap.get("ali").pay();
//    }


}
