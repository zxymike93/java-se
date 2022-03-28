package xyz.mike.se.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 本例演示 Java 是如何将文件/目录作为对象操作的
 */
public class FileTests {
  /**
   * 本例演示创建文件对象的三种方式，以及如何创建文件。
   * new File 只在内存中创建了文件对象，.createFile() 才会写入磁盘。
   */
  @BeforeEach
  void setUp() {
    // File fileObject = new File("test.txt");
    // File fileObject = new File("src/main/resources", "test.txt");
    File parent = new File(".");
    File fileObject = new File(parent, "test.txt");
    try {
      fileObject.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterEach
  void tearDown() {
    File testFile = new File("test.txt");
    if (testFile.exists())
      testFile.delete();

    File testResourcesDir = new File("src/test/resources");
    if (testResourcesDir.exists())
      testResourcesDir.delete();

    File mainResourcesDir = new File("src/main/resources");
    if (mainResourcesDir.exists())
      mainResourcesDir.delete();
  }

  /**
   * 文件对象的的常用方法
   */
  @Test
  public void fileTest() {
    File parent = new File(".");
    File file = new File(parent, "test.txt");
    System.out.println(file.getParent());
    System.out.println(file.getAbsolutePath());

    assertTrue(file.exists());
    assertTrue(file.isFile());
    assertTrue(file.getParentFile().isDirectory());
    assertEquals(file.getName(), "test.txt");
    assertEquals(file.length(), 0);
  }

  @Test
  public void directoryTest() {
    // 类似于 bash 的 mkdir 和 mkdir -p
    File projectRoot = new File(".");

    File testFile = new File(projectRoot, "test.txt");
    assertTrue(testFile.delete());

    String testResourcesPath = "src/test/resources";
    File testResourcesDir = new File(projectRoot, testResourcesPath);
    assertFalse(testResourcesDir.mkdir());

    String mainResourcesPath = "src/main/resources";
    File mainResourcesDir = new File(projectRoot, mainResourcesPath);
    assertTrue(mainResourcesDir.mkdirs());
  }
}
