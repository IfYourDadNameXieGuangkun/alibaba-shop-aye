package com.design.demo.Singleton_单例模式;

/**
 * 懒汉模式（Lazy load）
 *
 * 优点:减少内存消耗
 * 缺点:创建神需要消耗CPU
 * 在上一个版本的基础上加锁,解决[试想多人同时并发请神的话，依然会造成多神]
 *
 * 然而，这样做是要付出代价的，还没进庙呢不管三七二十一请神的直接给加锁排队，
 * 结果队伍从北边的庙排到了南天门，人们都要来一个一个拜佛求神，这造成了巨大时间浪费，
 * 没有充分利用CPU资源并发优势（特别是多核情况）。好吧，那还是让人们抢好了，但依然得保证单例神的情况下
 */
public class God_LazyLoad_V2 {
    private static God_LazyLoad_V2 god_lazyLoad;//这里不进行实例化
    private God_LazyLoad_V2(){}
    public static synchronized God_LazyLoad_V2 getInstance() {
        if (god_lazyLoad == null) {//如果无神才造神
            god_lazyLoad = new God_LazyLoad_V2();
        }
        return god_lazyLoad;
    }

}
