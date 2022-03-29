package xyz.mike.se.fundamentals;

public class ArithmeticOperator {
    public static void main(String[] args) {
        // 除的注意事项
        System.out.println(10 / 4); // 2
        System.out.println(10.0 / 4); // 2.5
        double a = 10 / 4; // 2.0

        // 取模的注意事项：a % b = a - a / b * b
        System.out.println(-10 % 3); // -1
        System.out.println(10 % -3); // 1
    }
}