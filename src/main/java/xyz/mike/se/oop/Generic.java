package xyz.mike.se.oop;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Generic {
  public static void main(String[] args) {
    genericTest0();
    genericTest1();
  }

  private static void genericTest0() {
    // 使用定义为接收范型的类，new 的时候按位置传入的类型就会对应到指定的范围占位符上
    Person<Hobbit> p1 = new Person<Hobbit>("Mike", new Hobbit());
    Person<String> p2 = new Person<String>("Mike", "Coding");
    // 上面赋值表达式右侧 <> 中的类型也是可选的，只要左侧声明类型的时候指定就可以采用以下缩写
    Person<Integer> p3  = new Person<>("Mike", 0);

    Hobbit hobbit = p1.getHobbit();
    // 正如上面定义的编译类型，检查运行类型得到的结果和编译类型一致
    System.out.println(p2.getHobbitClass());
    System.out.println(p3.getHobbitClass());
  }

  private static void genericTest1() {

  }
}

/**
 * 范型类
 *
 * @param <E> 指定这个类接收的范型，它使用 E 这个占位符。那么在这个类里面 E 就可以使用在属性、参数、返回值等地方，限定类型。
 */
class Person<E> {
  String name;
  E hobbit;

  // 在构造器中（也就是对象初始化的时候），传入的 E 对应的类型就决定了这个范型类里面 E 代表什么类型
  // 但是由于范型类标识的范型是新建对象才决定的，这个范型无法用在 static 成员中（因为是随类加载的）。
  public Person(String name, E hobbit) {
    this.name = name;
    this.hobbit = hobbit;
  }

  // 范型类中的普通方法
  E getHobbit() {
    return hobbit;
  }

  Class<?> getHobbitClass() {
    return hobbit.getClass();
  }
}

class Hobbit {
  // 范型方法则是在方法前面定义范型标识
  // 它是可以使用在 static 方法中的
  private static <T> void code(T t) {
    System.out.println(t);
  }
}

/**
 *
 * @param <K>
 * @param <V>
 */
interface GenericInterface<K, V> {

}

// 由于范型不支持继承关系，比如 List<Object> ls = new ArrayList<String>(); 会编译错误
// 所以引入了通配符，以及上界/下界的概念。