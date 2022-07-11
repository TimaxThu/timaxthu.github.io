---
date: 2022-05-28
course: 体系班 第29节 Manacher算法
color: 标记颜色 - #007FC8 IDEA TODO同款蓝色
detail: - 回文序列
        - 最长回文子序列Manacher算法
---



> Java并查集相关代码可以在 `algorithbasic2020-master ` 中 `package class15` 中查到





# 回文序列

回文序列，就是从左向右看和从右向左看内容相同的序列。例如：abcba，112211

根据回文序列的长度，可以吧回文序列分为奇回文序列（例如 abcba）和偶回文序列（例如 112211）。

奇回文序列的对称轴在一个字母上，偶回文序列的对称轴不在字母上。





# 最长回文子序列问题

我们的问题就是寻找一个字符串中的**最长回文子序列**。

需要注意的是，回文子序列一定要是连续的。比如字符串“1xabbay1”的最长回文子序列是“abba”，不是“1abba1”

## 暴力解法

【思路】

从每一个字符开始，向两侧扩展，看最多能扩到多少个字符。

> 例如字符串：acbcx
> 先以a为对称轴，向两侧扩充，他的最长子串就是自己
> 然后以c为对称轴，可以扩充得到最长子回文序列“aba”
> 然后以b为对称轴，可以扩充到最长子回文序列“cbc”
> 然后继续......

但是这样我们只能找到奇回文序列。例如字符串“abba”，他就不能很好的寻找到最长子回文序列。

解决方案也很简单：为了找到偶回文序列，我们在最原始的字符间隔（包括左右两端）加上一个特殊字符，例如“#”。对处理后的字符串进行回文序列计算，把每一个回文数除以2，得到的是最原始串中最大回文串的长度。

> 例如原始串为“cabbag”。我们进行处理，在字符串间隔和两端加上特殊字符“#”
> 处理后的字符串为“#c#a#b#b#a#g#”
> 之后遍历处理后字符串，求最长子回文串。



【思考问题】

这里需要思考一个问题，测验一下你是否明白了处理串的原理：把原始串变成处理串的过程中，如果选择的“特殊字符”在原始串中出现过，会影响最终的答案吗？会影响回文子串的长度吗？

答案是：选择的"特殊字符"并不会影响最终回文串的长度。因为在比较过程中，原始字符互相比较，特殊字符互相比较，虚的字符并不会和实的字符比较。换句话说，**<font color = #007FC8>特殊字符是什么都行，不影响答案</font>**。



【时间复杂度】

暴力方法的时间复杂度：$O(n^2)$



【暴力代码】

```java
public static int bruteForce(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    char[] str = manacherString(s); // "12132" -> "#1#2#1#3#2#"
    int max = 0;
    for (int i = 0; i < str.length; i++) {
        int L = i - 1;
        int R = i + 1;
        while (L >= 0 && R < str.length && str[L] == str[R]) {
            L--;
            R++;
        }
        max = Math.max(max, R - L - 1);
    }
    return max / 2;
}
```





## Manacher算法

Manacher方法将该问题的时间复杂度由 $O(n^2)$ 降为了 $O(n)$

这个算法在原来暴力思路的基础上进行了优化，之所以会快，是因为：**Manacher之前计算的数据会知道后面的工作，前面扩的行为会加速后面的操作行为。**



【概念的说明】


1) <font color = #007FC8>**回文直径和回文半径**</font>
2) <font color = #007FC8>**回文半径数组**</font>：把每一个字符的回文半径记录在数组中
3) <font color = #007FC8>**最右回文边界R**</font>：记录已经遍历过的字符中，回文半径最右面的位置
4) <font color = #007FC8>**取得最右回文右边界时中心的位置C**</font>（R只要更新，C就负责记录）



【算法思路】

求字符i的回文子串时只有两种情况：

* i没被R罩住
* i被R罩住了

如图，可以左右一定i自行理解

```java
//-------------)R
//字符串
//        <i>
```

如果i没有被R罩住，那么没有优化办法，就是向外扩。

如果R被罩住，此时可以细分为三种情况：

我们考虑，此时i在回文序列[L,R]中的左侧一定有一个对应的`i'`

* 【第一种情况】<font color = #007FC8> `i'` 的回文区域在[L,R]内，则i的回文区域与i'一致</font>

证明：因为[L,R]内以C为轴是回文序列，可以知道i的回文序列长度≥i'。
i'的左右字符串分别为a,b，可知a≠b（因为如果相等那么ab也会在i'的回文区域中）id左侧字符c=b，右侧字符d=a，则c≠d。

* 【第二种情况】<font color = #007FC8>i'的会文区域左边界超过L，有一部分在[L,R]外部，此时i的回文区域右边界到R</font>

* 【第三种情况】<font color = #007FC8>i'的会文区域的左边界和L压线，i的回文区域至少为i'，向外扩要继续验证</font>

```java
//eg: X[a b c b a s t s a b c b a]Y
//      L   i'      C       i   R
```



【时间复杂度】O(n)

这种方法为 $O(n)$ 的原因在于，只要计算的内容在R内侧，如情况1&2，此时的时间复杂度就是 $O(1)$ 的。

而当需要暴力扩展时，又一定会向右更新R的值。更新R一直向右，且只需要一趟就行。所以最终的时间复杂度为 $O(n)$。





# Manacher代码实现

【Manacher相关代码可以在 `algorithbasic2020-master ` 中 `package class28` 中查到】

```java
public class Code_Manacher {

	public static int manacher(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// "12132" -> "#1#2#1#3#2#"
		char[] str = manacherString(s);
		// 回文半径的大小
		int[] pArr = new int[str.length];
		int C = -1;
		// 讲述中：R代表最右的扩成功的位置
		// coding：最右的扩成功位置的，再下一个位置(也就是失败的位置)
		int R = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < str.length; i++) { // 0 1 2
			// R第一个违规的位置，i>= R
			// i位置扩出来的答案，i位置扩的区域，至少是多大。
			pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            // R>i:如果i在R内（被罩住了）
            //2*C-1是i'。i'的回文半径长度和R到i的距离谁小要谁（至少不用验的区域）
            //否则给他1
            
            //将 多种情况的判断 和 向外扩结合写在了while中
			while (i + pArr[i] < str.length && i - pArr[i] > -1) {
				if (str[i + pArr[i]] == str[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
            
			if (i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static char[] manacherString(String str) {// "12132" -> "#1#2#1#3#2#"
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

}
```

