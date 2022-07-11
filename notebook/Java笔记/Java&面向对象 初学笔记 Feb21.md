# Java介绍

## 解释性语言和编译性语言

Interpreted language and compiled language

高级语言，汇编语言，机器语言





## java EE&SE&ME; JDK&JRE;==SDK==







# ==问题==

查询java版本

[(5条消息) Mac下查看已安装的jdk版本及其安装目录_iCoding91的博客-CSDN博客_mac查看jdk安装目录](https://blog.csdn.net/caoxiaohong1005/article/details/73611424)



throws后面是一个类？super是干什么的？





# Java快速入门



## 基本类型 && 数据类型

### 基本数据类型 && 引用类型

Java的**基本数据类型** primitive data types（数值型和字符型）只有 8 个 ：byte、short、int、long、float、double、char、boolean

| 数据类型         | 文字量                                        |
| ---------------- | --------------------------------------------- |
| byte, short, int | 十进制数：开头不为o；oX跟16进制数；o跟8进制数 |
| long             | 同上，但后面跟l或L，如：84l，oX1F39L          |
| float            | 数字后跟f或F                                  |
| double           | 后面可选d或D做后缀                            |
| boolean          | true或false                                   |

Java中的字符采用Unicode编码方式。所以，Java的 `char` 类型除了可表示标准的ASCII外，还可以表示一个Unicode字符：

```java
public static void main(String[] args) {/
    char ChineseCharactor = '牛';
    System.out.println("ChineseCharactor = " + ChineseCharactor);
		//可以征程输出汉字
    
}
```



### Java常量





****

除了8个基本类型（primitive type），剩下的都是**引用类型**（referencetype），Java 5 以后引入的枚举类型也算是一种比较特殊的引用类型。

字符串：String是一个类

>Java 是一个近乎纯洁的面向对象编程语言，但是为了编程的方便还是引入了基本数据类型，但是为了能够将这些基本数据类型当成对象操作，Java 为每一个基本数据类型都引入了对应的包装类型（wrapper class），int 的包装类就是 Integer，从 Java 5 开始引入了自动装箱/拆箱机制，使得二者可以相互转换。
>
>原始类型: boolean，char，byte，short，int，long，float，double
>
>包装类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double





## 算法流程控制

1.for：Java中增强的for循环（对数组或集合对象进行遍历），又叫for- Each循环

```java
for(var item:items){//var 代表各钟类型
    //相关操作
}
```

> 举例：
>
> ```java
> String [] str= new String[]{"1","2","3"};
> 
> //普通for循环
> for(int i=0;i<str.length;i++){
>     String item = str[i];
>     item += "str";
>     System.out.println(item);
> }
> 
> //加强型for循环
> for(String item:str){
>     item += "str";
>     System.out.println(item);
> }
> ```
>









## Java文件结构

### package && import

一个`class`在一个`package`里面，类名只是一个简写，真正完整的类名是`package.class`这种形式。在定义`class`的时候，我们需要在第一行声明这个`class`属于哪个包（但是在我IDEA里面src包下面的.java文件没有声明）；

在一个`class`中，我们总会引用其他的`class`，可以用`import`；在写`import`的时候，可以使用`*`，表示把这个包下面的所有`class`都导入进来（但不包括子包的`class`）：

```java
// 导入mr.jun包的所有class:
import mr.jun.*;
```

编写class的时候，编译器会自动帮我们做两个import动作：
1.默认自动`import`当前`package`的其他`class`；
2.默认自动`import java.lang.*`。



### 内部类  模块



### classpath && jar



# Java 面向对象基础



##  面向对象的思想

面向对象编程，是一种通过对象的方式，把现实世界映射到计算机模型的一种编程方法。

面向对象的特征：**抽象，封装，继承，多态**





##  类class，实例instance和变量

现实世界中，我们定义了“人”这种抽象概念，而具体的人则是“小明”、“小红”、“小军”等一个个具体的人。所以，“人”可以定义为一个类（class），而具体的人则是实例（instance），一个**实例**也叫做一个**对象**。这个例子我们发现，人作为“类”，是抽象的；而小明，小红，小军作为“实例”是具体的。

再比如，我们要写一个养狗系统，这个时候，我们可以把“狗”定义为一个类，把王阿姨家的狗“Jerry”、张大爷家的狗“Tom”等作为实例。同样的，“书”也是一种抽象的概念，所以它是类，而《Java核心技术》、《Java编程思想》、《Java学习笔记》则是实例。所以你发现，这样看类通常是抽象的，而实例是具体的。

理解了class和instance的概念，基本上就明白了什么是面向对象编程。class是一种对象模版，它定义了如何创建实例，因此，**class本身就是一种数据类型**；而instance是对象实例，instance是根据class创建的，可以创建多个instance，每个instance类型相同，但各自属性可能不相同。



```java
class QQAccount {
	public int id;
	public String name;
	public int level;
    public boolean VIP;//Java中的布尔类型
	//...
}//创建一个类
QQAccount qqAccount = new QQAccount();
//创建一个实例，这里的`new QQAccount();`是构造方法，我们后面会提到
qqAccount.id = 24******86; //对字段id赋值
qqAccount.name = "琴*****A" //对字段name赋值
```

**注意：上面提到的`new QQAccount();`创建了一个`QQAccount`类型的<font color =red>实例</font>，并通过<font color =red>变量</font>`qqAccount`指向它。**

**`QQAccount qqAccount`是定义一个`QQAccount`类型的<font color =red>变量</font>——`qqAccount`**

**`new QQAccount()`是生成了一个新的`QQAccount`<font color = red>实例</font>，通过`=`让变量`qqAccount`指向新生成的实例**






##  OOP封装

### getter && setter

把`field`从`public`改成`private`，外部代码不能访问这些`field`，这时候如果我们想用外部代码访问这些字段，就要用到getter，setter函数。

```java
public void setAge(int age) {
	this.age = age;
}
public String setName(){
	return name;
}//最普通的getter setter方法就是这样的，当然，你可以在方法中增加其他的限制条件
public void setAge(int age){
  if(age>0&&age<20
     this.age = age;//前面的this不可少，少了就变成将局部变量age赋值给局部变量age
  else{
     System.out.println("您输入的数据不合法！已默认清零");
     this.age = 0;
  }
}
```

**this变量**：在方法内部，可以使用一个隐含的变量`this`，它始终指向<font color = red>当前实例</font>。因此，通过`this.field`就可以访问当前实例的字段。如果没有命名冲突，可以省略`this`。但是，如果有局部变量和字段重名，那么局部变量优先级更高，就必须加上`this`。

**Getter && Setter方法自动生成**：IntelliJ IDEA Mac:  <kbd>cmd</kbd> + <kbd>N</kbd>，选择Getter and Setter



### 可变参数





###  jar导入

实际情况，Getter 和 Setter 方法太多，我们可以引入jar包，这样就不用写

[
@Getter and @Setter - Project Lombok](https://projectlombok.org/features/GetterSetter)





##  toString()的重写

这里主要介绍toString()方法重写的步骤和技巧，关于重写实现的原理，是需要继承的知识的，在后面介绍。







##  （方法）重载Overload

在一个类中，如果有多个方法，他们的功能类似，只有参数不同，那么我们可以把这一系列方法定义为**同名方法**。这种方法名相同，但各自的参数不同，称为**方法重载**（`Overload`）。

在getter，setter和初始化方法时，方法的名字相同，但是方法名后面的小括号中的参数不相同，这就是重载。

方法重载的目的是，功能类似的方法使用同一名字，更容易记住，因此，调用起来更简单。

注意：方法重载的返回值类型通常都是相同的。





##  构造方法 && 构造方法的重载 constructor

构造方法，就是初始化方法。每一个class中都有构造方法，如果一个类中没有定义构造方法，编译器会自动为我们生成一个默认的构造方法。

构造方法十分特殊，构造方法的名称就是类名，并且构造方法没有返回值，也没有void

> 以Animal类为例子：

```java
//默认构造方法
public Animal(){
}//默认状态下，数值被初始化为0，引用被初始化为空NULL
public Animal(String name,int age,String kind){
    this.name = name;
    this.age = age;
    this.kind = kind;
}//构造方法的重载， 小括号里面的叫参数表
```

这两个都是构造方法，两个构造方法名字相同，这是构造方法的重载（小括号里面的叫参数表）

构造方法一般是public的

第一个构造方法是默认的构造方法。默认状态下，数值被初始化为0，引用被初始化为空

第二个是我们自定义的构造方法。如果你已经自定义了（有参数的）构造方法，编译器就不会给你自动创建默认的构造方法了，如果你再想用`Animal zhangDog = new Animal(); ` 这时就必须你自己写默认的构造方法了。

>另外，构造方法之间的互相调用：可以通过**this**在一个构造方法中调用另外一个构造方法（通常来说，在参数较少的构造方法中调用参数多的构造方法）
>
>```java
>public Animal(){
>}
>public Animal(String name,int age,String kind){
>this.name = name;
>this.age = age;
>this.kind = kind;
>}
>public Animal(String name,int age){
>this(name, age, null);//调用其他构造方法的语法：this(...);
>}
>public Animal(String name,String kind) {
>this(name, 0, kind);
>}
>```
>
>第三个和第四个构造方法就用到了构造方法的互相调用





## 静态 static

<font size = 5>静态字段（静态变量）</font>

在一个`class`中定义的字段，我们称之为**实例字段**。实例字段的特点是，每个实例都有独立的字段，各个实例的同名字段互不影响。

> 这种情况适用于给一个类中不同的实例附上相应不同的值。但是有一种情况，就是这一个类中的所有变量中的某个属性是相同的，比如说你给你们小区的狗写了一个类，他们都是NanG小区的。这种情况就引出了static变量（字段）。

还有一种字段，是用`static`修饰的字段，称为**静态字段**：`static field`。

实例字段在每个实例中都有自己的一个独立“空间”，但是静态字段只有一个共享“空间”，所有实例都会共享该字段。

> 不推荐用`实例变量.静态字段`去访问静态字段，因为在Java程序中，实例对象并没有静态字段。在代码中，实例对象能访问静态字段只是因为编译器可以根据实例类型自动转换为`类名.静态字段`来访问静态对象（同理，通过实例变量也可以调用静态方法，但这只是编译器自动帮我们把实例改写成类名而已）；
>
> 推荐用类名来访问静态字段。可以把静态字段理解为描述`class`本身的字段（非实例字段）
> 通常情况下，通过实例变量访问静态字段和静态方法，会得到一个编译警告。

（接口中也存在static字段，详见接口）



<font size = 5>静态方法</font>

调用实例方法必须通过一个实例变量，而**调用静态方法则不需要实例变量，通过类名就可以调用**。静态方法类似其它编程语言的函数。

**静态方法经常用于工具类和辅助方法：**
例如：工具类：Arrays.sort()  Math.random() 辅助方法：Java程序的入口`main()`也是静态方法



静态类

 静态内部类和非静态内部类之间区别：

1. 内部静态类不需要有指向外部类的引用。但非静态内部类需要。
2. 静态类只能访问外部类的静态成员，非静态内部类能够访问外部类的静态和非静态成员。
3. 非静态内部类不能脱离外部类实体被创建，非静态内部类可以访问外部类的数据和方法，因为他就在外部类里面。



##  public, private, protected, default 访问权限

公有 public：可以被其他任何方法访问(前提是对类成员所属的类有访问权限)

保护 protected： 只可被同一类及其子类的方法访问

私有 private：只可被同一类的方法访问

默认 default：仅允许同一个包内的访问；又被称为“包(package)访问权限”



继承有个特点，就是子类无法访问父类的`private`字段或者`private`方法。

|  修饰符   | 当前类 | 同包 | 子类 | 其他包 |
| :-------: | :----: | :--: | :--: | :----: |
|  public   |   ✅    |  ✅   |  ✅   |   ✅    |
| protected |   ✅    |  ✅   |  ✅   |   ❌    |
|  default  |   ✅    |  ✅   |  ❌   |   ❌    |
|  private  |   ✅    |  ❌   |  ❌   |   ❌    |

`private`访问权限被限定在`class`的内部，而且与方法声明顺序*无关*。推荐把`private`方法放到后面，因为`public`方法定义了类对外提供的功能，阅读代码的时候，应该先关注`public`方法。

一个`.java`文件只能包含一个`public`类，但可以包含多个非`public`类。如果有`public`类，文件名必须和`public`类的名字相同。



##  终结final

变量（字段）一旦定义final就不能改了（有点C++ const常量的味道）

> ```java
> /*1.*/
> final int a = 1;
> System.out.println("a = " + a);//可以初始化的时候就赋值
> /*2.*/
> final int a;
> a = 1;
> System.out.println("a = " + a);//可以先初始化，再赋值
> //但是赋值之后就不能再修改了！！！
> ```

>```java
>public class Test6 {
>public static void main(String[] args) {
>Wechat [] wechats = new Wechat[] {
> new Wechat(),
> new Wechat("Kawasaki"),
> new Wechat("Kawasaki","Timax")
>};
>for(Wechat wechat: wechats) {
>System.out.println("wechat.name = " + wechat.name);
>System.out.println("wechat.wechatID = " + wechat.wechatID);
>}
>}
>}
>
>class Wechat {
>protected String name;
>protected final String wechatID;
>public Wechat() {
>this.wechatID = null;//final的字段必须有初始化！
>}
>public Wechat(String wechatID) {
>this.wechatID = wechatID;//没有提到的Wechat.name, 编译器会自动将name赋值为null
>}
>public Wechat(String wechatID, String name) {
>this.wechatID = wechatID;
>this.name = name;
>}
>}
>```
>
>输出：
>
>```shell
>wechat.name = null
>wechat.wechatID = null
>wechat.name = null
>wechat.wechatID = Kawasaki
>wechat.name = Timax
>wechat.wechatID = Kawasaki
>```

终结方法

final修饰的方法不能被**子类**重写（覆盖）；

你可以用，但是不能为所欲为





终结类

final修饰的类不能被**子类**继承；final断子绝孙了





# 面向对象进阶

## 继承

###  继承 extends

> 继承是面向对象编程的一种强大的代码复用方式；Java只允许单继承，所有类最终的根类是`Object`；`protected`允许子类访问父类的字段和方法；子类的构造方法可以通过`super()`调用父类的构造方法；可以安全地向上转型为更抽象的类型；可以强制向下转型，最好借助`instanceof`判断；子类和父类的关系是is，has关系不能用继承。

继承是面向对象编程中非常强大的一种机制，它首先可以复用代码。当我们让`Dog`从`Animal`继承时，`Dog`就获得了`Animal`的（所有）功能，我们只需要为`Dog`编写新增的功能。（子类**不会继承**任何父类的构造方法）

在OOP的术语中，我们把`Animal`称为**超类（super class），父类（parent class），基类（base class）**，把`Dog`称为**子类（subclass），扩展类（extended class）**。

我们在写`Animal`类时没有写`extends`，在Java中没有明确写`extends`的类编译器会自动加上`extends Object`，所以除了Object类，任何类都会继承自某个类。

继承有个特点，就是子类无法访问父类的`private`变量或者`private`方法（父类中只有`protected`或者`public`的变量或方法可以被子类访问）。这时，我们可以把private改为`protected`，`protected`可以把访问权限控制在继承树内部，父类中`protected`的变量和方法可以被子类，子类中的子类访问。

在 `构造方法 && 构造方法的重载`中我们说过`this(...);  `可以调用类中其他的构造方法，同时`super(...);`可以调用父类中的构造方法。`super`关键字表示父类（超类）。子类引用父类的字段时，可以用`super.fieldName`。在某些时候，必须使用`super`。

>举例：必须使用super的情况
>
>```java
>public class Main {
>public static void main(String[] args) {
>Student s = new Student("Xiao Ming", 12, 89);
>}
>}
>class Person {
>protected String name;
>protected int age;
>public Person(String name, int age) {
>this.name = name;
>this.age = age;
>}
>}
>class Student extends Person {
>protected int score;
>public Student(String name, int age, int score) {
>this.score = score;
>}
>}
>```
>
>运行上面的代码，会得到一个编译错误，大意是在`Student`的构造方法中，无法调用`Person`的构造方法。
>
>这是因为在Java中，任何`class`的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句`super();`，所以，`Student`类的构造方法实际上是这样：
>
>```java
>class Student extends Person {
>protected int score;
>public Student(String name, int age, int score) {
>super(); // 自动调用父类的构造方法
>this.score = score;
>}
>}
>```
>
>但是，`Person`类并没有无参数的构造方法，因此，编译失败。
>
>解决方法是调用`Person`类存在的某个构造方法。例如：
>
>```java
>class Student extends Person {
>protected int score;
>public Student(String name, int age, int score) {
>super(name, age); // 调用父类的构造方法Person(String, int)
>this.score = score;
>}
>}
>```
>
>这样就可以正常编译了！
>
>结论：
>
>（1）如果父类没有默认的构造方法，子类就必须显式调用`super()`并给出参数以便让编译器定位到父类的一个合适的构造方法。
>
><font color = red>（2）子类**不会继承**任何父类的构造方法</font>。子类默认的构造方法是编译器自动生成的（自动生成默认的构造方法），不是继承的。



### 继承 && 组合

Student类和Book类都有`name`字段，那Student类可以继承Book类吗？显而易见：这不合理。Student类应该继承Person类，因为Student是Person的一种，也就是说**继承应该是 is 关系**；而Student可以拥有Book，也就是说**组合应该是 has 关系**。

```java
class Student extends Person {
    protected Book book;//组合
    protected int score;
}
```



****

构造方法：

继承时，如果子类和父类有相同名称的变量成员（他们的类型相同或者不同），当调用函数时，super.变量名可以访问父类中的变量的值，this.变量名可以访问当前子类的变量的值；

同时，当使用方法时，如果使用父类中的方法并且函数中需要用到这个名字的变量，显而易见，这个变量用父类方法中的，如果在子类中，则用子类中的变量的值。

Java类继承的层次结构为树状结构（**继承树**）

A类继承自B类，那么A类中不可以使用B类的私有属性（详见表格）



###  向上转型 && 向下转型

#### 向上转型

假设`Student`是从`Person`继承下来的，那么，一个引用类型为`Person`的变量，能否指向`Student`类型的实例？

```java
Person p = new Student(); 
```

测试一下就可以发现，这种指向是允许的！这是因为`Student`继承自`Person`，因此，它拥有`Person`的全部功能。`Person`类型的变量，如果指向`Student`类型的实例，对它进行操作，是没有问题的！

这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。

**向上转型就是花木兰替父从军，子类披着老子的皮！父类的变量指向子类的实例。**

****

向上转型实际上是把一个子类型安全地变为更加抽象的父类型：

```java
Student s = new Student();
Person p = s; // upcasting, ok
Object o1 = p; // upcasting, ok
Object o2 = s; // upcasting, ok
//注意到继承树是`Student > Person > Object`，所以，可以把`Student`类型转型为`Person`，或者更高层次的`Object`。
```



#### 向下转型

和向上转型相反，如果把一个父类类型强制转型为子类类型，就是向下转型（downcasting）。

```java
Person p1 = new Student(); // upcasting, ok
Person p2 = new Person();
Student s1 = (Student) p1; // ok
Student s2 = (Student) p2; // runtime error! ClassCastException!
```

`Person`类型`p1`实际指向`Student`实例，`Person`类型变量`p2`实际指向`Person`实例。在向下转型的时候，把`p1`转型为`Student`会成功，因为`p1`确实指向`Student`实例，把`p2`转型为`Student`会失败，因为`p2`的实际类型是`Person`，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。因此，向下转型很可能会失败。失败的时候，Java虚拟机会报`ClassCastException`。

**如果父类类型变量指向子类的实例，那么这个父类类型的变量可以强制转换成为子类类型的变量（向下转型）。**

**向下转型就是花木兰打完仗以后遇到自己喜欢的人，又变回自己了！**



#### instanceof

为了避免转型出错，Java提供了`instanceof`操作符。**`instanceof`实际上判断一个变量所指向的实例是否是指定类型，或者这个类型的子类。**如果一个引用变量为`null`，那么对任何`instanceof`的判断都为`false`。

```java
Person p = new Person();
System.out.println(p instanceof Person); // true
System.out.println(p instanceof Student); // false

Student s = new Student();
System.out.println(s instanceof Person); // true
System.out.println(s instanceof Student); // true
//花木兰替父从军，s可以指向Student（做自己），也可以指向Person（替父从军）
Student n = null;
System.out.println(n instanceof Student); // false
//如果一个引用变量为null，那么对任何instanceof的判断都为false。
```

[点击这里了解更多（Java - 继承）]([继承 - 廖雪峰的官方网站 (liaoxuefeng.com)](https://www.liaoxuefeng.com/wiki/1252599548343744/1260454548196032))





## 多态



###  方法的重写（覆盖）Override Methods

如果在继承的时候，子类中有和父类中的方法名一模一样的方法，这叫方法的重写，也叫方法的覆盖（在子类中重写了一个父类存在的方法）；

方法重写要求方法的返回类型，方法的名称，参数的个数和参数的类型必须一模一样

方法重写的访问权限条件：**子类中的重写的方法的访问权限只能比父类的更宽松（或者访问权限相同）**。比如父类中某方法是public，那么重写时子类可以是public，不能是private；如果父类中某方法是private，那么重写时子类中可以是private或者public 

```java
@Override
```

加上`@Override`可以让编译器帮助检查是否进行了正确的覆写。希望进行覆写，但是不小心写错了方法签名，编译器会报错。但是`@Override`不是必需的。

>区分：重写（覆盖）Override && 重载Overload
>重载：我不说定义，在（getter，setter和）初始化方法时，方法的名字相同，但是方法名后面的小括号中的参数不相同，这就叫重载
>
>**<font color = red>Override和Overload不同的是，如果方法签名如果不同，就是Overload，Overload方法是一个新方法；如果方法签名相同，并且返回值也相同，就是`Override`。</font>**

==在继承时，定义了一个指向子类的子类变量；如果方法名是父类的，那么调用的就是父类的方法。如果方法在子类中被重写了，那调用的就是子类的方法。如果==





###  多态 polymorphism==什么是多态==

> ==最开始学C++面向对象的时候，觉得动态编译，父类指向子类，调用子类方法就算多态。后来有一次实验，老师说——多态是当新添加一个对象时，只需要定义对象对应的函数功能，不需要修改其他部分的代码，整个程序依旧能正常运行起来。我对于多态的理解到现在可以说是十分混乱......==

在向上转型和向下转型中，我们知道：引用变量的声明类型可能与其实际类型不符。

> 引例：程序会打印出什么呢？
>
> ```java
> public class Main {
> public static void main(String[] args) {
>   Person p = new Student();
>   p.run(); // 应该打印Person.run还是Student.run?
> }
> }
> class Person {
> public void run() {
>   System.out.println("Person.run");
> }
> }
> class Student extends Person {
> @Override
> public void run() {
>   System.out.println("Student.run");
> }
> }
> ```
>
> 一个实际类型为`Student`，引用类型为`Person`的变量，调用其`run()`方法，调用的是`Person`还是`Student`的`run()`方法？
>
> 运行一下上面的代码就可以知道，实际上调用的方法是`Student`的`run()`方法。因此可得出结论：
>
> **Java调用的是实例类型的方法**

**<font size = 4>Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。这个非常重要的特性在面向对象编程中称之为多态。它的英文拼写非常复杂：Polymorphic。</font>**

**多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期<font color = red>实际类型的方法</font>。**

> 多态举例：
>
> ```java
> public class Application4ForJavaLanguage {
> public static void main(String [] args) {
>   Income [] incomes = new Income[] {
>           new Income (3000),
>           new Salary (7500),
>           new StateCouncilSpecialAllowance (15000)
>   };
>   System.out.println(totalTax(incomes));//800.0
> }//main
> 
> public static double totalTax(Income... incomes) {
>   double total = 0;
>   for(Income income: incomes) {
>       total = total + income.getTax();
>   }
>   return total;
> }
> }
> 
> class Income {
> protected double income;
> 
> public Income(double  income) {
>   this.income = income;
> }
> 
> public double getTax() {
>   return income * 0.1;//tax 10%
> }
> }
> 
> class Salary extends Income {
> public Salary(double income) {
>   super(income);
> }
> @Override
> public double getTax() {
>   if(income <= 5000) {
>       return 0;
>   }
>   return (income - 5000) * 0.2;
> }
> }
> 
> class StateCouncilSpecialAllowance extends Income {
> public StateCouncilSpecialAllowance(double income) {
>   super(income);
> }
> @Override
> public double getTax() {
>   return 0;
> }
> }
> ```
>
> 观察`totalTax()`方法：利用多态，`totalTax()`方法只需要和`Income`打交道，它完全不需要知道`Salary`和`StateCouncilSpecialAllowance`的存在，就可以正确计算出总的税。如果我们要新增一种稿费收入，只需要从`Income`派生，然后正确覆写`getTax()`方法就可以。把新的类型传入`totalTax()`，不需要修改任何代码.

可见，多态具有一个非常强大的功能，就是允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码。



### super

继承时，如果子类和父类有相同名称的变量成员（他们的类型相同或者不同），当调用函数时，`super.变量名`可以访问父类中的变量的**值**，`this.变量名`可以访问当前子类的变量的值；

在子类的覆写方法中，如果要调用父类的被覆写的**方法**，可以通过`super.methodName()`来调用









## 抽象类与接口

###  抽象abstract

> 通过`abstract`定义的方法是抽象方法，它只有定义，没有实现。抽象方法定义了子类必须实现的接口规范；定义了抽象方法的class必须被定义为抽象类，从抽象类继承的子类必须实现抽象方法；如果不实现抽象方法，则该子类仍是一个抽象类；面向抽象编程使得调用者只关心抽象方法的定义，不关心子类的具体实现。

**抽象的用法：**
抽象类本身不能产生实例，抽象方法没有方法体（大括号）
抽象方法只能在抽象类中存在；如果有抽象方法，那这个类必须是抽象类
所有继承抽象类的子类必须重写抽象类中的所有抽象方法

```java
public abstract <returnType> <methodName>();//抽象方法声明形式
public abstract void barking();//抽象方法声明举例
```



**抽象的作用：**

把一个类（或方法）进行抽象，是因为它不是具体的。比如说不能养Animal，不能确定barking方法。

**抽象类本身被设计成只能用于被继承**（抽象类只能做父类使用），抽象方法是不能有实际意义的；
抽象类可以**强迫子类实现其定义的抽象方法**，否则编译会报错。抽象方法只能在抽象类里面存在；
因此，抽象方法实际上相当于**定义了“规范”**。

> 只有子类实现了抽象超类中所有的抽象方法，子类才不是抽象类，才能产生实例；如果子类中有抽象方法没有实现，那么这个子类依然是抽象类，不能有实例。



**面向抽象编程：**

> ```java
> public abstract class Person {//抽象类
> protected String name; //子类能看到
> public abstract void SelfIntroduction();//抽象方法的声明，没有方法体
> }
> public class Student extends Person {
> public void SelfIntroduction() {//子类中重写抽象方法
>   System.out.println("I'm " + name);
> }
> }
> public class Teacher extends Person {
> public void SelfIntroduction() {//注意：这里没有abstract这个标识符！
>   System.out.println("Fuck! I'm " + name);
> }
> }
> public class Application {
> public static void main(String[] args) {
>   Person s = new Student();//通过抽象类的变量引用具体子类的实例
>   Person t = new Teacher();
>   s.name = "XiaoHong";
>   t.name = "Frank";
>   s.SelfIntroduction();
>   t.SelfIntroduction();
> }
> }
> ```

当我们定义了抽象类`Person`，以及具体的`Student`、`Teacher`子类的时候，我们可以通过抽象类`Person`类型去引用具体的子类的实例；

这种引用抽象类的好处在于，我们对其进行方法调用，并不关心`Person`类型变量的具体子类型。同样的代码，如果引用的是一个新的子类，我们仍然不关心具体类型；

```java
// 同样不关心新的子类是如何实现run()方法的：
Person e = new Employee();
e.run();
```

这种尽量引用高层类型，避免引用实际子类型的方式，称之为**面向抽象编程**。

<font size = 5>**面向抽象编程的本质就是：**</font>

- 上层代码只定义规范（例如：`abstract class Animal`）；
- 不需要子类就可以实现业务逻辑（正常编译）；
- 具体的业务逻辑由不同的子类实现，调用者并不关心。





###  接口interface

在抽象类中，抽象方法本质上是定义接口规范：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。

如果**一个抽象类没有字段，所有方法全部都是抽象方法**，就可以把该抽象类改写为接口：`interface`。

在Java中，使用`interface`可以声明一个接口；
所谓`interface`，就是比抽象类还要抽象的纯抽象接口，因为<font color = red>**接口不能有字段**</font>；
因为**<font color = red>接口定义的所有方法默认都是`public abstract`的</font>**，所以这两个修饰符不需要写出来；
在Java中，一个类只能继承自另一个类，不能从多个类继承。但是，**一个类可以实现多个`interface`**。

```java
public class Dog implements Good,Animal {
		//这里要实现Good和Animal中的所有方法
  	//...
}
```

[接口定义非抽象方法]([(1条消息) JAVA 8新特性 允许接口定义非抽象方法 快速入门案例_austral的博客-CSDN博客](https://blog.csdn.net/austral/article/details/53402476))
JavaSE 8新特性：
1.接口可以定义非抽象方法  但必须使用default或者staic关键字来修饰
2.JDK1.8规定只能在接口定义defult方法  且必须加Body实现
3.接口的默认实现方法支持重载
4....



### 抽象类与接口对比

|              |                        abstract class                        |                          interface                           |
| :----------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|     继承     |                     只能extends一个class                     |                 可以implements多个interface                  |
|     字段     |                       可以定义实例字段                       |                       不能定义实例字段                       |
|   抽象方法   |                       可以定义抽象方法                       |                      通常只定义抽象方法                      |
|  非抽象方法  |                      可以定义非抽象方法                      |             必须使用default或者staic关键字来修饰             |
|              |                                                              |                                                              |
| 本质上的区别 | <font color = red>抽象类对具体事物进行抽象</font>，命名是一个名词事物 | <font color = red>对动作行为进行抽象</font>，与其起名Person，不如说是Animal Action |
|              |                   针对具体事物（针对根源）                   |                           针对行为                           |

> abstract class && interface 类的一种声明方法：可以在创建的时候就加上对抽象方法的重写，例子如下：
>
> ```java
> Good good = new Good() {
>       @Override
>       public void price() {
>           System.out.println("fuck");
>       }
>       @Override
>       public void introduction() {
>           System.out.println("fuck you");
>       }
>   };
>   Person person = new Person() {
>       @Override
>       public void SelfIntroduction() {
>           System.out.println("fuck");
>       }
>   };
> ```
>
> 



**接口的继承**

一个`interface`可以继承自另一个`interface`。`interface`继承自`interface`使用`extends`，它相当于扩展了接口的方法。例如：

```java
interface Hello {
    void hello();
}
interface Person extends Hello {
    void run();
    String getName();
}
```

此时，`Person`接口继承自`Hello`接口，因此，`Person`接口现在实际上有3个抽象方法签名，其中一个来自继承的`Hello`接口。



> 扩展：
>
> **继承关系：**
>
> 合理设计`interface`和`abstract class`的继承关系，可以充分复用代码。一般来说，公共逻辑适合放在`abstract class`中，具体逻辑放到各个子类，而接口层次代表抽象程度。可以参考Java的集合类定义的一组接口、抽象类以及具体子类的继承关系。[进一步了解戳这里](https://www.liaoxuefeng.com/wiki/1252599548343744/1260456790454816)
>
> 在使用的时候，实例化的对象永远只能是某个具体的子类，但总是通过接口去引用它，因为接口比抽象类更抽象：
>
> ```
> List list = new ArrayList(); // 用List接口引用具体子类的实例
> Collection coll = list; // 向上转型为Collection接口
> Iterable it = coll; // 向上转型为Iterable接口
> ```



### interface中的default方法

> ```java
> public class Main {
> public static void main(String[] args) {
>   Person p = new Student("Xiao Ming");
>   p.run();//Xiao Ming run
> }
> }
> 
> interface Person {
> String getName();
> default void run() {
>   System.out.println(getName() + " run");
> }
> }
> 
> class Student implements Person {
> private String name;
> 
> public Student(String name) {
>   this.name = name;
> }
> 
> public String getName() {
>   return this.name;
> }
> }
> ```

实现类可以不必覆写`default`方法。`default`方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。如果新增的是`default`方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。

`default`方法和抽象类的普通方法是有所不同的。因为`interface`没有字段，`default`方法无法访问字段，而抽象类的普通方法可以访问实例字段。



### interface中的static字段

接口中的字段只能是`public static final`类型，因此可以简写，编译器会自动把该字段变为`public static final`类型。



# Java常用核心类



## String 类

String类是final的，

String中的常用方法

```java
/**
*
*
*/

```





#  泛型

泛型的本质：类型参数化（泛型的类，泛型的方法，泛型的接口）





# Java异常处理 Exception





# 输入输出流 & 文件





# 图形化界面GUI





# Java 数据结构







# 多线程









# 附录

## 单词表

|     English      |  Chinese   |  English  | Chinese  |  English   |   Chinese   |
| :--------------: | :--------: | :-------: | :------: | :--------: | :---------: |
|   constructor    |  构造方法  | upcasting | 向上转型 | repositery | 资料库 仓库 |
|     sign in      |    登陆    | optional  |  可选的  |  license   |    执照     |
|     sign up      |    注册    |   index   |   下标   |  template  |    模版     |
| RuntimeException | 运行时异常 |           |          |            |             |
|                  |            |           |          |            |             |
|                  |            |           |          |            |             |
|                  |            |           |          |            |             |
|                  |            |           |          |            |             |
|                  |            |           |          |            |             |

## IntelliJ IDEA 快捷键

[相关文章]([IntelliJ-IDEA-Tutorial/keymap-mac-introduce.md at master · judasn/IntelliJ-IDEA-Tutorial (github.com)](https://github.com/judasn/IntelliJ-IDEA-Tutorial/blob/master/keymap-mac-introduce.md))

<kbd>cmd</kbd> + <kbd>Backspace</kbd> : 删除光标所在的一整行

<kbd>SHIFT</kbd> + <kbd>Enter</kbd> : 新建下一行

<kbd>ALT</kbd> + <kbd>Enter</kbd> : 自动补全import