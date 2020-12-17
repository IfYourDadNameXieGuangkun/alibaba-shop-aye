package com.aye.commons.stream;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface StreamSource {

    String REG_OUTPUT= "REG_OUTPUT";
    @Output(StreamSource.REG_OUTPUT)
    MessageChannel REG_OUTPUT();

//    String OUTPUT2= "output2";
//    @Output(StreamSource.OUTPUT2)
//    MessageChannel output2();

}
