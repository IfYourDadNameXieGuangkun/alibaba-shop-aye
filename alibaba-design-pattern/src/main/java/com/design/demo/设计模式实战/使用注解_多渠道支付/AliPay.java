package com.design.demo.设计模式实战.使用注解_多渠道支付;

import org.springframework.stereotype.Service;

@PayCode(payChannel = Channel.ALI,payName = "支付宝支付")
@Service
public class AliPay implements IPay {
    @Override
    public void pay() {
        System.out.println("这是支付宝支付");
    }
}
