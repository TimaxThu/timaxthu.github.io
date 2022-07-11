

# Java的一些语法知识积累

## 静态内部类

经常在代码中，发现在一个public class的大类里面，又有一个static的class。比如在并查集问题中，在大类里面，有一个叫做UnionFind的静态内部类，是专门处理并查集的。

更多**java内部类**的内容，可以查看博客：[Java内部类浅析(含经典面试题解答)-CSDN](https://blog.csdn.net/weixin_40861707/article/details/105789090)。



## HashMap

HashMap是一个散列表，它存储的内容是键值对(key-value)映射。

内部数据结构为==数组 + 链表/红黑树==。HashMap内部使用的是散列方法，并使用红黑树，对多个key在一个table[i]的情况下进行优化。

使用put(key, value)存储对象到HashMap中，使用get(key)从HashMap中获取对象

![HashMap插入元素流程](https://raw.githubusercontent.com/TimaxThu/timaxthu.github.io/master/pictures/post/HashMapProcess.png)

影响HashMap性能的重要参数有：

* 初始容量：`创建哈希表(数组)时桶的数量，默认为 16`
* 负载因子：哈希表在其容量自动增加之前可以达到多满的一种尺度，默认为 0.75

```java
//HashMap的初始化&操作
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> map = new HashMap<String, Object>() {
    {
        put("name", "June");  
        put("age", 12);  
    }
};//高情商：优雅的初始化方式 低情商：没屁格楞嗓子（不推荐）
// 增加元素
map.put("name", "June");  
map.put("age", 12);
// 删除元素
hashMap.remove("age");
// 查找单个元素
System.out.println(hashMap.get("age"));
// 循环所有的 key
for (Object k : hashMap.keySet()) {
    System.out.println(k);
}
// 循环所有的值
for (Object v : hashMap.values()) {
    System.out.println(v);
}
```

