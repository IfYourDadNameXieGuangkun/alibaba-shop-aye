package com.aye.commons.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface StreamSink {

    String REG_INPUT= "REG_INPUT";
    @Input(StreamSink.REG_INPUT)
    SubscribableChannel REG_INPUT();

//    String INPUT2= "input2";
//    @Input(StreamSink.INPUT2)
//    SubscribableChannel input2();
}
