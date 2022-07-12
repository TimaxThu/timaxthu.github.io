

# Model

## 泛型

老师将泛型，是这样解释的：

我们在写代码的过程中“不在乎”他是什么。例如我们在Card结构体中的content的类型，我们在编写的过程中不在乎他到底是什么具体类型。



```swift
import Foundation

// 这是我们的模型
struct MemoryGame<CardContent> {
    var cards: Array<Card>
    
    func choose(_ card: Card) {
        
    }
    struct Card {
        var isFaceUp: Bool
        var isMatched: Bool
        var content: CardContent
    }  
}
```







# ViewModel

ViewModel是View的一部分，但不是UI

View和Model都是struct，但是ViewModel是class

<font color = red>struct类名后面的`:`表示behaves like</font>

## 访问权限：private, private(set)







## 使用内联函数，类型推断优化代码

```swift
// 最初版本
func makeCardContent(index: Int) -> String {
    return "😁"
}

//ViewModel会创建自己的Model，ViewModel本身是truth
class EmojiMemoryGame {
    // private(set) 可以看，但是不能设置set
    private(set) var model: MemoryGame<String> = MemoryGame<String>(numberOfPairOfCards: 4, createCardContent: makeCardContent)
    
    var cards: Array<MemoryGame<String>.Card> {
        return model.cards
    }
    
}
```

```swift
// 可以使用内联函数
//ViewModel会创建自己的Model，ViewModel本身是truth
class EmojiMemoryGame {
    // private(set) 可以看，但是不能设置set
    private(set) var model: MemoryGame<String> = MemoryGame<String>(numberOfPairOfCards: 4, createCardContent: { (index: Int) -> String in
        return "😁"
    })
    
    var cards: Array<MemoryGame<String>.Card> {
        return model.cards
    }
    
}
```

```swift
// 因为Swift有类型推断功能，这里调用的是init函数且init函数声明了参数的类型，所以Int和String都可以省略
    private(set) var model: MemoryGame<String> =
        MemoryGame<String>(numberOfPairOfCards: 4, createCardContent: { index in
            return "😁"
        })

// createCardContent是最后一个参数，可以直接加大括号，去掉小括号
// return 可以省略，index没有用到可以用_代替
// 最终版本：
private(set) var model: MemoryGame<String> =
        MemoryGame<String>(numberOfPairOfCards: 4) { _ in "😁" }

```

