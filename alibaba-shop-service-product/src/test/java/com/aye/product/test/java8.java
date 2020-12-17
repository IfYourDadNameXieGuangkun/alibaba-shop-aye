package com.aye.product.test;

import com.aye.commons.domain.User;
import com.aye.product.ProductServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName java8
 * @Description java8 Study
 * @Author Aye
 * @Date 2020/9/8 9:24
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProductServiceApplication.class, WebTest.class})
public class java8 {
    /**
     * 1.Stream的操作符大体上分为两种：中间操作符和终止操作符
     * 对于数据流来说，中间操作符在执行制定处理程序后，数据流依然可以传递给下一级的操作符。
     * <p>
     * 1.1中间操作符:
     * <p>
     * 中间操作符包含8种(排除了parallel,sequential,这两个操作并不涉及到对数据流的加工操作)：
     * <p>
     *
     * (mapToInt,mapToLong,mapToDouble) 转换操作符，把比如A->B，这里默认提供了转int，long，double的操作符。
     * <p>
     * flatmap(flatmapToInt,flatmapToLong,flatmapToDouble) 拍平操作比如把 int[]{2,3,4} 拍平 变成 2，3，4 也就是从原来的一个数据变成了3个数据，这里默认提供了拍平成int,long,double的操作符。
     * <p>
     * limit 限流操作，比如数据流中有10个 我只要出前3个就可以使用。
     * <p>
     * distint 去重操作，对重复元素去重，底层使用了equals方法。
     * <p>
     * filter 过滤操作，把不想要的数据过滤。
     * <p>
     * peek 挑出操作，如果想对数据进行某些操作，如：读取、编辑修改等。
     * <p>
     * skip 跳过操作，跳过某些元素。
     * <p>
     * sorted(unordered) 排序操作，对元素排序，前提是实现Comparable接口，当然也可以自定义比较器。
     * <p>
     * <p>
     * 1.2终止操作符:
     * 数据经过中间加工操作，就轮到终止操作符上场了；终止操作符就是用来对数据进行收集或者消费的，数据到了终止操作这里就不会向下流动了，终止操作符只能使用一次。
     * collect 收集操作，将所有数据收集起来，这个操作非常重要，官方的提供的Collectors 提供了非常多收集器，可以说Stream 的核心在于Collectors。
     * <p>
     * count 统计操作，统计最终的数据个数。
     * <p>
     * findFirst、findAny 查找操作，查找第一个、查找任何一个 返回的类型为Optional。
     * <p>
     * noneMatch、allMatch、anyMatch 匹配操作，数据流中是否存在符合条件的元素 返回值为bool 值。
     * <p>
     * min、max 最值操作，需要自定义比较器，返回数据流中最大最小的值。
     * <p>
     * reduce 规约操作，将整个数据流的值规约为一个值，count、min、max底层就是使用reduce。
     * <p>
     * forEach、forEachOrdered 遍历操作，这里就是对最终的数据进行消费了。
     * <p>
     * toArray 数组操作，将数据流的元素转换成数组。
     */
    @Test
    public void map() {
        Stream.of("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg")
                .map(e -> e.length())
                .forEach(e -> System.out.println(e));

    }

    @Test
    public void map_成员变量() {
        Stream.of("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg")
                .map(String::length)
                .forEach(System.out::println);

    }

    @Test
    public void mapToInt() {
        Stream.of("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg")
                .mapToInt(String::length)
                .forEach(System.out::println);

    }

    @Test
    public void mapToDouble() {
        Stream.of("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg")
                .mapToDouble(String::length)
                .forEach(System.out::println);

    }

    /**
     * flatmap 作用就是将元素拍平拍扁 ，将拍扁的元素重新组成Stream，并将这些Stream 串行合并成一条Stream
     * flatmapToInt、flatmapToLong、flatmapToDouble 跟flatMap 都类似的，只是类型被限定了
     */
    @Test
    public void flatmap() {
        Stream.of("a-b-c-d", "e-f-i-g-h")
                .flatMap(e -> Stream.of(e.split("-")))
                .forEach(System.out::println);

    }

