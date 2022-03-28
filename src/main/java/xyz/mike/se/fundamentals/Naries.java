package xyz.mike.se.fundamentals;

/**
 * 演示各种进制在 Java 中的表示和使用方式
 */
public class Naries {
    public static void main(String[] args) {
        /*
            在 Java 中各种进制的表示方式如下
         */

        // Binary starts with 0b
        int a = 0b1010; // 10
        // Octal starts with 0
        int b = 01010; // 520
        // Hexadecimal starts with 0x
        int c = 0x10; // 16


        /*
            各种进制之间的转换方式
            根据其特性归为遗下四组
         */

        // 各种进制转十进制，大体来说是幂运算。
        // 二进制：1*2^0 + 1*2^1 + 0*1^2 + 1*2^3 = 11
        int d = 0b1011;
        // 八进制: 4*8^0 + 3*8^1 + 2*8^2 = 156
        int e = 0234;
        // 十六进制: 10*16^0 + 3*16^1 + 2*16^2 = 570
        int f = 0x23A;

        // 十进制转各种进制，大体来说是求余。
        // decimal -> binary: 以2取模，其最后的商和余数组成二进制。
        // 注意，因为 binary 要直接以最小单位 byte 存储，所以是 8 的倍数位。0B00100010
        System.out.println(Integer.toBinaryString(34));
        // decimal -> octal: 以8取模，其最后的商和余数组成八进制。0203
        System.out.println(Integer.toOctalString(131));
        // decimal -> hexadeximal: 以16取模，其最后的商和余数组成十六进制。0x23
        System.out.println(Integer.toHexString(35));

        // 二进制转其他进制，虽然可以先转十进制再转换，但根据2的幂次正好有8和16，可以按位划分转换。
        // binary -> octal: 从低位每三位换算成一个八进制数
        // 0b11010101 -> 0325
        // binary -> hexadeximal: 从低位每四位换算成一个十六进制数
        // 0b11010101 -> 0xD5

        // 其他进制转二进制，就相当于二转其他反过来。
        // octal -> binary: 把每一位数转为三位的二进制
        // 0237 -> 0B010011111
        // hexadecimal -> binary: 把每一位数转为四位的二进制
        // 023B -> 0B001000111011
    }
}