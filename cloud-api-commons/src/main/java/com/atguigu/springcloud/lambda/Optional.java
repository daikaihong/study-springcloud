package com.atguigu.springcloud.lambda;

/**
 * Optional 容器类的常用方法
 * Optional.of() : 创建一个 Optional 实例
 * Optional.empty() : 创建一个空的 Optional 实例
 * Optional.ofNullable(T t) : 若 t 不为null,创建Optional实例，否则创建空实例
 * isPresent() : 判断是否包含值
 * orElse(T t) : 如果调用对象包含值，返回改值，否则返回 t
 * orElseGet(Supplier s) : 如果调用对象包含值，返回该值，否则返回 s 获取的值
 * map(Function f) : 如果有值对其处理，并返回处理后的Optional,否则返回Optional.empty()
 * flatMap(Function mapper) : 与 map 类似，要求返回值必须是Optional
 */
public class Optional {
}
