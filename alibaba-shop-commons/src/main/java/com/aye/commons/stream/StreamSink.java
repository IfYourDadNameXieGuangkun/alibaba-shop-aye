package com.aye.commons.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface StreamSink {

    String EMAIL_INPUT= "EMAIL_INPUT";
    @Input(StreamSink.EMAIL_INPUT)
    SubscribableChannel EMAIL_INPUT();

//    String INPUT2= "input2";
//    @Input(StreamSink.INPUT2)
//    SubscribableChannel input2();
}
