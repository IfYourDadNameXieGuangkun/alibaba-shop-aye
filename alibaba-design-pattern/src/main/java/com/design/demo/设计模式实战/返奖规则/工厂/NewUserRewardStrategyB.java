package com.design.demo.设计模式实战.返奖规则.工厂;

import java.math.BigDecimal;

//新用户返奖策略B
public class NewUserRewardStrategyB extends RewardStrategy {
    @Override
    public BigDecimal reward(long userId) {
        System.out.println("新用户返奖策略B");
        return BigDecimal.ONE;
    }
}
