package class01;

import java.io.File;
import java.util.Stack;

//todo 面试场上经常让读写文件，一定要搞会！文件的读写，调用库啥的
// 题这么简单，最好就不要用递归了，可以用bfs+队列做
public class Code02_CountFiles {

	// 注意这个函数也会统计隐藏文件
	public static int getFileNumber(String folderPath) {
		File root = new File(folderPath);
		if (!root.isDirectory() && !root.isFile()) {
			return 0;
		}//处理边界
		if (root.isFile()) {
			return 1;
		}//处理边界
		Stack<File> stack = new Stack<>();
		stack.add(root);
		int files = 0;
		while (!stack.isEmpty()) {
			File folder = stack.pop();
			for (File next : folder.listFiles()) {
				if (next.isFile()) {
					files++;
				}
				if (next.isDirectory()) {
					stack.push(next);
				}
			}
		}
		return files;
	}

	public static void main(String[] args) {
		// 你可以自己更改目录
		String path = "/Users/zuochengyun/Desktop/";
		System.out.println(getFileNumber(path));
	}

}
