---
layout: article
title: 网页制作笔记
key: 20220304
tags: 计算机
pageview: false
modify_date: 2022-03-04
aside:
  toc: true
---



这里记录了学习网页制作的笔记，包括HTML、css、js三个部分，主要参考教程为[Web 开发技术文档 - MDN (mozilla.org)](https://developer.mozilla.org/zh-CN/docs/Web/)。

<!--more-->



* 先记一个知识点，在Mac上想通过pip安装其他python包怎么办？使用命令：

  ```shell
  $ python3 -m pip install 包名
  ```

# 前端

## 基础概念

* 元素
* 标签



标签：

em代表emphasize

strong：strong importance

p代表

标签：dl，dt和dd

dl：description list

dt：description terms

dd：description definition





<p>你好！欢迎访问我的激励网页！<a href="http://www.brainyquote.com/quotes/authors/c/confucius.html"><cite>孔子</cite></a>曰：</p>
<blockquote cite="https://zh.wikipedia.org/zh-hans/孔子">
  <p>譬如为山，未成一篑，止，吾止也。譬如平地，虽覆一篑，进，吾往也。</p>
</blockquote>
<p>要保持乐观，<q cite="http://www.affirmationsforpositivethinking.com/">不要说泄气的话</q>。（源自 <a href="http://www.affirmationsforpositivethinking.com/"><cite>Affirmations for Positive Thinking</cite></a>。）</p>



cite干什么的？

把这个加入到你的js文件中，他就可以拥有蜘蛛网动态效果

```javascript
//立即执行函数
//!的作用是告诉javascript引擎这是一个函数表达式，不是函数声明，()、！、+、-等运算符都能实现这个作用，不过()是最安全的
//在!function(){}后面加上()会立即调用这个函数
//这样做可以模仿一个私有作用域，这样html文件引用多个js文件时便不会造成变量冲突
!
function() {
    //canvas元素相关
    //创建canvas元素，并设置canvas元素的id
    var canvas = document.createElement("canvas"),
    context = canvas.getContext("2d"),
    attr = getAttr();
    //设置创建的canvas的相关属性
    canvas.id = "c_n" + attr.length;
    canvas.style.cssText = "position:fixed;top:0;left:0;z-index:" + attr.z + ";opacity:" + attr.opacity;
    //将canvas元素添加到body元素中
    document.getElementsByTagName("body")[0].appendChild(canvas);
    //该函数设置了canvas元素的width属性和height属性
    getWindowWH();
    //onresize 事件会在窗口或框架被调整大小时发生
    //此处即为当窗口大小改变时，重新获取窗口的宽高和设置canvas元素的宽高
    window.onresize = getWindowWH;
    //该函数会得到引用了本文件的script元素，
    //因为本文件中在赋值时执行了一次getScript函数，html文件引用本文件时，本文件之后的script标签还没有被浏览器解释，
    //所以得到的script数组中，引用了本文的script元素在该数组的末尾
    //该函数的用意为使开发者能直接修改在html中引入该文件的script元素的属性来修改画布的一些属性，画布的z-index，透明度和小方块数量，颜色
    //与前面往body元素添加canvas元素的代码配合，当开发者想要使用该特效作为背景时，只需在html文件中添加script元素并引用本文件即可
    function getAttr() {
        let scripts = document.getElementsByTagName("script"),
        len = scripts.length,
        script = scripts[len - 1]; //v为最后一个script元素，即引用了本文件的script元素
        return {
            length: len,
            z: script.getAttribute("zIndex") || -1,
            opacity: script.getAttribute("opacity") || 0.5,
            color: script.getAttribute("color") || "0,0,0",
            count: script.getAttribute("count") || 99
        }
    }
    //获得窗口宽高，并设置canvas元素宽高
    function getWindowWH() {
        W = canvas.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,
        H = canvas.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight
    }
    //生成随机位置的小方块
    var random = Math.random,
    squares = []; //存放小方块
    //往squares[]数组放小方块
    for (let p = 0; p < attr.count; p++) {
        var square_x = random() * W,
        //横坐标
        square_y = random() * H,
        //纵坐标
        square_xa = 2 * random() - 1,
        //x轴位移 -1,1
        square_ya = 2 * random() - 1; //y轴位移
        squares.push({
            x: square_x,
            y: square_y,
            xa: square_xa,
            ya: square_ya,
            max: 6000
        })
    }
    //生成鼠标小方块
    var mouse = {
        x: null,
        y: null,
        max: 20000
    };
    //获取鼠标所在坐标
    window.onmousemove = function(i) {
        //i为W3C DOM，window.event 为 IE DOM，以实现兼容IE
        //不过目前似乎IE已经支持W3C DOM，我用的是IE11，我注释掉下一句代码也能实现鼠标交互效果，
        //网上说7/8/9是不支持的，本人没有试验，
        //当然加上是没有错的
        i = i || window.event;
        mouse.x = i.clientX;
        mouse.y = i.clientY;
    }
    //鼠标移出窗口后，消除鼠标小方块
    window.onmouseout = function() {
        mouse.x = null;
        mouse.y = null;
    }
    //绘制小方块，小方块移动(碰到边界反向移动)，小方块受鼠标束缚
    var animation = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
    function(i) {
        window.setTimeout(i, 1000 / 45)
    }; //各个浏览器支持的requestAnimationFrame有所不同，兼容各个浏览器
    function draw() {
        //清除画布
        context.clearRect(0, 0, W, H);
        var w = [mouse].concat(squares); //连接(合并)鼠标小方块数组和其他小方块数组
        var x, v, A, B, z, y;
        //square属性表：x，y，xa，ya，max
        squares.forEach(function(i) {
            //实现小方块定向移动
            i.x += i.xa;
            i.y += i.ya;
            // 控制小方块移动方向
            // 当小方块达到窗口边界时，反向移动
            i.xa = i.xa * (i.x > W || i.x < 0 ? -1 : 1);
            i.ya = i.ya * (i.y > H || i.y < 0 ? -1 : 1);
            //fillRect前两个参数为矩形左上角的x，y坐标，后两个分别为宽度和高度
            //绘制小方块
            context.fillRect(i.x - 0.5, i.y - 0.5, 1, 1);
            //遍历w中所有元素
            for (let n = 0; n < w.length; n++) {
                x = w[n];
                //如果x与i不是同一个对象实例且x的xy坐标存在
                if (i !== x && null !== x.x && null !== x.y) {
                    x_diff = i.x - x.x; //i和x的x坐标差
                    y_diff = i.y - x.y; //i和x的y坐标差
                    distance = x_diff * x_diff + y_diff * y_diff; //斜边平方
                    if (distance < x.max) {
                        //使i小方块受鼠标小方块束缚，即如果i小方块与鼠标小方块距离过大，i小方块会被鼠标小方块束缚,
                        //造成 多个小方块以鼠标为圆心，mouse.max/2为半径绕成一圈
                        if (x === mouse && distance > x.max / 2) {
                            i.x = i.x - 0.03 * x_diff;
                            i.y = i.y - 0.03 * y_diff;
                        }
                        A = (x.max - distance) / x.max;
                        context.beginPath();
                        //设置画笔的画线的粗细与两个小方块的距离相关，范围0-0.5，两个小方块距离越远画线越细，达到max时画线消失
                        context.lineWidth = A / 2;
                        //设置画笔的画线颜色为s.c即画布颜色，透明度为(A+0.2)即两个小方块距离越远画线越淡
                        context.strokeStyle = "rgba(" + attr.color + "," + (A + 0.2) + ")";
                        //设置画笔的笔触为i小方块
                        context.moveTo(i.x, i.y);
                        //使画笔的笔触移动到x小方块
                        context.lineTo(x.x, x.y);
                        //完成画线的绘制，即绘制连接小方块的线
                        context.stroke();
                    }
                }
            }
            //把i小方块从w数组中去掉
            //防止两个小方块重复连线
            w.splice(w.indexOf(i), 1);
        });
        //window.requestAnimationFrame与setTimeout相似，形成递归调用，
        //不过window.requestAnimationFrame采用系统时间间隔，保持最佳绘制效率,提供了更好地优化，使动画更流畅
        //经过浏览器优化，动画更流畅；
        //窗口没激活时，动画将停止，省计算资源;
        animation(draw);
    }
    //此处是等待0.1秒后，执行一次draw()，真正的动画效果是用window.requestAnimationFrame实现的
    setTimeout(function() {
        draw();
    },
    100)
} ();
```

* [html5 canvas实现背景鼠标连线动态效果代码解析 (tddx.net)](https://www.tddx.net/post-485.html)

* [奇思妙想 CSS 文字动画 - SegmentFault 思否](https://segmentfault.com/a/1190000039362755)



# Tomcat

## 配置

1. 打开[Apache Tomcat官网](http://tomcat.apache.org)，点击左侧的downloads，选择对应的版本，选择`Core->tar.gz`

2. 解压下载后的包到本地路径下，如路径为：/Users/用户名/tomcat

3. 打开终端，执行命令`cd /Users/用户名/tomcat/bin`，进入到tomcat的bin目录下

4. 启动tomcat，执行命令：

   ```shell
   $ ./startup.sh
   ```
   （如果出现错误：“Permission denied”操作失败，缺少权限，输入命令`sudo chmod 755 *.sh` 赋予超级管理员权限）

5. 打开浏览器，输入网址 [`http://localhost:8080/`](http://localhost:8080/) ，如果出现一只三角猫，表示tomcat安装成功。

5. 关闭Tomcat时，在bin目录下，执行命令：`./shutdown.sh`





请求和响应

请求的GET和POST方法一个更安全（post），一个更高效（get）



发现了typora的快捷键：shift+tab可以让代码空格向前调整





## tomcat是什么

tomcat是一个**web容器**，用来装载你的Javaweb程序。你的jsp/servlet程序需要运行在Web容器上

也可以说tomcat是计算机上运行的服务器。你想访问计算机X上的文件B，B必须放在Web服务器（Tomcat）里才能被访问。

Web容器有很多种，JBoss、WebLogic等等，Tomcat是其中一种。Tomcat免费开源，由Apache，Sun和其它一些公司及个人共同开发而成。由于有了Sun的参与和支持，最新的Servlet和Jsp规范总能在Tomcat中得到体现。

==那么问题来了，tomcat内部结构是什么样子的呢？==

Tomcat中的应用程序是一个WAR（WebArchive）文件（war包）。也就是在tomcat根目录下面webapps文件夹中，每一个文件夹都是一个war包，一个项目。一般的war包格式为：

通常其根目录下包含有Html和Jsp文件或者包含这两种文件的目录，另外还会有一个 `WEB-INF` 目录。通常在 `WEB-INF` 目录下有一个 `web.xml` 文件和一个classes目录， `web.xml` 是这个应用的配置文件，而classes目录下则包含编译好的Servlet类和Jsp或Servlet所依赖的其它类（如JavaBean）。通常这些所依赖的类也可以打包成JAR放到 `WEB-INF` 下的lib目录下，当然也可以放到系统的CLASSPATH中，但那样移植和管理起来不方便。

（Tomcat不仅仅是一个Servlet容器，它也具有传统的Web服务器的功能：处理Html页面。但是与Apache相比，它的处理静态Html的能力就不如Apache。我们可以将Tomcat和Apache集成到一块，让Apache处理静态Html，而Tomcat处理Jsp和Servlet。这种集成只需要修改一下Apache和Tomcat的配置文件即可。）





参考：

* [tomcat到底是干嘛的 - Cherishforchen - 博客园 (cnblogs.com)](https://www.cnblogs.com/cherishforchen/p/10921792.html)



# Servlet

servletcontext可以保存一些东西**共享数据**











# Maven

Maven是一个**Java项目管理工具**。maven主要做了两件事情：

- 统一开发规范与工具

- 统一管理jar包

  **Maven工程首先会从本地仓库中获取jar包，当无法获取指定jar包时，本地仓库会从远程仓库（中央仓库）中下载jar包，并放入本地仓库以备将来使用**



参考：

* [Maven详解 - 独具匠心 - 博客园 (cnblogs.com)](https://www.cnblogs.com/hongwz/p/5456578.html)





# Java连接Mysql

Java连接mysql需要`import java.sql.*;`，同时需要导入mysql官方链接java的驱动（实际上就是一个jar包）。

我的mysql是在官网上下载的（没有在homebrew下载是因为觉得homebrew稍微麻烦，但实际上好像也没麻烦多少）。mysql下载之后如果想要在终端正常使用mysql，还需要在`~/.zshrc`下添加一个路径（我这次不添加就显示找不到mysql，之前添没添加过没有印象了）。





* [(22条消息) JavaWeb中的表单提交和超链接请求传递参数_一生所Ai的博客-CSDN博客_javaweb 表单提交](https://blog.csdn.net/qq_40180411/article/details/82343854)







## LayUI

* [Layui 管理界面大框架布局 - 在线演示 (itze.cn)](https://layui.itze.cn/demo/admin.html)

* [Layui 栅格系统与后台框架布局 (itze.cn)](https://layui.itze.cn/doc/element/layout.html#admin)



<h1 style="background: #E3C5FD;">fuck you</h1>

