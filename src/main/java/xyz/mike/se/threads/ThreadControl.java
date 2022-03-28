package xyz.mike.se.threads;

import org.junit.jupiter.api.Test;

/**
 * 本例演示如何通过标识、方法等方式在程序中控制线程，
 * 同时说明 Thread 类的常用方法以及 Java 线程库中线程的状态。
 *
 * 7 大状态
 */
public class ThreadControl {

  /**
   * 在 main thread 中启动子线程 t
   * 1 起初两个线程并发执行
   * 2 调用 t.join() 之后，主线程会进入 WAIT 状态，直到 t 执行完
   * 3 相当于调用者让被调用者 *插队*
   */
  private static void joinThreadTest() throws InterruptedException {
    ThreadToJoin t = new ThreadToJoin();
    t.start();

    for (int i = 0; i < 5; i++) {
      System.out.printf("%s: do stuff %d%n", Thread.currentThread().getName(), i);
      Thread.sleep(1000);
      if (i == 2) {
        t.join();
      }
    }
  }

  /**
   * 1 两个线程仍然并发执行
   * 2 yield 表示让出时间给共用 CPU 的线程
   */
  private static void yieldThreadTest() throws InterruptedException {
    ThreadToJoin t = new ThreadToJoin();
    t.start();

    for (int i = 0; i < 5; i++) {
      System.out.printf("%s: do stuff %d%n", Thread.currentThread().getName(), i);
      Thread.sleep(1000);
      if (i == 2) {
        Thread.yield();
      }
    }
  }

  /**
   * 默认情况下线程是否执行不受其他线程影响。
   * 如果使用 setDaemon 设置子线程为守护线程，线程会随着所有其他用户线程中止而中止。
   * 用户线程是指，同一个进程创建的所有线程。
   */
  private static void daemonThreadTest() throws InterruptedException {
    DaemonThread t = new DaemonThread();
    t.setDaemon(true);
    t.start();

    for (int i = 0; i < 5; i++) {
      System.out.printf("%s: do stuff %d%n", Thread.currentThread().getName(), i);
      Thread.sleep(1000);
    }
  }

  /**
   * Thread.State 枚举类定义了 6 种线程状态:
   * - NEW: new Thread() 创建一个线程对象后的状态
   * - RUNNABLE: thread.start() 线程对象进入该状态，取决于是否被 CPU 执行，可能处于 ready/running 状态
   * - BLOCKED: 涉及线程之间同步，如果在等待一个同步的资源，则进入该状态；当这个状态结束，会回到 RUNNABLE
   * - WAITING: 涉及等待，比如 .wait() .join() 等，则进入该状态；当这个状态结束，会回到 RUNNABLE
   * - TIMED_WAITING: 指定时间的休眠、等待，比如 .sleep(time) .wait(time) .join(time) 等，则进入该状态；当这个状态结束，会回到 RUNNABLE
   * - TERMINATED: .run() 执行结束
   */
  private static void threadStatesTest() {
  }

  public static void main(String[] args) throws InterruptedException {
    // joinThreadTest();
    // yieldThreadTest();
    daemonThreadTest();
  }
}

class ThreadToJoin extends Thread {
  @Override
  public void run() {
    Thread.currentThread().setName("Thread-Join");
    for (int i = 0; i < 10; i++) {
      System.out.printf("%s: do stuff %d%n", Thread.currentThread().getName(), i);
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class DaemonThread extends Thread {
  @Override
  public void run() {
    for (;;) {
      System.out.printf("%s: service...%n", Thread.currentThread().getName());
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

/**
 * 可以通过修改线程类中的标志位改变 run 中的逻辑判断结果，以此控制线程类中的程序执行。
 */
class StopByFlagThread implements Runnable {
  private boolean flag = true;

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  @Override
  public void run() {
    while (flag) {
      System.out.println(Thread.currentThread().getName() + ": Hello...");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void test() {
    StopByFlagThread r = new StopByFlagThread();
    Thread t = new Thread(r);
    t.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    r.setFlag(false);
  }
}