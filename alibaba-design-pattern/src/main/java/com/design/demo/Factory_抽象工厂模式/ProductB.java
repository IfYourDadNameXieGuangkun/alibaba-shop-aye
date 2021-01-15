package com.design.demo.Factory_抽象工厂模式;

//定义一个具体产品(可以定义多个具体产品)
public class ProductB extends Product {
    @Override
    public void method() {
        System.out.println("这是具体产品B");
    }
}
