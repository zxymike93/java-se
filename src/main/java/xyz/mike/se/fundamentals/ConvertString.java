package xyz.mike.se.fundamentals;

/**
 * String 和 Primitive Types 的转换
 */
public class ConvertString {
    public static void main(String[] args) {
        // Primitive Types -> String
        int a = 127;
        float b = 3.14F;
        double c = 3.14;
        boolean d = true;
        System.out.println(String.valueOf(a));
        System.out.println(String.valueOf(b));
        System.out.println(String.valueOf(c));
        System.out.println(String.valueOf(d));

        // String -> Primitive Types
        int e = Integer.parseInt("127");
        long f = Long.parseLong("12345678901234"); // 不用加 L
        float g = Float.parseFloat("3.14"); // 可以但不用加 F
        double h = Double.parseDouble("3.14");
        boolean i = Boolean.parseBoolean("false");

        // char
        String j = String.valueOf('a');
        char k = "abc".charAt(0);
    }
}