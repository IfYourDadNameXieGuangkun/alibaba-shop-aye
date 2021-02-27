package com.lppz.stock;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.lppz.stock", "com.lppz.takeout.exception"}, exclude= {DataSourceAutoConfiguration.class})
public class StockApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(StockApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        //context.close();
    }
}
