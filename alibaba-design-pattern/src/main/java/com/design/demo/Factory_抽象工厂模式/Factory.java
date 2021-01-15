package com.design.demo.Factory_抽象工厂模式;

public abstract class Factory<T> {
    abstract Product createProduct(Class<T> c) ;
}
