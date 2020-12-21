package com.design.demo.Singleton_单例模式;

/**
 * 懒汉模式（Lazy load）
 *
 * 优点:减少内存消耗
 * 缺点:创建神需要消耗CPU
 * 这样的懒汉模式还有一个问题:试想多人同时并发请神的话，依然会造成多神
 */
public class God_LazyLoad {
    private static God_LazyLoad god_lazyLoad;//这里不进行实例化
    private God_LazyLoad(){}
    public static God_LazyLoad getInstance() {
        if (god_lazyLoad == null) {//如果无神才造神
            god_lazyLoad = new God_LazyLoad();
        }
        return god_lazyLoad;
    }

}
