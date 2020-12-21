package com.design.demo.Decorator_装饰者模式;

public  class Decorator implements ShowAble {
    ShowAble showable;//持有某个善于展示的家伙

    public Decorator(ShowAble showable) {//构造时注入这个家伙
        this.showable = showable;
    }

    @Override
    public void show() {
        System.out.print("粉饰(");//化妆品粉饰
        showable.show();//这家伙素面朝天的秀
        System.out.print(")");//粉饰打完收工
    }
}
