package class01;

public class Code03_Near2Power {

	// 已知n是正数
	// 返回大于等于，且最接近n的，2的某次方的值
	public static final int tableSizeFor(int n) {
		n--;//减一是为了兼顾n就是2的某次方的情况。
		n |= n >>> 1;//填满函数：这块右移可以使，从最高位的1开始，后面的1都变成（二进制）
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;//整形就32位，所以到16就够了，如果是long类型就再加一个
		return (n < 0) ? 1 : n + 1;
	}



	public static void main(String[] args) {
		int cap = 120;
		System.out.println(tableSizeFor(cap));
	}

}
