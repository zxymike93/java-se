package xyz.mike.se.threads;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 本例演示如何实现线程以及如何启动线程，以及 Thread 类的常用方法。
 *
 * 实现线程有两种方式：
 * 1 继承 Thread 类，重写 run 方法
 * 2 实现 Runnable 接口，重写 run 方法
 *
 * 对应以上两种实现方式，分别有两种启动线程的写法。
 * 不过本质上都是使用 start 方法：
 * 1 调用底层的 native start0 来创建系统线程
 * 2 将其标记为 runnable 状态
 * 3 系统调度才是真正决定何时运行该线程
 *
 * jconsole 可以监测线程运行情况
 */
public class ThreadBasics {
  /**
   * 通常有多少个 CPU 核心就能 *并行* 执行多少个任务
   * *并发* 则不强调同一时刻执行，常常是指单核心在多任务间来回切换实现"同时"的效果
   */
  @Test
  public void countCpuTest() {
    Runtime runtime = Runtime.getRuntime();
    int nProcessors = runtime.availableProcessors();
    System.out.println("当前电脑 CPU 核心数：" + nProcessors);
  }

  private static void threadMethodsTest() throws InterruptedException {
    RunnableThread r = new RunnableThread();
    Thread t = new Thread(r);
    t.setName("Thread-Methods");
    t.setPriority(Thread.MIN_PRIORITY);
    System.out.println(String.format("线程优先级：%d", t.getPriority()));
    t.start();
    Thread.sleep(2000);
    t.interrupt();
  }

  public static void main(String[] args) throws InterruptedException {
    // SubclassThread.test();
    // RunnableThread.test();
    threadMethodsTest();
  }
}

/**
 * 实现方式一
 * 1 继承 Thread 并实现 .run()
 * 2 .start() 由系统启动线程中的任务
 * 3 无法继承其他类
 */
class SubclassThread extends Thread {
  private int n = 0;

  @Override
  public void run() {
    do {
      // 在线程类内部需要使用 Thread.currentThread() 才能获取该线程对象（通过 this 是拿不到的）
      System.out.println(Thread.currentThread().getName() + ": " + (++n) + " Meow~");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (n < 10);
  }

  public static void test() {
    for (int i = 0; i < 3; i++) {
      // 初始化一个线程并启动
      SubclassThread t = new SubclassThread();
      t.start();
    }
    // 程序（main）线程不会 blocked
    System.out.println(Thread.currentThread().getName() + " keeps on running..");
  }
}

/**
 * 实现方式二
 * 1 implements Runnable 需要作为构造参数传给一个 Thread 对象，再调用 .start()
 * 2 实现接口的方式避免了单继承，更灵活
 * 3 Thread 也是实现了 Runnable 接口以及 run() 方法的。
 */
class RunnableThread implements Runnable {
  private int n = 0;

  @Override
  public void run() {
    do {
      System.out.println(Thread.currentThread().getName() + ": " + (++n) + " Woof~");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (n < 10);
  }

  /**
   * t.run() 是不会创建新线程的，只是普通的方法执行（在 main 线程中）。
   * 在 Thread 中是使用代理模式（以 Runnable）作为属性，
   * 用 synchronized start() 创建的线程来调用 runnable.run() 的
   */
  public static void test() {
    RunnableThread runnable = new RunnableThread();
    Thread t = new Thread(runnable);
    t.start();
  }
}

class CallableThread implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    return 0;
  }

  @Test
  public void test() {
    CallableThread c = new CallableThread();
    FutureTask<Integer> future = new FutureTask<>(c);
    Thread t = new Thread(future);
    t.start();
    try {
      System.out.println(future.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
