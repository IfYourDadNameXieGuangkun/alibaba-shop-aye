package com.design.demo.Adapter_适配器模式;

/**
 * 类适配器,一般采用这种方式
 */
public class ClassAdapter extends TV implements TriplePin {
    @Override
    public void electrify(int l, int n, int e) {
        super.electrify(l,n);
    }
}
