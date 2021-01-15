package com.design.demo.设计模式实战.返奖规则.工厂;

import java.math.BigDecimal;

//新用户返奖策略A
public class NewUserRewardStrategyA extends RewardStrategy {
    @Override
    public BigDecimal reward(long userId) {
        System.out.println("新用户返奖策略A");
        return BigDecimal.ZERO;
    }
}
