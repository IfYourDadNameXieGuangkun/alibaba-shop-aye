package com.aye.formatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormatterAutoConfiguration {
    @Bean
    public Formatter format(){
        return new DefaultFormatter();
    }
}
