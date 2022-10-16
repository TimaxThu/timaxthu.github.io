---
layout: article
title: 微信小程序开发
key: 20220314
tags: 计算机
pageview: false
modify_date: 2022-04-20
aside:
  toc: true
---

微信小程序开发学习

<!--more-->





## 官方文档







## 基础

### 项目的基本组成结构

①<font color = red> pages 用来存放所有小程序的页面</font>
② utils 用来存放工具性质的模块（例如：格式化时间的自定义模块）
③ <font color = red>app.js小程序项目的入口文件</font>（如果选择TypeScript就是app.ts）
④ <font color = red>app.json 小程序项目的全局配置文件</font>
⑤ app.wxss 小程序项目的全局样式文件
⑥ project.config.json 项目的配置文件
⑦ sitemap.json 用来配置小程序及其页面是否允许被微信索引

> .eslintrc.js    project.private.config.json





### 小程序页面的组成部分

小程序官方建议把所有小程序的页面，都存放在<font color = red>pages 目录中</font>，以<font color = red>单独的文件夹</font>存在

其中，每个页面由 4 个基本文件组成，它们分别是：
①  .js文件（页面的脚本文件，存放页面的数据、事件处理函数等）
② .json 文件（当前页面的配置文件，配置窗口的外观、表现等）
③ .wxml 文件（页面的模板结构文件，即网页的.html）
④ .wxss 文件（当前页面的样式表文件，即网页的.css）



#### <font color = red>【JSON配置文件】</font>

JSON是一种数据格式，在实际开发中JSON总是以<font color = red>配置文件</font>的形式出现。小程序项目中也不刚外，通过不同的json 配置文件，可以对小程序项目进行不同级别的配置。

小程序项目中有4 种json 配置文件． 本别是：

* ① 项目根目录中的 app.ison 配置文件

  app.json 是当前小程序的**全局配置**，包括了小程序的所有页面路径、窗口外观、界面表现、底部tab等。

  其中的四个配置项的作用：

  1. pages：用来记录当前小程序所有页面的路径
  2. window：全局定义小程序所有页面的背景色、文字颜色等
  3. style：全局定义小程序组件所使用的样式版本（style v2是最新样式版本）
  4. sitemapLocation：用来指明sitemap.json 的位置

* ② 项目根目录中的 project.config.ison 配置文件

  project.config.json 是项目配置文件，用来记录我们**对小程序开发工具所做的个性化配置**，例如：

  * setting 中保存了编译相关的配置
  * projectname 中保存的是项目名称
  * appid 中保存的是小程序的账号ID

* ③ 项目根目录中的 sitemap.json 配置文件

  用于实现或关闭小程序内搜索

* ④ 每个页面文件夹中的 .json 配置文件

  小程序中的每一个页面，可以使用 json 文件来对本页面的窗口外观进行配置，**页面中的配置项会覆盖 app.json 的 window 中相同的配置项**。



在 app.json 中：

**新建小程序页面**：只需要在 app.json->pages 中新增页面的存放路径，小程序开发者工具即可帮我们自动创建对应的页面文件

**修改项目首页**：只需要调整 app.json-＞pages 数组中页面路径的前后顺序，即可修改项目的首页。小程序会把排在第一位的页面，当作项目首页进行渲染





#### <font color = red>【WXML】</font>

**什么是 WXML**：WXML (weixin Markup Language）是小程序框架设计的一套**标签语言，用来构建小程序页面的结构**，其作用类似于网页开发中的 HTML。

**WXML和 HTML的区别**：

1. 标签名称不同
   * HTML (div, span, img, a)
   * WXML (view, text, image, navigator)
2. 属性节点不同
   * `<a href="#">超链接</a>`
   * `<navigator url="/pages/home/home"></navigator>`
3. 提供了类似于 vue 中的模板语法
   * 数据绑定
   * 列表渲染
   * 条件渲染



#### <font color = red>【WXSS】</font>

**什么是 WXSS**：WXSS (Weixin Style Sheets)是一套样式语言，用于描述 WXML的组件样式，类似于网页开发中的CSS。

**WXSS 和CSS的区别**：

1. 新增了rpx尺寸单位
   * CSS 中需要手动进行像素单位换算，例如rem
   * WXSS 在底层支持新的尺寸单位 rpx，在不同大小的屏幕上小程序会自动进行换算
2. 提供了全局的样式和局部样式
   * 项目根目录中的 app.wxss会作用于所有小程序页面
   * 局部页面的.WXSS 样式仅对当前页面生效
3. WXSS 仅支持部分 CSS 选择器
   * .class 和 #id
   * element
   * 并集选择器、后代选择器
   * ::after 和 ::before 等伪类选择器



#### <font color=red>【JS】</font>

**小程序中的.js 文件**：一个项目仅仅提供界面展示是不够的，在小程序中，我们通过js 文件来处理用户的操作。例如：响应用户的点击、获取用户的位置等等

**小程序中.js 文件的分类**：

小程序中的JS 文件分为三大类，分别是：
1. app.js：是整个小程序项目的入口文件，通过调用 App()西数来启动整个小程序
2. 页面的 .js 文件：是页面的入口文件，通过调用 Page()西数来创建并运行页面
3. 普通的 .js 文件：是普通的功能模块文件，用来封装公共的函数或属性供页面使用





### 组件



CSS3 :**nth**-**child**() 选择器

:**nth**-**child**(n) 选择器匹配父元素中的第n 个子元素，元素类型没有限制。 n 可以**是**一个数字，一个关键字，或者一个公式。





### WXML语法

#### Mustache 语法

Mustache 语法的格式：把data中的数据绑定到页面中渲染，使用Mustache 语法（双大括号）将变量包起来即可。语法格式为：

```html
<view>{{要绑定的数据名称}}</view>
```













# 附录



## 参考





## 测试代码

demo1

```html
<!--pages/list/list.wxml-->
<view class="container1">
  <view>A</view>
  <view>B</view>
  <view>C</view>
</view>

<scroll-view class="container2" scroll-y>
  <view>A</view>
  <view>B</view>
  <view>C</view>
</scroll-view>
```

```css
/* pages/list/list.wxss */
.container1 view{
  width: 100px;
  height: 100px;
  /* margin: 10px; */
  background-color: aquamarine;


  text-align: center;/*文字的横向居中*/
  line-height: 100px;/*文字的高度调成扥估与height实现纵向居中*/

}
.container1 view:nth-child(1) {
  background-color: chartreuse;
}
.container1 view:nth-child(2) {
  background-color: bisque;
}
.container1 view:nth-child(3) {
  background-color: cadetblue;
}

.container1 {
  display: flex;
  justify-content: space-around;
}


.container2 view {
  height: 100px;
  width: 100px;
  line-height: 100px;
  text-align: center;
  background-color: cornflowerblue;
}
.container2 {
  border: 1px solid red;
  height: 120px;
  width: 100px;
}
```

