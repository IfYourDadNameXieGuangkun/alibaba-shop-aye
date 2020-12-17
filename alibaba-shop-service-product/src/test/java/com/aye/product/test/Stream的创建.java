package com.aye.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
public class Stream的创建 {

    /**
     * 1、通过 java.util.Collection.stream() 方法用集合创建流
     */
    @Test
    public void test1() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
    }

    /**
     * 2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
     */
    @Test
    public void test2() {
        int [] array = {1,3,6,8,6};
        IntStream stream = Arrays.stream(array);
    }

    /**
     * 3、使用Stream的静态方法:of()、iterate()、generate()
     */
    @Test
    public void test3(){

        Stream<Integer> limit = Stream.iterate(1, x -> x + 3).limit(4);
        System.out.println("输出");
        limit.forEach(System.out::print);
        System.out.println("输出");
    }
}
