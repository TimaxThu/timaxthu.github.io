



## lazy的类成员变量

Swift在初始化中，同一个类中的成员变量不能互相调用。
如果在初始化中，一个变量需要用另一个初始化，此时会出问题，可以用lazy解决

```swift
// lazy表示直到有人用到这个变量，才会进行初始化
// 这解决了game和cardButtons同时初始化但是game需要使用cardButtons的问题
// 但是lazy不能有didset
lazy var game = Concentration(numberOfPairsOfCards: (cardButtons.count + 1) / 2)

@IBOutlet var cardButtons: [UIButton]!
```





## 操作符 `??`

emoji是一个字典`[Int: String]`，`emoji[Int]`返回的类型是`String?`，也就是optional。

```swift
// 下面的两种写法是等价的：
// <1>
if emoji[card.identifier] != nil {
    return emoji[card.identifier]!
} else {
    return "?"
}

// <2>
return emoji[card.identifier] ?? "?"
```



## Int和UInt32的转换

```swift
// let randomIndex = arc4random_uniform(emojiChoices.count)
let randomIndex = Int(arc4random_uniform(UInt32(emojiChoices.count)))
```





## 两个if判断用 `,` 合在一起

```swift
if A {
    if B {
        //...
    }
}
//等价于
if A, B {
    //...
}
```



```swift
//if emoji[card.identifier] == nil {
//    if emojiChoices.count > 0 {
//        let randomIndex = Int(arc4random_uniform(UInt32(emojiChoices.count)))
//        emoji[card.identifier] = emojiChoices.remove(at: randomIndex)
//    }
//}
        
if emoji[card.identifier] == nil, emojiChoices.count > 0 {
    let randomIndex = Int(arc4random_uniform(UInt32(emojiChoices.count)))
    emoji[card.identifier] = emojiChoices.remove(at: randomIndex)
}
```









## 思考



首先在storyboard中已经完整了卡片数量的设置，这个属于View，但是Controller也能看到。

Controller根据View中卡片的数量，生成Model模型对象。

（可以这么理解）模型Model就是实现这个业务的那些抽象代码。



