package com.design.demo.Decorator_装饰者模式;

import com.design.demo.Decorator_装饰者模式.v2.Decorator;
import com.design.demo.Decorator_装饰者模式.v2.FoundationMakeup;
import com.design.demo.Decorator_装饰者模式.v2.Lipstick;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Decorator decorator = new Decorator(new Girl());
//        decorator.show();
        new FoundationMakeup(new Lipstick(new Girl())).show();
        //IO中的装饰者模式
        new BufferedReader(new InputStreamReader(new FileInputStream("filePath")));


    }
}
