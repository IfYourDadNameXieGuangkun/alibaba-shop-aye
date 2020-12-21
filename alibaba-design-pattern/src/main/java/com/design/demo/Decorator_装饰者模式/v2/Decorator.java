package com.design.demo.Decorator_装饰者模式.v2;

import com.design.demo.Decorator_装饰者模式.ShowAble;

public abstract class Decorator implements ShowAble {
    protected ShowAble showable;

    public Decorator(ShowAble showable) {
        this.showable = showable;
    }

    @Override
    public void show() {
        showable.show();//直接调用不做加任何粉饰。
    }
}
