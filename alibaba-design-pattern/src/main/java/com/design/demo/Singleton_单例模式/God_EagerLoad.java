package com.design.demo.Singleton_单例模式;

/**
 * 痴汉模式（Eager load）
 *
 * 单例模式对象-神,只有自己能创造自己
 * <p>
 * static关键字保证上帝的静态性，他与类同在，不依赖于类的实例化就自有永有，他将在内存中永生，GC垃圾回收器也回收不了他。
 * final关键字则保证这位神是和常量，衡量，他是终极上帝，不能再改
 * </p>
 *
 * 缺点:加载之后无人调用 会消耗资源
 */
public class God_EagerLoad {
    private static final God_EagerLoad god = new God_EagerLoad();//自有永有的神单例

    private God_EagerLoad() {
    }//构造方法私有化,不允许 new God()

    public static God_EagerLoad getInstance() {//请神方法公开化
        return god;
    }
}
