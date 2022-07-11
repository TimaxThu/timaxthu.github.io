# 构建卡片

## 预览暗夜模式

```swift
// 这个是右侧preview的代码
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        // 这样可以让暗夜模式和亮模式同时预览
        ContentView()
            .preferredColorScheme(.dark)
        ContentView()
            .preferredColorScheme(.light)
    }
}
```





## 代码重用 - 新建视图View

<font color = orange>用于代码重用</font>

```swift
struct CardView: View {
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 18)
                .foregroundColor(.white)
            RoundedRectangle(cornerRadius: 18)
                .stroke(lineWidth: 4)
                .foregroundColor(/*@START_MENU_TOKEN@*/.orange/*@END_MENU_TOKEN@*/)
            Text("✈️")
                .font(.largeTitle)
        }
    }
}
```



## 代码重用 - 局部变量

```swift
struct CardView: View {
    var isFaceUp: Bool
    var body: some View {
        ZStack {
            let shape = RoundedRectangle(cornerRadius: 18)
            if isFaceUp { // 可以在试图中有 if else 判断
                shape.foregroundColor(.white)
                shape.stroke(lineWidth: 4)
                Text("✈️").font(.largeTitle)
            } else {
                shape.fill()
            }
        }
    }
}
```



## 改变试图中的变量 - @State

所有的View是不能变化的，变化是rebuilt重建的结果。因此View不能改变。

View中的变量不能更改，如果想在View中的更改变量，需要在前面加上@State，是将变量变为指向变量的指针，指针不变，变量可以改变。



## View中的循环ForEach

ForEach本身不是视图，他要放在HStack类似这种结构中

ForEach需要有可识别identifiable

```swift
struct ContentView: View {
    var body: some View {
        let emojis = ["✈️", "🚄", "⛴", "🚗"]
        HStack { // 水平堆叠 horizontal stack
//            ForEach(emojis, id: \.self, content: { emoji in
//                CardView(content: emoji)
//            })
            ForEach(emojis, id: \.self) { emoji in
                CardView(content: emoji)
            }
        }
        .padding()
        .foregroundColor(.orange)
    }
}
```





## HStack

<font color = orange>水平堆叠 horizontal stack</font>







# 添加按钮➕➖



## VStack

<font color=  orange>垂直堆叠</font>



# 实现卡片摆放

## LazyVGrid

展示多个View，lazy表示只有用到某个View才会加载它（大概就这个意思）

## aspectRatio

用来确定card的形状为2/3

```swift
CardView(content: emoji).aspectRatio(2/3, contentMode: .fit)
```

## ScrollView

可以在尺寸大于屏幕时添加滚动

## strokeBorder

strokeBorder替换stroke，用来防止ScrollView阶段边界线

􁊘􁊙

# 用到的View

## Text

```
Text("content")
```



## Button

```swift
Button(action: {
	//这里填按按钮时候的反应
}, label: {
	//这里是按钮的内容，可以是Text，也可以是VStack，Image这类的东西
})
```

```swift
Button {
    //... action things
} label: {
    //... label things
}
```



## Spacer

```
// 尽可能占用更多空间
Spacer()
```





<font size = 10>􁊘􀉚􀍣􀐴􀉮􁊙</font>

<font size = 10>􁊘􀉚􀍣􀐵􀉭􁊙</font>

<font size = 10>􁊘􀉚􀍤􀐴􀉭􁊙</font>

<font size = 10>􁊘􀉛􀍣􀐴􀉭􁊙</font>
