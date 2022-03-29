package xyz.mike.se.fundamentals;

/**
 * 文档注释
 * 1. 通常用 ** 开头标识后，编辑器会自动识别为文档注释形成格式。
 * 2. 可以用在类、方法、属性上，通过 javadoc 生成的 HTML 会说明对应被标识符号的意义。
 *
 * @author mike
 * @version 1.0
 */
public class Comments {
    /*
      多行注释
      1. 只要在 ** 和 // 之间的内容都属于这个注释里的内容。
      2. 许多编辑器支持快捷键对多行标记为单行注释，所以多行注释相对少用。
    */
    public static void main(String[] args) {
        // 单行注释
        // 一些不是对类、方法、属性的整体说明，常常使用单行注释。
        System.out.println("xyz.mike.se.fundamentals.Hello, World!");
    }
}