package com.design.demo.Singleton_单例模式;

/**
 * 懒汉模式（Lazy load）
 * <p>
 * 优点:减少内存消耗
 * 缺点:创建神需要消耗CPU
 * 在V2基础上进行改造:加锁,没有创建时加锁,创建神了直接返回
 *
 * 其实在这之上还发展出了各种各样的单例模式变种，我们这里只讲了最基础的两种，其实他们都各有优缺，我们要做到灵活运用，各取所需。
 * 对于我个人来讲倾向于痴汉模式，现在内存成本根本不算问题，况且迟早要被实例化占用内存，加锁解锁更是一种浪费，还有同步效率低等问题，
 * 如果上帝不是很占空间那就没必要去懒汉延迟加载，越复杂问题越多，风险越大。
 *
 *
 *
 * 大道至简，无为而治。
 */
public class God_LazyLoad_V3 {
    private static God_LazyLoad_V3 god_lazyLoad;//这里不进行实例化

    private God_LazyLoad_V3() {
    }

    public static God_LazyLoad_V3 getInstance() {//庙是开放的不用排队进入

        if (god_lazyLoad == null) {//如果头柱香未产生，这批抢香人进入堂内排队。
            synchronized (God_LazyLoad_V3.class) {
                if (god_lazyLoad == null) {//只有头香造了神，其他抢香的白排队了
                    god_lazyLoad = new God_LazyLoad_V3();
                }
            }
            god_lazyLoad = new God_LazyLoad_V3();
        }
        //此处头柱香产生后不必再排队
        return god_lazyLoad;
    }

}
