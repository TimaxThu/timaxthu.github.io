---
layout: article
title: 用Python网页爬虫获取豆瓣top50电影
key: 20220211
tags: Python 爬虫
pageview: false
modify_date: 2022-02-11
aside:
  toc: true
---

Python爬虫学习，项目笔记。

<!--more-->

# 需求

`https://movie.douban.com/top250`{:.info} 是豆瓣电影top250网页，上面有电影名称、导演、电影评分、电影封面图等信息。我们希望将其获取下来

# 准备工作

1. 通过**观察**发现，URL的格式为`https://movie.douban.com/top250?start=<xx>`，网站会从start+1的数字开始，列出下面的25条电影信息
2. 借助浏览器的检查工具：
   * Elements工具可以方便的提供我们所需要的信息在网页html文件中的位置。
   * Network工具可以获取到我们向浏览器发送的请求信息，包括cookie，Header，Response等等

3. 需要使用的python库如下，网络状态良好的话可以通过`pip install xxx`进行安装。

   ```python
   import urllib.request, urllib.error #指定URL，获取网页数据
   import bs4          # 网页解析，获取数据
   import re           # 正则表达式，进行文字匹配
   import xlwt         # 进行excel操作
   import sqlite3      # 进行SQLite数据操作(数据库相关)
   ```



# 获取数据

## 爬取网页

python使用urllib库获取页面

首先要制定头部信息head。在访问网页时，头部信息可以在	浏览器检查中Network中的Headers栏目找到。

* 头部信息是一个字典，里面的信息**成对出现**。

* request.Request函数：可以将**待访问的URL**，**头部信息Headers**等内容封装起来。
  {:.info}



## 解析数据

BeautifulSoup是一个很强大的



# 参考视频

* [Python爬虫编程基础5天速成（2021全新合集）Python入门+数据分析](https://www.bilibili.com/video/BV12E411A7ZQ?p=16&spm_id_from=pageDriver)



```python
from urllib import request, error
import socket
# 异常处理：urllib.error
try:
    resp = request.urlopen('http://www.google.com') 
except error.HTTPError as e:
    print("The serer couldn't fulfill the request.")
    print("Error code: ", e.code)
except error.URLError as e:
    print("We failed to reach a server.")
    print("Reason: ", e.reason)
    if isinstance(e.reason, socket.timeout):
        print("连接超时")
else:
    print("请求成功")
```

