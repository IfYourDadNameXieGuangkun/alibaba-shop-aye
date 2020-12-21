package com.design.demo.Template_模板模式.哺乳动物;

public class Human extends Mammal {

    @Override
    public void move() {
        System.out.println("两条腿走路……");
    }

    public static void main(String[] args) {
        Human human = new Human();
        human.feedMilk(true);
    }
}
