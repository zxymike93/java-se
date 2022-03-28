package xyz.mike.se.fundamentals;

/**
 * 说明 Java 的 8 大基本数据类型
 */
public class PrimitiveTypes {
    public static void main(String[] args) {
        // 整型
        byte a = 127; // 1 byte = 8 位，最大值为 127，最小值为 -128
        short b = 32767; // 2 bytes = 16 位，最大值为 32767，最小值为 -32768
        int c = 2147483647; // 4 bytes = 32 位，默认的整数都是 int 类型
        long d = 9223372036854775807L; // 8 bytes = 64 位，需要显式使用 L 标识为 long 类型

        // 浮点型
        float e = 3.14F; // 4 bytes = 32 位，遵循 IEEE 754 标准，需要显式使用 F 标识为 float 类型
        double f = 3.14; // 8 bytes = 64 位，默认的小数都是 double 类型

        // 字符
        char g = 'a'; // 2 bytes = 16 位，支持 Unicode 字符集
        char h = '\t'; // 转义字符
        char i = '\u0061'; // Unicode 字符
        char j = 97; // char 的本质是 ascii 编码下对应的数值，可以使用对应的 ascii 字符的值来赋值
        int k = (int) 'a'; // 也可以 cast 一个 int 为对应的 char
        char l = 'a' + 11; // 因此也可以通过数值计算得到对应 ascii 的值而得到相应的 char

        // 布尔
        boolean m = true; // 1 byte = 8 位，默认为 true

        // auto convert:
        // 1. char -> short -> int -> long -> float -> double
        // 2. byte -> int -> long -> float -> double
        // **注意**：
        // 1. byte 和 char、short 是不会自动转换的
        // 2. 但它们之间进行数值运算都会先转为 int

    }
}