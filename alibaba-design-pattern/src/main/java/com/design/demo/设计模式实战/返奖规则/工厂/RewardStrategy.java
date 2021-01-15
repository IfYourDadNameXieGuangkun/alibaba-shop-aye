package com.design.demo.设计模式实战.返奖规则.工厂;

import java.math.BigDecimal;

//抽象返奖策略
public abstract class RewardStrategy {
    public abstract BigDecimal reward(long userId);

    public void insertRewardAndSettlement(long userId, BigDecimal reward) {
        System.out.println("更新用户信息以及结算:"+userId+"--"+reward.toString());
    } ; //更新用户信息以及结算
}
