package com.design.demo.设计模式实战.使用注解_多渠道支付;

import org.springframework.stereotype.Service;

@PayCode(payChannel = Channel.WX ,payName = "微信支付")
@Service
public class WxPay implements IPay {
    @Override
    public void pay() {
        System.out.println("这是微信支付");
    }
}
