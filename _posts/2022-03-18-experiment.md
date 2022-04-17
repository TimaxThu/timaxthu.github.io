---
layout: article
title: My Experiments
key: 20220314
tags: English
pageview: false
modify_date: 2022-03-27
aside:
  toc: true
---

简单记录下我动手写过的一些代码。<!--more-->





# 2022.04.17

静态网页的大作业写完啦！这是我做的第一个静态网页，整体上看我觉得审美在线。存在一些小问题，不过他们就留在日后解决吧！

网站我已经上传到[博客](https://timaxthu.github.io/fabulous/MyFirstWeb/index.html)上啦！



# 2022.03.18

## 概述

今天想做两件事情。

一：很久之前我爸在网上买了个“5块钱python从入门到精通”的视频包，今天在里面翻视频时发现有很多 `.ev4` 后缀的文件。想删掉但手动删太麻烦了，又因为文件套文件的形式挺复杂，我决定搞一个**dfs**遍历并删一下没用的 `.ev4` 后缀的文件。

需要用到的知识点有：

* 使用C++/C语言删除文件
* 使用C++/C判断路径是文件还是文件夹
* 使用C++/C遍历一个文件夹中的所有文件
* 字符串处理（判断后缀等）
* 深度搜索算法dfs

二：在Github上找到了一个[Real-ESRGAN](https://github.com/xinntao/Real-ESRGAN)的项目，可以利用机器学习优化照片的清晰度。因为是cmd命令操作，我考虑**利用C++调用cmd命令**，由此可以很方便的完成**批量照片的处理**。

需要用到的知识点有：

* 使用C++/C文件操作
* 使用C++/C调用cmd命令



这次实验是在Windows系统下进行的，不保证代码在Mac OS或Linux系统上是否可以正常运行。
{:.warning}



## 实验一

### 删除文件

使用 `int remove(const char * filename);` 函数删除文件，该函数位于stdio.h头文件中。

```cpp
#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
using namespace std;
int main() {
	char savePath[50] = "D:\\Desktop\\test.txt";//欲删除D盘Desktop文件夹中test.txt文件
	if (remove(savePath) == 0)
		cout << "删除成功" << endl;
	else {
		cout << "删除失败" << endl;
		cout << strerror(errno);		//输出错误信息
	}
	return 0;
}
```



### 删除文件夹

首先介绍Windows.h API中的RemoveDirectory();函数，这个函数**只能删除内容为空的文件夹**。

```cpp
#include <Windows.h>
#include <iostream>
using namespace std;
int main() {
	string dirName = "D:\\Desktop\\file2";
	bool flag = RemoveDirectory(dirName.c_str());
	if (flag)
		cout << "Delete successfully!" << endl;
	else
		cout << "ERROR" << endl;
	return 0;
}
```



### 判断某一路径是目录还是文件

[(22条消息) C++ 判断某一路径是目录还是文件_keep_forward的博客-CSDN博客_c++ 判断是否为文件夹](https://blog.csdn.net/b876144622/article/details/79995304)



### 字符串处理，遍历文件夹

[(22条消息) C++遍历文件夹下的所有文件夹及文件_Q_C的博客-CSDN博客_c++ 遍历所有文件夹](https://blog.csdn.net/zjdnwpu/article/details/53572241)

```cpp
#include <iostream>
#include <fstream>
#include <io.h>
#include <string>
#include <vector>

using namespace std;


void getAllFiles(string path, vector<string>& files)
{
	long hFile = 0;               //文件句柄
	struct _finddata_t fileinfo;  //文件信息读取结构
	string p;
	//assign函数用于赋值操作，append是在string的末尾添加字符串，
	if ((hFile = _findfirst(p.assign(path).append("\\*").c_str(), &fileinfo)) != -1) {
		do {
			if ((fileinfo.attrib & _A_SUBDIR)) { //比较文件类型是否是文件夹
				if (strcmp(fileinfo.name, ".") != 0 && strcmp(fileinfo.name, "..") != 0) {
					getAllFiles(p.assign(path).append("\\").append(fileinfo.name), files);     //如果是文件夹，继续向下遍历
				}
			}
			else { //是文件
				cout << p.assign(path).append("\\").append(fileinfo.name) << endl;
				files.push_back(p.assign(path).append("\\").append(fileinfo.name));  //是文件，将其路径加入到files集合中
			}
		} while (_findnext(hFile, &fileinfo) == 0);  //寻找下一个，成功返回0，否则-1
		_findclose(hFile);
	} 
	else{
		cout << "没有该名称的文件夹" << endl;
	}
}


void test01() {
	string name1 = "/a/b/c/v/zhiodfh.jpg";
	int pos1 = name1.find_last_of('/');
	string name2 = name1.substr(pos1 + 1);
	cout << "pos1:" << pos1 << endl;
	cout << "name2:" << name2 << endl;
	int pos2 = name2.find('.');
	string name3 = name2.substr(0, pos2);
	cout << "name3:" << name3 << endl;
	string name4 = name1.substr(name1.find_last_of('.') + 1);
	cout << "name4:" << name4 << endl;
}

int main()
{
	test01();
	cout << endl << endl << endl << endl;
	char filePath[50] = "D:\\Desktop\\file2";       //所要查找的文件夹
	//char distAll[50] = "path.txt";    //结果保存
	vector<string> files;           //保存文件路径信息
	//ofstream ofn(distAll);          //打开文件
	int size = 0;                   //存储文件个数

	while (!files.empty()) files.pop_back();//清空vector
	cout << endl;

	getAllFiles(filePath, files);   //递归查找文件以及文件夹。文件夹路径为filePath
	size = files.size();            //包含文件个数
	cout << size << endl;
	for (int i = 0; i < size; i++)
	{
		cout << files[i] << endl;    //把文件路径保存
	}
	//ofn.close();                    //文件关闭
	return 0;
}
```



### 最终代码

```cpp
#include <iostream>
#include <fstream>
#include <io.h>
#include <string>
#include <vector>
using namespace std;

void getAllFiles(string path, vector<string>& files)
{
	long hFile = 0;               //文件句柄
	struct _finddata_t fileinfo;  //文件信息读取结构
	string p;
	//assign函数用于赋值操作，append是在string的末尾添加字符串，
	if ((hFile = _findfirst(p.assign(path).append("\\*").c_str(), &fileinfo)) != -1) {
		do {
			if ((fileinfo.attrib & _A_SUBDIR)) { //比较文件类型是否是文件夹
				if (strcmp(fileinfo.name, ".") != 0 && strcmp(fileinfo.name, "..") != 0) {
					getAllFiles(p.assign(path).append("\\").append(fileinfo.name), files);     //如果是文件夹，继续向下遍历
				}
			}
			else { //是文件
				string name1 = p.assign(path).append("\\").append(fileinfo.name);
				string name4 = name1.substr(name1.find_last_of('.') + 1);
				if (name4 == "ev4") {
					//cout << name1 << endl;
					files.push_back(p.assign(path).append("\\").append(fileinfo.name));  //是文件，将其路径加入到files集合中
					if (remove(name1.c_str()) == 0)
						cout << "删除成功" << endl;
					else 
						cout << "删除失败" << endl;
				}
					
			}
		} while (_findnext(hFile, &fileinfo) == 0);  //寻找下一个，成功返回0，否则-1
		_findclose(hFile);
	} 
	else{
		cout << "没有该名称的文件夹" << endl;
	}
}

int main() {
	char filePath[50] = "D:\\Downloads\\python全套（推荐）";       //所要查找的文件夹
	vector<string> files;           //保存文件路径信息
	int size = 0;                   //存储文件个数

	while (!files.empty()) files.pop_back(); //清空vector

	cout << endl;

	getAllFiles(filePath, files);   //DFS查找文件以及文件夹，文件夹路径为filePath
	size = files.size();            //包含文件个数
	cout << size << endl;
	for (int i = 0; i < size; i++)
		cout << files[i] << endl;    //把文件路径保存
	return 0;
}
```





## 实验二

实际上单纯的调用cmd命令只需要system函数就可以了。我本身想研究一些复杂cmd命令的实现，比如连续执行多条cmd命令。但是只用简单的语句就完成了实验，因此也没有深究。

```cpp
/*我的模型和程序下载在D:\Downloads\realesrgan-ncnn-vulkan-20211212-windows中，图片位于D:\Desktop\U\Mar22，且图片由<数字.jpg>命名*/
#include <iostream>
#include <string>
using namespace std;
int main() {
	string resource = "D:\\Downloads\\realesrgan-ncnn-vulkan-20211212-windows\\realesrgan-ncnn-vulkan.exe ";
	string filename = "D:\\Desktop\\U\\Mar22";
	for (int i = 2; i <= 25; i++) {
		cout << "正在对第 " << i << " 张图片进行处理..." << endl;
		string ord = resource + "-i \"" + filename + "\\" + to_string(i) + ".jpg\" -o \"" + filename + "\\" + to_string(i) + ".png\"";
		system(ord.c_str());
	}
	//cout << "D:\\Downloads\\realesrgan-ncnn-vulkan-20211212-windows\\realesrgan-ncnn-vulkan.exe -i \"D:\\Desktop\\U\\Mar22\\1.jpg\" -o \"D:\\Desktop\\U\\Mar22\\1.png\" " << endl;
	system("pause");
}
```



注意：图片的处理对CPU和GPU的占用率还是很高的，相当于烤机测试了。大家注意电脑安全！不要烧坏了它。













