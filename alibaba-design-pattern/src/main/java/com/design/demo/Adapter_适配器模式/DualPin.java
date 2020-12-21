package com.design.demo.Adapter_适配器模式;

/**
 * 同样地接下来是两项插孔接口，只是少了地线，命名DualPin：
 * 请注意，这个并不是我们的墙上的目标接口，而是电视机的两插标准。
 */
public interface DualPin {
    public void electrify(int l, int n);//这里没有地线
}
