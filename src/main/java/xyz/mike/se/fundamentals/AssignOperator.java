package xyz.mike.se.fundamentals;

public class AssignOperator {
    public static void main(String[] args) {
        byte a = 2;
        // a = a + 1; // error: incompatible types: byte cannot be converted to int
        a += 1; // a = (byte)(a + 1);
        a++; // a = (byte)(a + 1);
    }
}