package com.design.demo.设计模式实战.返奖规则.策略;

import com.design.demo.设计模式实战.返奖规则.工厂.*;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigDecimal;

public class RewardContext {
    private RewardStrategy strategy;

    public RewardContext(RewardStrategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy(long userId) {
        BigDecimal reward = strategy.reward(userId);
        strategy.insertRewardAndSettlement(userId,reward) ;
    }


}
