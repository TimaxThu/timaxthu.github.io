---
title: IOS开发1小时学习笔记
---



# Swift入门

## Swift Playgrounds

Swift是Apple设计并退出的语言，用于编写iOS和其他相关的应用。

为了推广自己的语言，**Apple设计了一个神奇的app——Swift Playgrounds**。可以供初学者来学习Swift语言。同时，里面还有很多有趣的小游戏。

真的还蛮有意思的呢！

可以先使用Swift Playgrounds学习基础的Swift语言，我就是这么干的，我也学到了很多基础知识，比如：

1. "="两边的空格必须一致



## 基础

```swift
//常量
let constant: String = "1"
constant = "2" // 试图改变常量会报错
//变量
var variable = "3"
variable = "4"

//声明变量类型
let typeString: String = "5"
var noTypeString = "6" // 自动推断类型

let float: Float = 1.0
let double: Double = Double(float) // 类型转换

// 字符串插值
let lastName = "Kuixi"
let firstName = "Song"
let newString = "My name is \(lastName+firstName)"

// 数组
var fruits: Array<String> = ["Apple", "Orange", "Banana"]
var fruits: [String] = ["Apple", "Orange", "Banana"]
var fruits = ["Apple", "Orange", "Banana"]
fruits[0]
fruits.count
fruits.isEmpty
fruits.append("Strawberry")
fruits.remove(at: 0)
for fruit in fruits {
    print("I have \(fruit)")
}


//字典
var fruitNumber: [String: Int] = ["Apple":1,"Orange":2,"Banana":3,"Watermelon":4]
fruitNumber["Apple"] = 5

// guard
let number = 0
func squareRoot(of number: Int) {
    guard number >= 0 else { //类似判断边界条件
        print("Negative Number")
        return
    }
    //do more...
}

//if
if number == 0 {//括号是可以不加的
    print("zero")
} else if num == 1 {
    printf("One")
} else {
    print("Bigger than one")
}

//switch
switch number {
    case 0:
    print("zero")
    case 1,2: //多个值
    print("one or two")
    case 3...6: //区间 闭区间
    print("three to six")
    default:
    print("bigger than six")
}

//for
var forLoop = 0
for i in 0..<3 {//..<是左闭右开的意思
    forLoop += i
}

//while
while forLoop>1 {
    forLoop -= 1
}

//do-while
repeat {
    forLoop *= 2
} while (forLoop <= 2^10)

//函数
//func 函数名（参数列表）-> 返回值 {
//	  函数体
//}
func myFunction(parameterA:Int, parameterB:Int) -> Int {
    return parameterA + parameterB
}
myFunction(parameterA: 3, parameterB: 5)

//参数可省略名字，且可以有多个返回值
func anotherFunction(_ omittedParameterName: Int) -> (Int, Int, Int) {
	return (omittedParameterName * 2, omittedParameterName + 2, omittedParameterName - 2)
}
anotherFunction(100)

// 形参和实参名字可不同
func squared (of value: Double) -> Double {
return value * value
}
squared(of: 20.0)

// 把函数命名成变量
func incrementer() -> ((Int) -> Int) {
    func addOne(to number: Int) -> Int {
        return number+1
    }
    return addOne
}
var increment = incrementer()
increment(19)

/*闭包*/
//闭包就是匿名函数
[1,5,3,2,4].sorted(by:{(a,b) -> Bool in 
                       return a<b 
                      })
[1,5,3,2,4].sorted {
    $0 < $1
}
[1,5,3,2,4].filter {
    $0 % 2 == 0
}
[1,5,3,2,4].map{
    $0 * 2
}
//算n的阶乘
func factorial(of n:Int64) ->Int64 {
    return (1...n).reduce(1,*)
}
factorial(of:20)

let printMyName: ((_ name: String) -> Void = {name in
    print("I am \(name)")
})
printMyName("KaryC")

/*可选值*/
// 可选值
var optionalValue: Int? // 默认为nil
optionalValue = 3
optionalValue = nil
optionalValue! //强制解包，尽量避免，容易导致 Crash
// 可选值绑定
if let realValue = optionalValue {
    print("My value is \(realValue)")
}
// 默认值
print(optionalValue ?? 0) //如果有值就打印optionalValue，否则就打印0

```



```swift
//类
class Shape {
    var numOfSides = 0 //属性
    var totalInnerAngelSumg: Int { //计算属性，只能get，不能set
        get {
            return (numberOfSides - 2) * 180
        }
    }
    
    //初始化
    init(sides: Int) {
        self.numberOfSides = sides
    }
    // 成员方法
    func simpleDescription() -> String {
        return "A shape with \(numberOfSides) sides."
    }
    //类方法
    static func generateShape(numberOfSides:Int) -> Shape {
        rerturn Shape(sides:numberOfSides)
    }
}
let s = Shape(sides: 4)
s.numberOfSides
s.totalInnerAngelSum
s.simpleDescription()
let anotherS = Shape.generateShape(numberOfSides: 3)
anotherS.simpleDescription()

```







