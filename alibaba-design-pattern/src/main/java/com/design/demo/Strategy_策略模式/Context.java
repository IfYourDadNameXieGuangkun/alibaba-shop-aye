package com.design.demo.Strategy_策略模式;

public class Context {
    private Strategy strategy = null;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void doStrategy(){
        strategy.strategyImpl();
    }

    public static void main(String[] args) {
        Strategy strategy = new StrategyA();
        Context context = new Context(strategy);
        context.doStrategy();
    }
}
