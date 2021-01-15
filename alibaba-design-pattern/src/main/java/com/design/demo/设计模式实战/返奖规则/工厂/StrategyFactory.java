package com.design.demo.设计模式实战.返奖规则.工厂;

//抽象工厂
public abstract class StrategyFactory<T> {
    abstract RewardStrategy createStrategy(Class<T> c);
}
