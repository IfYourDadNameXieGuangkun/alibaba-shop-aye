package com.design.demo.设计模式实战.返奖规则.工厂;

public class FactorRewardStrategyFactory extends StrategyFactory {
    @Override
    public RewardStrategy createStrategy(Class c) {
        RewardStrategy rewardStrategy = null;
        try {
            rewardStrategy = (RewardStrategy) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rewardStrategy;
    }
}
