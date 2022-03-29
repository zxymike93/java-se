package xyz.mike.se.fundamentals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashSet 和 HashMap 及其子类均以 HashMap 为基础实现。
 * 本例解读 HashMap 的源码实现。
 */
public class DataStructure {
  /*
    1 HashMap 的初始化有 4 种形式的构造器：
      1 无参：初始化 loadFactor 为 0.75
      2 (int)：设定 initCapacity 并初始化 loadFactor
      3 (int, float)：设定 initCapacity, loadFactor
      4 (Map, boolean)：从另一个 Map 得到一个对象；其中的 evict 是 WeakHashMap 的参数

    2 添加值（put）无论如何，首先需要对 key 进行哈希；使用 Object 类的 .hashCode() >>> 16 得到 key
      接下来再调用 .putVal() 决定 k-v 的存储方式；它们被存储在一个 Node<K,V>[] table 属性中，其中 Node 是 Map.Entry 的实现类（定义了 .getKey() .getVal()）
      1 空 HashMap 会根据 DEFAULT_INITIAL_CAPACITY 分配 16 个元素大小的空间
      2 起初 table 是简单的 Array+LinkedList 的形式存放元素的；同时 size 属性维护整个 HashMap 的元素个数。
      3 当出现以下情况，数据结构会被改变：
        1 size >= table.length * loadFactor || 单个 Node 链接的长度 >= TREEIFY_THRESHOLD(8)
          1 .resize() 都将 table.length * 1.5
          2 .rehash() 重新分配元素的存放位置
        2 当以上机制都无法维持 table 的大小在 MIN_TREEIFY_CAPACITY(64) * loadFactor 范围内
          1 调用 .treeifyBin() 将新增 Node 所在的链表转为红黑树
          2 .resize() 增加 table 大小
      4 循环上述过程直到 table 大小超过 MAXIMUM_CAPACITY

    3 搜索值（get）大致相当于上述过程的逆向。

    以上解释可以通过 debugger step into 查看源码理解。
    由此可见，HashMap 在大小较小时查找、修改元素的时间复杂度是 O(1)，逐渐发展为树后取向 O(logN)。

    4 另外，HashMap 提供了 .keySet() .entrySet() .values() 三个方法，它们分别返回维护了 keys k-v values 引用的集合，
      这样就能更方便地遍历 Map 而不是通过访问内部维护的 table 这样的形式。
 */
  public static void main(String[] args) {
  }
}