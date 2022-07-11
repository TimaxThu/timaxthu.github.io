



```swift
//
//  ContentView.swift
//  Memorize
//
//  Created by LetME on 2022/7/3.
//

import SwiftUI

struct ContentView: View {
    var body: some View {

        ZStack {//这里的大括号实际上是ZStack的一个参数，这样写是为了让代码更好看
            //view builder
            
            Text("Hello, 靳继珉，哈哈哈!")
                .foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                .padding()
            

            RoundedRectangle(cornerRadius: 18)
                .stroke(lineWidth: 3)
                .foregroundColor(/*@START_MENU_TOKEN@*/.orange/*@END_MENU_TOKEN@*/)
            
            
            RoundedRectangle(cornerRadius: 18)
                .stroke(lineWidth: 3)
                .padding(.all, 50.0)
                .foregroundColor(/*@START_MENU_TOKEN@*/.red/*@END_MENU_TOKEN@*/)
            
        }
        .frame(height: 200.0)
        .padding()
        //ZStack也是View，也具有View的功能
            
    }
    
    
    
}



// 这个是右侧preview的代码
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

```

