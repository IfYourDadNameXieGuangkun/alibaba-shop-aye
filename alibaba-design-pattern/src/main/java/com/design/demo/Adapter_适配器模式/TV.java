package com.design.demo.Adapter_适配器模式;

/**
 * 那么问题来了，墙上的接口是三插标准，电视实现的是两插标准，无法通电。怎么办？把电视拆了重新修改实现三插标准么？图片暴力份子你又来？
 * 答案显然是否定的，既然是设计模式，果断转换插头啊！好，写个Adapter解决他们之间不可调和的矛盾。
 */
public class TV implements DualPin {
    @Override
    public void electrify(int l, int n) {
        System.out.println("火线通电：" + l);
        System.out.println("零线通电：" + n);
    }
}
