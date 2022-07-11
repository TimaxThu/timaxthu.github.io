---
title: java标准类库
detail: - 
        -
        -
        -
        -
        -
---



层次结构 & 具体函数





基本数据类型的封装类型 P23





# Java 常用包

## java.lang包 P60

java.lang包是java语言的核心，它提供了java中的基础类。包括基本Object类、Class类、String类、基本类型的包装类、基本的数学类等等最基本的类。

如果要利用java类库中的类，需要在程序中使用import语句来导入相关的包（类库），但是**java.lang包由解释程序自动加载，不需在程序中显示引入**。

java.lang包中的类

| Boolean                | Long              | StrictMath   |
| ---------------------- | ----------------- | ------------ |
| Byte                   | Math              | String       |
| Character              | Number            | StringBuffer |
| Class                  | Object            | System       |
| ClassLoader            | Package           | Thread       |
| Compiler               | Process           | ThreadGroup  |
| Double                 | Runtime           | ThreadLocal  |
| Float                  | RuntimePermission | Throwable    |
| InheritableThreadLocal | SecurityManager   | Void         |
| Integer                | Short             |              |

java.lang包中的接口

| 接口名                          | 接口描述                                                     |
| ------------------------------- | ------------------------------------------------------------ |
| Appendable                      | 能够添加char序列和值的对象                                   |
| CharSequence                    | char值的一个可读序列                                         |
| Cloneable                       | 此类实现了Cloneable接口，以指示Object.clone()方法可以合法地对该类实例进行按字段复制 |
| Compareable                     | 此接口强行对实现它的每个类的对象进行整体排序                 |
| Iterable                        | 实现这个接口允许对象成为“foreach”语句的目标                  |
| Readable                        | Readable是一个字符源                                         |
| Runnable                        | Runnable应该由那些打算通过某一线程执行其实例的类来实现       |
| Thread.UncaughtExceptionHandler | 当Thread程序因未补货的异常而突然终止时，调用处理程序的接口   |







## java.util包

java.util 包是Java 实用工具类库。在这个包中，Java提供丁一些实用的方法和数据结构。例如，Java 提供日期（Data）类、日历（Calendar）类来产生和获取日期及时间，提供随机数（Random）类产生各种类型的随机数，还提供了堆栈（Stack）、向量（vector）、位集合（Bitset）以及散列表（Hashtable）等类来表示相应的数据结构。

![截屏2022-06-20 11.36.11](/Users/letme/Library/Application Support/typora-user-images/截屏2022-06-20 11.36.11.png)







# Java 常用类

## Object类



Object 类是所有Java 类的基类，它处于 Java 开发环境的类层次树的根部，所有其他类都是由 Object 类直接或间接派生出来的。如果一个类在定义时没有包含 extends 关键字，编译器会将其**作为 Object 类的直接子类**。Objeot 类定义了所有对象的最基本的状态和行为，它提供的方法会被 Java 中的每个类所继承。

可以使用类型为 Object 的变量引用任意类型的对象。Object类有一个默认构造方法public Object(). 在构造子类对象实例时，都会先调用这个默认构造方法。

Object 类的变量能够作为各种对象的通用持有者，但如果要对它们进行任何专门的操作，需要知道他们的类型并转换。例如：
Object obj = new MyObject();
MyObject x = (MyObject)obj;

Object类的常用方法及其说明：





## System类 P62













## 基本数据封装类型 P23

### Integer类

* Integer 类是基本数据类型 int 的封装类。Integer 类在对象中包装了一个基本类型 int 的值。
* Integer 类的**继承关系**：
  java.lang.Object->java.lang.Number->java.lang. Integer
* Integer 类常用的**成员属性**包括：
  【常量】MAX_VALUE ：int类型的最大值，值为 $2^{31}-1$；
  【常量】MIN_ VALUE ：int类型的最小值，值为 $-2^{31}$ 。
* Integer 类的构造方法：
  通过 int 值构造 Integer 对象；
  通过 String 宇符串构造 Integer 对象。
* Integer 类提供了多个方法，能在 int 类型和 String 类型之间互相转换，以及处理 int 类型时非常有用的其他方法
  compareTo()
  parselnt()
  toBinaryString()
  tostring()
  equals()
  valueof()
  intValue() 




### Float类

* Float 类是基本数据类型 foat 的封装类。Float 类在对象中封装了一个基本类型 foat 的值。
* Float 类的继承关系：
  java.lang.Object->java.lang.Number->java.lang.Float
* Float类的常用成员属性包括：
  MAX_VALUE：foat类型的最大正有限值，即 $(2-2^{-23})\cdot2^{127}$；
  MIN_VALUE：foat类型的最小正非零值，即 $2^{-149}$；
  POSITIVE_INFINITY：float 类型的正无穷大值；
  NEGATIVE_INFINITY：float 类型的负无穷大值；
  SIZE：一个foat值所使用的位数。
* Float 类的构造方法包括：
  通过float 值构造 Float 对象
  通过 Double 值构造 Float 对象
  通过 String 宇符串构造 Float 对象
* Float 类提供了几种方法：
  parseFloat()
  toString()
  compareTo()
  shortValue()
  intValue()



### Character类

* Character 类是基本数据类型 char 的封装类。Character 类在对象中封装一个基本类型char 的值。
* Character 类的继承关系：java.lang.Object->java.lang.Character。
* Character 类常用的成员属性包括：
  MAX_VALUE：char 类型的最大值，`'\uFFFF'`；
  MIN_VALUE： char 类型的最小值，` '\u0000'`。
* 类提供的方法：
  isLetter()：判断指定字符是否为字母
  isDigit()：判断指定字符是否为数字
  toLowerCase()：判断指定字符是否为小写字母
  toUpperCase()：判断指定字符是否为大写字母
  isWhitespace()：判断指定字符是否为空白字符
  （空白符包含：空格`' '`、tab 键`'\t'`、换行符`'\n'`）



### Boolean类

* Boolean 类是基本数据类型boolean 的封装类。
* Boolean 类的继承关系：java.lang.Object->java.lang. Boolean。
* Boolean 类的常用成员属性包括：
  TRUE 对应基值 true 的 Boolean 对象
  FALSE 对应基值 false 的 Boolean 对象。
* Boolean 类的构造方法包括：
  通过boolean 值来构造 Boolean 对象；通过 String 值来构造 Boolean 对象。
* 此类还为 boolean 和 String 的相互转换提供了许多方法，以及处理 boolean 类型时非常有用的其他方法，如 parseBoolean()、toString0。






书P59







