package xyz.mike.se.oop;

/**
 * 本例说明类在实例化的时候，static member, member, constructor 的执行顺序。
 * 大体来说，static member > member > constructor。
 *
 * 如果涉及继承，则会因继承关系更复杂些，详见例子。
 * 进一步说，类首先被加载。加载时 static member 就被加载到 *方法区* 中了。
 * 其次才会在 *堆* 中分配空间和创建对象，而调用 constructor 又隐式地调用父类构造器和本类代码块。
 */
public class ObjectInitOrder {
  public static void main(String[] args) {
    new SubClass();
  }
}

class SuperClass {
  // 1
  private static int n = getN();
  // 2
  static {
    System.out.println(SuperClass.class.getName() + " init static code block.");
  }
  // 5
  private int m = getM();
  // 6
  {
    System.out.println(SuperClass.class.getName() + " init code block.");
  }

  private static int getN() {
    System.out.println(SuperClass.class.getName() + " init static field.");
    return 1;
  }

  private int getM() {
    System.out.println(SuperClass.class.getName() + " init field.");
    return 2;
  }
  // 7
  public SuperClass() {
    System.out.println(SuperClass.class.getName() + " constructor.");
    System.out.println(m);
  }
}

class SubClass extends SuperClass {
  // 3
  private static int n = getN();
  // 4
  static {
    System.out.println(SubClass.class.getName() + " init static code block.");
  }
  // 8
  private int m = getM();
  // 9
  {
    System.out.println(SubClass.class.getName() + " init code block.");
  }

  private static int getN() {
    System.out.println(SubClass.class.getName() + " init static field.");
    return 1;
  }

  private int getM() {
    System.out.println(SubClass.class.getName() + " init field.");
    return 2;
  }
  // 10
  public SubClass() {
    // constructor 会隐式地调用
    // super()
    // code block
    System.out.println(SubClass.class.getName() + " constructor.");
    System.out.println(m);
  }
}
