package xyz.mike.se.fundamentals;

import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Wrapper {
  public static void main(String[] args) {
    // Manually
    int n = 26;
    // Boxing
    Integer intN = Integer.valueOf(n);
    // Unboxing
    int i = intN.intValue();

    // Automatically 可以使用 debugger 观察，编译器默认还是等同于上述的方法来装箱/拆箱
    int m = 64;
    Integer intM = m;
    int j = intM;
    }
}
