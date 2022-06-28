package reflect;

import entity.Person;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Class对象的功能
 *      1. 获取成员变量
 *          Field[] getFields() 获取所有public修饰的成员变量
 *          Field getField(String name) 获取指定名称的public修饰的成员变量
 *
 *          Field[] getDeclaredFields()
 *          Field getDeclaredField(String name)
 *
 *          Field: 成员变量
 *              1. 设置值
 *                  void set(Object obj, Object value)
 *              2. 获取值
 *                  get(Object obj)
 *              3. 忽略访问权限修饰符的安全检查
 *                  setAccessible(true) 暴力反射
 *
 *      2. 获取构造方法
 *          Constructor<?>[]  getConstructors()
 *          Constructor<T> getConstructor(类<?>... parameterTypes)
 *
 *          Constructor<?>[] getDeclaredConstructors()
 *          Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 *      3. 获取成员方法
 *          Method[] getMethods()
 *          Method getMethod(String name, 类<?>... parameterTypes)
 *
 *          Method[] getDeclaredMethods()
 *          Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 *      4. 获取类名
 *          String getName()
 */

/**
 *  Constructor 构造方法
 *      创建对象：
 *          T newInstance(Object... initargs)
 *          如果使用空参数构造方法创建对象，操作可以简化: Class对象的newInstance方法
 */

/**
 *  Method 方法对象
 *      执行方法
 *          Object invoke(Object obj, Object... args)
 *      获取方法名称
 *          String getName: 获取方法名
 *
 */

public class ReflectDemo02 {

    @SneakyThrows
    @Test
    public void fieldTest() {
        Class<Person> personClass = Person.class;

        Field name = personClass.getDeclaredField("name");
        Person person = new Person();
        name.setAccessible(true);
        name.set(person, "k");
        Object nameValue = name.get(person);
        System.out.println("name: " + nameValue);
        System.out.println(person);
    }

    @SneakyThrows
    @Test
    public void constructorTest() {
        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("张三", 45);
        System.out.println(person);

        Person person1 = personClass.newInstance();
        System.out.println(person1);

    }
}
