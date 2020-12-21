package com.design.demo.Adapter_适配器模式;

/**
 * 举个例子，我们开始代码部分，先写墙上的三项插孔接口，命名TriplePin：
 * 我们只定义三插孔标准electrify（通电）方法，三个参数分别是火线、零线、地线，很简单吧，
 */
public interface TriplePin {
    //参数分别为火线live，零线null，地线earth
    public void electrify(int l, int n, int e);

}
