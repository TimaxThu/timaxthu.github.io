---
layout: article
title: Useful Tools
key: 20220327
tags: 计算机 工具 配置
pageview: false
modify_date: 2022-03-27
aside:
  toc: true
---

所有我使用过的有趣和有用的工具都记录在这里<!--more-->



# [FFmpeg：可跨平台，用于录制/转换视频流/音频](https://ffmpeg.org/)

FFmpeg在Mac和Windows上都可以使用，他可以方便地完成下面这些事情：

* 视频的格式转换。例如将从YouTube下载的`.webm`格式的视频转换成`.mp4`格式
* 录制直播流。例如找到抖音直播对应的`.flv`格式流媒体后将其录制下来（另外你也可以使用Potplayer进行流媒体的录制）

当然，FFmpeg可以做的事情还有很多，感兴趣可以自行搜索。

## 简述使用方法

在Mac端，使用`homebrew` ，在终端中输入shell：

```shell
$ brew install ffmpeg
```

homebrew会自动下载。

概括的说，FFmpeg的shell格式如下：

```shell
$ ffmpeg [global_options] {[input_file_options] -i input_url} ... {[output_file_options] output_url} ...
```

然而在使用中，我基本上只用过下面的这一种语句，即：

```shell
$ ffmpeg -i "/Users/letme/Downloads/rose1.webm"  "/Users/letme/Downloads/rose12.mp4"
```

`-i` 是input的命令。同时FFmpeg会将没有命令的一项当成默认的输出地址，也就是上述例子中的`/Users/letme/Downloads/rose12.mp4`。`.mp4`规定了output视频的格式。

如果你想要保存直播流，只需要将`-i`后面的输入地址改成对应的`.flv`文件即可。在你想要停止录制时，只需要使用终端终止命令 `control^` + `C` 停止录制。

更多关于FFmpeg的信息，可以参考以下介绍：

* [FFmpeg官方文档](https://ffmpeg.org/ffmpeg.html)



# [Real-ESRGAN：让照片更清晰](https://github.com/xinntao/Real-ESRGAN)

Real-ESRGAN是一个开源的项目，这个工具使用机器学习的方法，可以使一张不清楚的照片变得更加清晰。实际上，这种[使用机器学习提升照片质量的GitHub项目](https://www.google.com/search?q=Improve+photo+quality+github&sxsrf=APq-WBvdVOv3s26ul79wLfVmKTtei3a8Wg%3A1648369018571&ei=eh1AYsvFIqrZz7sP5dChmAs&ved=0ahUKEwjL6r2O7eX2AhWq7HMBHWVoCLMQ4dUDCA4&uact=5&oq=Improve+photo+quality+github&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECdKBAhBGABKBAhGGABQAFgAYMgJaABwAXgAgAGBAYgBgQGSAQMwLjGYAQCgAQKgAQHAAQE&sclient=gws-wiz)有很多，感兴趣可以自行研究。

在Real-EsRGAN的repository中找到Releases，选择你的系统对应的Assets，解压后简单操作即可开始“提升照片”。

这里分享一个我遇到的问题：**这个工具似乎对AMD的支持不太好**。我的PC是AMD的CPU和Nvidia的GPU，即AMD核显+英伟达独显，配置后会出现问题，参考[这个issue](https://github.com/xinntao/Real-ESRGAN/issues/76)。我的解决办法是在Windows设备管理中将核显关闭后就可以正常使用该工具了。之后我打开了核显，再之后的使用过程中就没有出现过类似的问题。



# Videoscribe：制作手绘白板动画小视频

<!--more-->

{%- include extensions/youtube.html id='254inqp5hco' -%}

你一定看过这样的手绘视频，并好奇这是如何制作的。Videoscribe可以满足你的需求。这里不多介绍了，感兴趣自行搜索。
