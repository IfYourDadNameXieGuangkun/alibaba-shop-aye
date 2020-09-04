package com.aye.reg;

import com.aye.commons.stream.StreamSink;
import com.aye.commons.stream.StreamSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.aye")
@MapperScan("com.aye.commons.mapper")
@EnableBinding({StreamSink.class, StreamSource.class})
@EnableSwagger2
@EnableFeignClients(basePackages = {"com.aye.commons.client"})
public class RegServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegServiceApplication.class,args);
    }
}
