package com.aye.service.email;

import com.aye.commons.stream.StreamSink;
import com.aye.commons.stream.StreamSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;


@SpringBootApplication(scanBasePackages ="com.aye.service.email")
@EnableDiscoveryClient
@EnableBinding({StreamSink.class, StreamSource.class})
public class EmailServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class,args);
    }
}
