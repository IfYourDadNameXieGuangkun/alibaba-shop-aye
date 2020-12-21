package com.design.demo.Template_模板模式.哺乳动物;

public class Whale extends Mammal {
    @Override
    public void move() {
        System.out.println("游泳……");
    }

    public static void main(String[] args) {
        Whale whale = new Whale();
        whale.feedMilk(false);
    }
}
