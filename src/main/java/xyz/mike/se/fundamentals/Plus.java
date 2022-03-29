package xyz.mike.se.fundamentals;

public class Plus {
    // 基本运算符中只有 + 是特殊的（根据类型重载）
    // 其他运算符只支持数值运算
    // + 支持字符串拼接
    public static void main(String[] args) {
        System.out.println(7 + 3.14);

        // 如果有字符串则拼接
        System.out.println("xyz.mike.se.fundamentals.Hello, " + 7);
        System.out.println("xyz.mike.se.fundamentals.Hello, " + 7 + 3.14);

        // 运算是从左到右的，所以先计算数值，再拼接字符串
        System.out.println(7+3.14+"xyz.mike.se.fundamentals.Hello, ");
    }
}