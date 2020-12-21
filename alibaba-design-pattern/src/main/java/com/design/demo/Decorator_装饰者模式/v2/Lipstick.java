package com.design.demo.Decorator_装饰者模式.v2;

import com.design.demo.Decorator_装饰者模式.ShowAble;

public class Lipstick extends Decorator {
    public Lipstick(ShowAble showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.print("涂口红(");
        showable.show();
        System.out.print(")");
    }
}
