

# 笔记

## Ctrl+鼠标的操作

通常用于将Storyboard和代码连接起来

按住Ctrl将Button拖拽到代码区，需要修改的参数：

```Swift
// 需要调整的参数：
// 1.Collection button和函数建立什么样的关联
//	Action（创建操作，当按下这个按钮的时候就调用这个方法）
//	Outlet（出口）和一个实例变量关联
//	Outlet collection 和实例变量的一个数组关联

// 2.Argument 参数 None是没有参数 Sender就是调用这个方法的按钮
// TODO 我不太清楚Sender是什么意思

// 3.Type 参数的类型 必须改成UIButton 不是Any
```



* 在Storyboard中右击Button可以查看和它关联的函数
* 按住Ctrl，将Storyboard中的View Controller拖拽到Button，可以修改关联的函数







## opt+鼠标的操作

opt+鼠标用于帮助，查看变量的类型，查看函数的文档

1. Swift有自动推断变量数据类型的功能，如果要查看某个<font color = green>变量</font>的数据类型可以按住opt，鼠标点击变量。
2. 按住按住option，鼠标移动到某个<font color = green>函数</font>的位置点击，可以查看函数的文档





## cmd+鼠标的操作

cmd+鼠标用于变量或函数的一些快捷操作Action。比如变量的Rename功能





## property observer 属性观察器

```Swift
var flipCount = 0 {
    //可以在变量的后面添加代码
    //property observer 属性观察器
    didSet {//每次变量值发送变量的时候，会执行这段代码
        flipCountLabel.text = "Flips: \(flipCount)"
    }
}
```





## 可选类型 ? Optional

讲 **可选类型 Optional** 部分的代码

```Swift
let cardNum = cardButtons.firstIndex(of: sender)
print("cardNumber = \(cardNum)")
//返回值是 Optional(1) Optional(2)
// Optional 是什么？
// 查看文档，发现firstIndex的返回值不是普通的int
// Int? int optional 可选的（optional）整数
// optional int 和int是完全不同的类型 没有关联
// optional这种类型有且仅有两种状态：set有值 & not set 缺省值，这是一个枚举类型（enumeration）
// Swift的每个枚举情况都可以有关联值（associate value）
// 这里的关联值就是int
// set会返回optional+关联值
// notset会返回nil
```



这样修改之后，可以查看到cardNum的类型是Index不是Index?

```Swift
let cardNum = cardButtons.firstIndex(of: sender)!
print("cardNumber = \(cardNum)")
// 解决问题的方法 1
// 在可选类型的后面加一个感叹号，表示
// 假设这个optional是有值set，那就赋予关联值
// 但如果此时optional没值not set 程序会crash
```



```Swift
if let cardNum = cardButtons.firstIndex(of: sender) {
    print("cardNumber = \(cardNum)")
} else {
    print("chosen card was not in cardButtons")
}
// 解决问题的方法 2
// 去掉感叹号，加一个if，也可以使cardNum的类型变为Array<UIButton>.Index
// 此时按optional not set的时候程序不会崩溃
```









# 代码



## 没有改数据索引之前的结构

```swift
import UIKit

class ViewController: UIViewController { //UIViewController是父类
    //按住Ctrl，将Button拉到代码区域
    
    
    //outlet创建一个实例变量
    @IBOutlet weak var flipCountLabel: UILabel!
    //感叹号：如果变量没有初始化，但他不会有错误提示
    

    
    // 这里可以把 : Int省略，因为已经有 = 0了，Swift会自动推断。
    // var flipCount: Int = 0
    // 可以用 opt+鼠标 查看变量类型
    var flipCount = 0 {
        //可以在变量的后面添加代码
        //property observer 属性观察器
        didSet {//每次变量值发送变量的时候，会执行这段代码
            flipCountLabel.text = "Flips: \(flipCount)"
        }
    }
    
    
    //@IBAction是Xcode修饰方法的特助指令
    @IBAction func touchCard(_ sender: UIButton) {
        flipCard(withEmoji: "👻", on: sender)
        flipCount += 1
    }
    // 当复制粘贴button的时候，也会复制粘贴button发送的消息
    
    
    @IBAction func touchSecondCard(_ sender: UIButton) {
        flipCard(withEmoji: "🎃", on: sender)
        flipCount += 1
    }
    
    
    // external name, internal name
    func flipCard(withEmoji emoji: String, on button: UIButton) {
        if button.currentTitle == emoji {
            //按住option，鼠标移动到某个函数的位置点击，可以查看函数的文档
            button.setTitle("", for: UIControl.State.normal)
            button.backgroundColor = UIColor.orange
        } else {
            button.setTitle(emoji, for: UIControl.State.normal)
            button.backgroundColor = UIColor.white
        }
    }
    


}
```





## 最终的架构

```Swift

//
//  ViewController.swift
//  concentration
//
//  Created by LetME on 2022/6/25.
//

import UIKit

class ViewController: UIViewController {
    
    //outlet创建一个实例变量
    @IBOutlet weak var flipCountLabel: UILabel!
    //感叹号：如果变量没有初始化，但他不会有错误提示
    
    var flipCount = 0 {
        //property observer 属性观察器
        didSet {//每次变量值发送变量的时候，会执行这段代码
            flipCountLabel.text = "Flips: \(flipCount)"
        }
    }
    
    //outlet Collection表示数组
    @IBOutlet var cardButtons: [UIButton]!
    
    var emojiChoices = ["🎃","👻","🎃","👻"]
    
    //@IBAction是Xcode修饰方法的特助指令
    @IBAction func touchCard(_ sender: UIButton) {
        flipCount += 1
        if let cardNum = cardButtons.firstIndex(of: sender) {
            flipCard(withEmoji: emojiChoices[cardNum], on: sender)
        } else {
            print("chosen card was not in cardButtons")
        }

    }
    // 当复制粘贴button的时候，也会复制粘贴button发送的消息
    
    

    
    
    // external name, internal name
    func flipCard(withEmoji emoji: String, on button: UIButton) {
        if button.currentTitle == emoji {
            //按住option（win），鼠标移动到某个位置点击，可以查看函数的文档
            button.setTitle("", for: UIControl.State.normal)
            button.backgroundColor = UIColor.systemOrange
        } else {
            button.setTitle(emoji, for: UIControl.State.normal)
            button.backgroundColor = UIColor.white
        }
    }
    


}

```

