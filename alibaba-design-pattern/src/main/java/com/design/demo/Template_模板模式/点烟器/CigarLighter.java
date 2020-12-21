package com.design.demo.Template_模板模式.点烟器;

public class CigarLighter implements CigarLighterInterface {
    @Override
    public void electrifyDC16V() {
        int time = 1000;
        while (--time > 0) {
            System.out.println("加热电炉丝");
        }
        System.out.println("点烟器弹出");
    }
}
