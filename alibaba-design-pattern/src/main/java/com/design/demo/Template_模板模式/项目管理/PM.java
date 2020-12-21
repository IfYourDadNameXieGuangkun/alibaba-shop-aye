package com.design.demo.Template_模板模式.项目管理;

/**
 * 我们做软件项目管理，按瀑布式简单来讲分为：需求分析、设计、编码、测试、发布，先不管是用何种方式去实现各个细节，我们就抽象成这五个步骤。
 */
public abstract class PM {
    protected abstract void analyze();//需求分析

    protected abstract void design();//设计

    protected abstract void develop();//开发

    protected abstract boolean test();//测试

    protected abstract void release();//发布

    /**
     * 那么问题来了，有个程序员在需求不明确或者设计不完善的情况下，一上来二话不说直接写代码，这样就会造成资源的浪费，
     * 后期改动太大还会影响项目进度。那么项目经理这时就应该规范一下这个任务流程，这里我们加入kickoff()方法实现。
     */

    protected final void kickoff() {
        analyze();
        design();
        develop();
        test();
//        do {
//            develop();
//        } while (!test());//如果测试失败，则继续开发改Bug。
        release();
    }

}
