package com.design.demo.Template_模板模式.项目管理;

public class AutoTestPM extends PM {
    @Override
    protected void analyze() {
        System.out.println("分析");
    }

    @Override
    protected void design() {
        System.out.println("设计");
    }

    @Override
    protected void develop() {
        System.out.println("开发");
    }

    @Override
    protected boolean test() {
        System.out.println("测试");
        return false;
    }

    @Override
    protected void release() {
        System.out.println("发布");
    }

    public static void main(String[] args) {
        AutoTestPM autoTestPM = new AutoTestPM();
        autoTestPM.kickoff();
    }
}
