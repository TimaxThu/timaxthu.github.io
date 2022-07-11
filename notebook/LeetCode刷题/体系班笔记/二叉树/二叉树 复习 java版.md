---
color: #007FC8
---





## 二叉树基本结构

```java
class Node {
    int data;
    Node left;
    Node right;
}
```





## 二叉树遍历 class11

### 前序 中序 后序

先序：任何子树的处理顺序都是，先头节点、再左子树、然后右子树
中序：任何子树的处理顺序都是，先左子树、再头节点、然后右子树
后序：任何子树的处理顺序都是，先左子树、再右子树、然后头节点

```java
public static void f(Node head) {
    if (head == null) return;
    // 1 打印行为放这里是先序 pre
    f(head.left);
    // 2 打印行为放这里是中序 in
    f(head.right);
    // 3 打印行为放这里是后序 pos
}
//1,2,3都打印是递归序
```







### 前序 中序 后序 非递归





### 层次遍历





## ==序列化和反序列化==

一颗树状结构的二叉树对应一个唯一的字符串

序列化：将二叉树转化成字符串

反序列化：将字符串转化成二叉树





## 基本算法



### [判断两棵树是否相同](https://leetcode.cn/problems/same-tree/)

```java
class Solution {
    public static boolean isSameTree(TreeNode rt1, TreeNode rt2) {
        if (rt1 == null && rt2 == null) return true;
        else if (rt1 == null || rt2 == null) return false;
        if (rt1.val != rt2.val) return false;
        return isSameTree(rt1.left, rt2.left) && isSameTree(rt1.right, rt2.right);
    }
}
```

















