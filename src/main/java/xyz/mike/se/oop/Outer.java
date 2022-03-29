package xyz.mike.se.oop;

/**
 * 本例演示 inner class
 * 在 Java 中类的所谓成员有 4 种：属性、方法、构造器、代码块、内部类
 * 内部类又有 4 种：局部内部类、匿名内部类、静态内部类、成员内部类
 * 它们的一个特点是可以访问外部类（这个作用域下的属性、方法）
 */
public class Outer {
  private int n = 0;
  private int m = 3;

  /**
   * 局部内部类：
   * Java 中不能在方法里直接定义方法，需要在方法或者代码块中使用类才能定义局部的方法。
   * 然后像初始化一个普通对象一样 new 这个类，就能使用具有局部作用域的方法。
   */
  private void localNamedClass() {

    class Inner0 {
      private int n = 1;

      private void innerM1() {
        System.out.println(n);
        System.out.println(Outer.this.n);
        System.out.println(m);
      }
    }

    (new Inner0()).innerM1();
  }

  /**
   * 局部匿名类：
   * 实际上，内部类也具有面向对象的特性，可以继承一般的类、抽象类，实现接口。
   * 像其他语言一样，有时候我们需要调用一个方法一次会采用匿名函数。
   * 在 Java 中（虽然也有匿名函数）可以使用局部匿名类来实现，它也同时具有了继承的特性。
   */
  private void localAnonymousClass() {

    /*
      一般的匿名内部类相当于
      class Outer$1 extends ClassExample {
      }

      可以赋值给一个变量，也可以直接调用（更像匿名函数）
      如果赋值的话它的编译类型是 ClassExample，但运行类型是内部的。
     */
    (new ClassExample() {
      // 跟一般的类一样可以拓展和重写
      private void foo() {};
    }).foo();

    ClassExample classExample = new ClassExample() {
      public void bar() {};
    };
    classExample.bar();

    /*
       相当于
       class Outer$2 extends AbstractExample {
       }
     */
    (new AbstractExample() {
      @Override
      void hello() {
        System.out.println("hello");
      }
    }).hello();

    /*
      相当于
      class Outer$3 implements InterfaceExample {
      }
     */
    (new InterfaceExample() {
      @Override
      public void hi() {
        System.out.println("hi");
      }
    }).hi();
  }

  /**
   * 成员内部类：
   *
   */
  private class Inner1 {
    private void hi() {
      System.out.println(this.getClass() + " says hi..");
    }
  }

  Inner1 getInner1() {
    return new Inner1();
  }

  private static class Inner2 {

  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    // Access local named class
    outer.localNamedClass();
    // Access local anonymous class
    outer.localAnonymousClass();
    // Access member inner class
    Inner1 aInner1 = outer.new Inner1();
    Inner1 bInner1 = outer.getInner1();
    // Access static inner class

  }
}

class ClassExample {
  public void bar() {
  }
}

abstract class AbstractExample {
  abstract void hello();
}

interface InterfaceExample {
  void hi();
}

class AnotherOuter {
  public static void main(String[] args) {

  }
}