    /**
     * limit 限制元素的个数，只需传入 long 类型 表示限制的最大数
     */
    @Test
    public void limit() {
        Stream.of(1, 2, 3, 4, 5, 6)
                .limit(3) //限制三个
                .forEach(System.out::println); //将输出 前三个 1，2，3
    }

    /**
     * distinct:去重
     */
    @Test
    public void distinct() {
        Stream.of(1, 2, 3, 1, 2, 5, 6, 7, 8, 0, 0, 1, 2, 3, 1)
                .distinct() //去重
                .forEach(System.out::println);
    }


    /**
     * filter 对某些元素进行过滤，不符合筛选条件的将无法进入流的下游
     */
    @Test
    public void filter() {
        Stream.of(1, 2, 3, 1, 2, 5, 6, 7, 8, 0, 0, 1, 2, 3, 1)
                .filter(e -> e >= 5) //过滤小于5的
                .forEach(System.out::println);
    }

    /**
     * peek 挑选 ，将元素挑选出来，可以理解为提前消费
     */
    @Test
    public void peek() {
        User aye = User
                .builder()
                .userName("aye")
                .age(12).build();
        User gd = User
                .builder()
                .userName("gd")
                .age(10).build();
        User xd = User
                .builder()
                .userName("xd")
                .age(18).build();
        Stream.of(aye, gd, xd)
                .peek(e -> e.setUserName(e.getAge() + e.getUserName()))
                .forEach(e -> System.out.println(e.toString()));

    }

    /**
     * skip 跳过 元素
     */
    @Test
    public void skip() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .skip(4) //跳过前四个
                .forEach(System.out::println); //输出的结果应该只有5，6，7，8，9

    }


    /**
     * sorted 排序 底层依赖Comparable 实现，也可以提供自定义比较器
     */
    @Test
    public void sorted() {
        Stream.of(2, 1, 3, 6, 4, 9, 6, 8, 0)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void sortedObject() {

        User aye = User
                .builder()
                .userName("aye")
                .age(12).build();
        User gd = User
                .builder()
                .userName("gd")
                .age(10).build();
        User xd = User
                .builder()
                .userName("xd")
                .age(18).build();

        Stream.of(aye, gd, xd)
                .sorted((e1, e2) -> e1.getAge() > e2.getAge() ? 1 : e1.getAge() == e2.getAge() ? 0 : -1)
                .forEach(System.out::println);
    }


    /**
     * collect 收集，使用系统提供的收集器可以将最终的数据流收集到List，Set，Map等容器中。
     */
    @Test
    public void collect() {

        Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .collect(Collectors.toSet()) //set 容器
                .forEach(e -> System.out.println(e));
    }

    /**
     * count 统计数据流中的元素个数，返回的是long 类型
     */
    @Test
    public void count() {

        long count = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .count();
        System.out.println(count);
    }

    /**
     * findFirst 获取流中的第一个元素
     */
    @Test
    public void findFirst() {

        Optional<String> first = Stream.of("apple", "banana", "orange", "waltermaleon", "grape").findFirst();
        first.ifPresent(System.out::println);

    }

    /**
     * noneMatch 数据流中得没有一个元素与条件匹配的
     * <p>
     * allMatch和anyMatch 一个是全匹配，一个是任意匹配 和noneMatch 类似，这里就不在举例了。
     */
    @Test
    public void noneMatch() {

        boolean result = Stream.of("aa", "bb", "cc", "aa")
                .noneMatch(e -> e.equals("aa"));
        System.out.println(result);

    }

    /**
     * min 最小的一个，传入比较器，也可能没有(如果数据流为空)
     */
    @Test
    public void min() {

        Optional<Integer> integerOptional = Stream.of(0, 9, 8, 4, 5, 6, -1)
                .min((e1, e2) -> e1.compareTo(e2));

        integerOptional.ifPresent(e -> System.out.println(e));

    }


    /**
     * reduce 是一个规约操作，所有的元素归约成一个，比如对所有元素求和，乘啊等。
     */
    @Test
    public void reduce() {

        int sum = Stream.of(0, 9, 8, 4, 5, 6, -1)
                .reduce(0, (e1, e2) -> e1 + e2);
        System.out.println(sum);

    }


}