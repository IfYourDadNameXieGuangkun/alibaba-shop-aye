package com.design.demo.Template_模板模式.点烟器;

public class GPS implements CigarLighterInterface {
    @Override
    public void electrifyDC16V() {
        System.out.println("连接卫星");
        System.out.println("定位。。。");
    }
}
