package com.design.demo.设计模式实战.返奖规则;

import com.design.demo.设计模式实战.返奖规则.工厂.*;
import com.design.demo.设计模式实战.返奖规则.策略.RewardContext;

public class Test {
    public static void main(String[] args) {
        FactorRewardStrategyFactory strategyFactory = new FactorRewardStrategyFactory();//创建工厂

        for (int i=0;i<100;i++){
            if (i%2==0){
                NewUserRewardStrategyA A = (NewUserRewardStrategyA)strategyFactory.createStrategy(NewUserRewardStrategyA.class);
                RewardContext rewardContext = new RewardContext(A);
                rewardContext.doStrategy(i);
            }else if(i%3==0){
                NewUserRewardStrategyB B = (NewUserRewardStrategyB)strategyFactory.createStrategy(NewUserRewardStrategyB.class);
                RewardContext rewardContext = new RewardContext(B);
                rewardContext.doStrategy(i);
            }else if(i%5==0){
                OldUserRewardStrategyA oA = (OldUserRewardStrategyA)strategyFactory.createStrategy(OldUserRewardStrategyA.class);
                RewardContext rewardContext = new RewardContext(oA);
                rewardContext.doStrategy(i);
            }else {
                OldUserRewardStrategyB oB = (OldUserRewardStrategyB)strategyFactory.createStrategy(OldUserRewardStrategyB.class);
                RewardContext rewardContext = new RewardContext(oB);
                rewardContext.doStrategy(i);
            }
        }


    }
}
