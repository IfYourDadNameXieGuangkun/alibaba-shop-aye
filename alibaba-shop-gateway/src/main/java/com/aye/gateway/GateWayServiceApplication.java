package com.aye.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName GateWayServiceApplication
 * @Description 网关服务
 * @Author Aye
 * @Date 2020/9/7 14:14
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GateWayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayServiceApplication.class,args);
    }
}