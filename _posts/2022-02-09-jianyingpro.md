---
layout: article
title: 从剪映Pro json文件导出字幕
key: 20220209
tags: 剪映  实践
pageview: false
modify_date: 2022-02-09
aside:
  toc: true
---





想从剪映的json文件中提取字幕，但是失败了。

<!--more-->

# 需求

[剪映Pro](https://lv.ulikecam.com/)中有自动生成字幕的功能，但是并不能把字幕导出。我希望可以把剪映的字幕导出成srt或txt文件。



# 处理思路

首先，剪映通过`json`{:.info}文件储存所有的剪辑信息，包括字幕。

保存本地草稿的文件夹名为`JianyingPro Drafts`{:.info}。进入该文件夹，会看到本地所有剪辑草稿（项目）对应的文件夹。找到你想生成字幕的那个项目，进入那个文件夹后，里面的`draft_content.json`{:.info}就是这个项目的剪辑信息。

字幕信息位于`materials->texts`节点下，其中有用的content和id这两个信息。字幕的内容记录在`content`中；字幕的时间通过`id`和字幕对应。

字幕的时间存储在`tracks`节点下，`segments->target_timerange`中。target_timerange节点，存储的就是字幕的开始时间和持续时间，单位都是毫秒，需要换算成时分秒。

更详细的介绍可以查看[这一篇文章](https://zhuanlan.zhihu.com/p/387113572)。

> 实际上，网上导出字幕信息的软件有很多。但因为这个原理相对不难实现，所以我想自己动手实现一下。





# 总结

1. 提取字幕的过程实际上就是处理字符串的过程。可以想象到，在真实项目中，**字符串处理**这件事情十分重要。
2. 关于C++，在操作中需要掌握的知识：
   * 读取文件操作（全部读取的方法，同时注意大文件是否能成功读取）
   * 字符编码转换。C++可以读取ANSI的中文不乱码。如果源文件是utf-8格式的怎么办？
3. C++在处理实际问题的时候效率太低了。我迫切需要学习并熟练掌握（指可以实践）另一门语言。
