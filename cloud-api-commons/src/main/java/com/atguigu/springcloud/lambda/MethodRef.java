package com.atguigu.springcloud.lambda;

import com.atguigu.springcloud.entity.Payment;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用: 若 Lambda 体中的内容有方法已经实现了，我们可以使用 "方法引用"
 *      (可以理解为方法引用是 Lambda 表达式的另外一种表现形式)
 *
 * 主要有三种语法格式：
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意：
 *  ① Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致!
 *  ② 若 Lambda 参数列表中的第一个参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 ClassName::method
 *
 *  二、构造器引用
 *
 *  格式:
 *
 *  ClassName::new
 *
 *  注意: 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表一致!
 *
 *  三、数组引用：
 *
 *  Type::new;
 *
 */
public class MethodRef {

    @Test
    public void  test1() {
        Consumer<String> con = x -> System.out.println(x);

        Consumer<String> con1 = System.out::println;
        con1.accept("hello lambda");
    }

    @Test
    public void test2() {
        Payment pay = new Payment();
        Supplier<String> sup = () -> pay.getSerial();
        String str = sup.get();
        System.out.println(str);

        Supplier<String> sup2 = pay::getSerial;
        String serial = sup2.get();
        System.out.println(serial);
    }

    // 类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
        Integer a1 = 3;
        Integer a2 = 8;
        System.out.println(com1.compare(a2, a1));

    }

    //类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp1 = String::equals;

        System.out.println(bp1.test("ss", "ss"));
    }

    // 构造器引用
    @Test
    public void test5(){
        Supplier<Payment> sup = () -> new Payment();

        // 构造器引用
        Supplier<Payment> sup2 = Payment::new;
        Payment payment = sup2.get();
        System.out.println(payment);
    }

    // 数组引用
    @Test
    public void test6(){
        Function<Integer, String[]> fun = x -> new String[x];
        String[] arr = fun.apply(10);
        System.out.println(arr.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] arr2 = fun2.apply(20);
        System.out.println(arr2.length);
    }

}
