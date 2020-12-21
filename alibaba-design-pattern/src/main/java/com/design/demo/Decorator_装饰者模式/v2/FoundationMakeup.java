package com.design.demo.Decorator_装饰者模式.v2;

import com.design.demo.Decorator_装饰者模式.ShowAble;

public class FoundationMakeup extends Decorator {
    public FoundationMakeup(ShowAble showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.print("打粉底(");
        showable.show();
        System.out.print(")");
    }
}
