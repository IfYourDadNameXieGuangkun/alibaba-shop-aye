package com.design.demo.Chain_责任链模式;

//定义一个抽象的handler
public abstract class Handler {
    private Handler nextHandler;
    private int level;//处理能够处理的级别

    public Handler(int level) {
        this.level = level;
    }

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }
    public final void handleMessage(int level){//参数可以是对象
        if (this.level == level) {
            this.echo(level);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.handleMessage(level);
            } else {
                System.out.println("已经到最尽头了");
            }
        }
    }
    public abstract void echo(int level);
}
