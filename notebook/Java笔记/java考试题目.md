---
title: java考试复习题目
detail: - 
---



1. abstract可以修饰类和方法，但是不能修饰**字段**
2. 声明抽象方法，**不可以写出大括号**（不要以为大括号是可有可无的，大括号不能写）
3. static修饰成员变量或成员函数（类字段，类方法）。普通类不允许声明为静态的，**static可以修饰内部类**。
4. 在类的方法中不能声明**static变量**，即使是static的函数也不可以
5. 实例方法：我们在类中定义的普通方法。 只有实例化对象之后才可以使用的方法
6. 子类构造时，会**先调用父类的构造方法，再调用子类的构造方法**（==具体的构造方法顺序==）
7. 在写异常处理的时候，一定要把异常范围小的放在前面，范围大的放在后面。
8. 异常匹配的顺序：**按照catch块从上往下匹配**，当它匹配某一个catch块的时候，他就直接进入到这个catch块里面去了，后面在再有catch块的话，它不做任何处理，直接跳过去，全部忽略掉。如果有finally的话进入到finally里面继续执行。
9. Java中**Set不可以存储相同元素，Map的key不可以重复**。
10. **覆盖/重写**是在子类中重新定义父类的方法，**重载**是相同的函数名和放回类型，不同的参数列表
11. 





```java
class Egg2 {
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }
        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }
    private Yolk y = new Yolk();
    public Egg2() {
        System.out.println("New Egg2()");
    }
    public void insertYolk(Yolk yy) {
        y = yy;
    }
    public void g() {
        y.f();
    }
}

class BigEgg2 extends Egg2 {
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }

        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }
    public BigEgg2() {
        insertYolk(new Yolk());
    }
    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}

```





```java
class ThrowingExceptions1 {
    public static void main(String args[]) {
        try {
            System.out.println("main方法");
            throw1();
        } catch (Exception e) {
            System.out.println("在main方法的捕获中抛出");
        } finally {
            System.out.println("main方法的finally");
        }
    }

    public static void throw1() throws Exception {
        try {
            System.out.println("方法一");
            throw2();
        } catch (Exception re) {
            System.out.println("在方法一的捕获中抛出");
        } finally {
            System.out.println("方法一finally");
        }

    }

    public static void throw2() throws Exception {
        try {
            System.out.println("方法二");
            throw new Exception("在方法二中抛出");
        } catch (Exception re) {
            System.out.println("在方法二的捕获中抛出");
        } finally {
            System.out.println("方法二finally");
        }
    }
}
```





```java
interface InterfaceA{
    int MAX = 10;
}

class ClassA implements InterfaceA{
    int a = 1;
}

class ClassB extends ClassA{
    int b = 2;
}

class E {
    public static void main(String[] args){
        ClassB b = new ClassB();
        System.out.print(b.MAX);
        System.out.print(" " + ClassB.MAX);
        System.out.print(" " + ClassA.MAX);
        System.out.print(" " + InterfaceA.MAX);
    }
}
```







```java
class Data {
    int val;
    Integer ref;
}

class p3 {
    public static void main(String[] args) {
        Data d1 = new Data();
        d1.val = 1;
        d1.ref = 1;
        Data d2 = d1;
        d2.val = 2;
        Integer i = d1.ref;
        i = 2;
        System.out.println(d1.val + "\t" + d1.ref);
    }
}
```







```java
class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ") ");
    }
}
class House {
    Window w1 = new Window(1);
    House() {
        w2 = new Window(2);
    }
    Window w2 = new Window(3);
}
class OrderInitialization {
    public static void main(String[] args) {
        House h = new House();
    }
}
```



```java
class Conditional {
    public static void main(String args[]) {
        int x = 4;
        System.out.println("value is " + ((x > 4) ? 99.9 : 9));
    }
}
```



```java
class test {
    public static void throwit() {
        System.out.print("throwit ");
        throw new RuntimeException();
    }
    public static void main(String[] aa) {
        try {
            System.out.print("hello ");
            throwit();
        } catch (Exception re) {
            System.out.print("caught");
        } finally {
            System.out.print("finally ");
        }
        System.out.print("after ");
    }
}
```





```java
class Test {
    static int age;
    public static void main(String[] args) {
        age = age + 1;
        System.out.println("The age is:"+age);
    }
}
```





```java
class p10 {
    static int tryTest(int a, int b){
        try{
            return a / b;
        }catch(Exception e){
            return 0;
        }finally{
            return 1;
        }
    }
    public static void main(String[] args) {
        System.out.println( tryTest(2, 1) );
        System.out.println( tryTest(2, 0) );
    }
}
```





```java
import java.awt.event.*;
class MyListener implements ActionListener, ItemListener {
  public void actionPerformed(ActionEvent ae) {
    System.out.println("Action");
  }

  public void itemStateChanged(ItemEvent ie) {
    System.out.println("Item");
  }
}

```





```java
class Animal {
    public void func1() {
        func2();
    }
    public void func2() {
        System.out.println("AAAA");
    }
}

class Cat extends Animal {
    public void func1(int i) {
        System.out.println("BBBB");
    }
    public void func2() {
        System.out.println("CCCC");
    }
}

class test {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.func1();
    }
}
```



```java
class ShortCalc {
    public int add(short a1, short a2) {
        System.out.print("ShortCalc");
        return a1 + a2;
    }
}
class IntCalc extends ShortCalc {
    public int add(int a1, int a2) {
        System.out.print("IntCalc");
        return a1 + a2;
    }
}
class p7{
    public static void main(String[] args) {
        ShortCalc c1 = new ShortCalc();
        IntCalc c2 = new IntCalc ();
        short s1 = 0, s2 = 0;
        int i1 = 0;
        c2.add(s1,s2);
        c2.add(s1,i1);
    }
}
```





```java
class Data4{
    static int sval = 0;
    int val = 0;
}
class p4 {
    public static void main(String[] args) {
        Data4 d1 = new Data4();
        d1.val = 1;
        d1.sval = 1;
        Data4 d2 = new Data4();
        d2.val = 2;
        d1.sval = 2;

        System.out.println(d1.sval + "\t" + d1.val);
    }
}
```





```java
//哪个不正确
//abstract class Test { public void print() { } }
//abstract class Test { public abstract void print(); }
//abstract class Test { public final void print() {} }
//class Test { public abstract void print(); }
```





```java
class test {
    public static void main(String[] args) {
        int x = 6, y = 10, k = 5;
        switch (x % y)
        {
            case 0:
                k = x * y;
            case 6:
                k = x / y;
            case 12:
                k = x - y;
            default:
                k = x * y - x;
        }
        System.out.println(k);
    }
}
```







```java
class BirthDate {
    private int day, month, year;
    BirthDate(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }
    public void setDay(int d) {
        day = d;
    }
    public void display() {
        System.out.println(day + "/" + month + "/" + year);
    }

}

class TestBirthDate {
    public void change1(int i) {
        i = 1234;
    }

    public void change2(BirthDate b) {
        b = new BirthDate(22, 2, 2000);
    }

    public void change3(BirthDate b) {
        b.setDay(22);
    }

    public static void main(String args[]) {
        TestBirthDate test = new TestBirthDate();
        int date = 9;
        BirthDate d1 = new BirthDate(7, 7, 1995);
        BirthDate d2 = new BirthDate(1, 1, 1998);
        test.change1(date);
        test.change2(d1);
        test.change3(d2);
        System.out.println(date);
        d1.display();
        d2.display();
    }
}
```





```java
int a =3,b = 5,c = 8;
System.out.println(++c+b+++b+c+a++);
```

