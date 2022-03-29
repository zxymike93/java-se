package xyz.mike.se.fundamentals;

public class MyArray {
    public static void main(String[] args) {
        // int[] a 也可以用 C 的写法 int a[]

        // 创建数组的第一种方式
        int[] a = new int[3];
        for (int i = 1; i <=3; i++) {
            a[i - 1] = i;
        }
        // 创建数组的第二种方式
        int[] b = {1, 2, 3};

        // Java 数据也是引用方式赋值的，用起来和 Python 列表差不多，也类似于 C 的指针
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 10;
        System.out.println(arr1[0]); // 10
    }
}