package class02;

import java.util.Arrays;

public class Code04_Drive {

  // 课上的现场版本
  // income -> N * 2 的矩阵 N是偶数！
  // 0 [9, 13]
  // 1 [45,60]
  public static int maxMoney1(int[][] income) {
    if (income == null || income.length < 2 || (income.length & 1) != 0) {
      return 0;
    }
    int N = income.length; // 司机数量一定是偶数，所以才能平分，A N /2 B N/2
    int M = N >> 1; // M = N / 2 要去A区域的人
    return process1(income, M, 0);
  }

  // index.....所有的司机，往A和B区域分配！
  // A区域还有restA个名额!
  // 返回把index...司机，分配完，并且最终A和B区域同样多的情况下，index...这些司机，整体收入最大是多少！


  // restA表示剩余的A处的工作，只考虑从index到之后的司机，返回他们获得最大的工资
  static int process1(int[][] income, int restA, int index) {
    //如果没有司机剩余，返回0（边界条件）
    if (index == income.length) return 0;
    //base case
    if (restA == 0) { // 如果A工作无剩余了，只能去B
      return income[index][1] + process1(income, restA, index + 1);
    } else if (restA == income.length - index) { // B工作无剩余
      return income[index][0] + process1(income, restA - 1, index + 1);
    }
		// 当前司机，可以去A，或者去B
    int pA = income[index][0] + process1(income, restA - 1, index + 1);
    int pB = income[index][1] + process1(income, restA, index + 1);
    return Math.max(pA, pB);
  }

  // 严格位置依赖的动态规划版本
  public static int maxMoney2(int[][] income) {
    int N = income.length;
    int M = N >> 1;
    int[][] dp = new int[N + 1][M + 1];
    for (int i = N - 1; i >= 0; i--) {
      for (int j = 0; j <= M; j++) {
        if (N - i == j) {
          dp[i][j] = income[i][0] + dp[i + 1][j - 1];
        } else if (j == 0) {
          dp[i][j] = income[i][1] + dp[i + 1][j];
        } else {
          int p1 = income[i][0] + dp[i + 1][j - 1];
          int p2 = income[i][1] + dp[i + 1][j];
          dp[i][j] = Math.max(p1, p2);
        }
      }
    }
    return dp[0][M];
  }

  static int maxMoneySelf(int[][] income) {
    if (income == null || income.length < 2 || (income.length & 1) != 0) return 0;
    int N = income.length;
    int[][] dp = new int[N / 2 + 1][N + 1]; // restA index
    for (int index = N - 1; index >= 0; index--) {
      dp[0][index] = income[index][1] + dp[0][index + 1];
    }
    for (int restA = 1; restA <= N / 2; restA++) {
      for (int index = N - 1; index >= 0; index--) {
        if (restA == N - index)
          dp[restA][index] = income[index][0] + dp[restA - 1][index + 1];
        else
          dp[restA][index] = Math.max(income[index][0] + dp[restA - 1][index + 1]
            , income[index][1] + dp[restA][index + 1]);

      }
    }
    return dp[N / 2][0];
  }


  static int maxMoneySelf2(int[][] income) { //数组状态压缩
    if (income == null || income.length < 2 || (income.length & 1) != 0) return 0;
    int N = income.length;
    int[] arr = new int[N / 2 + 1]; // 相当于dp数组的一列
    for (int index = N - 1; index >= 0; index--) {
      //第一个数
      arr[0] = income[index][1] + arr[0]; // TODO 这里的index = index + 1 就是 index = index
      for (int restA = 1; restA <= N/2; restA++) {
        if (restA == N - index) {
          arr[restA] = income[index][0] + arr[restA - 1];
        } else {
          arr[restA] = Math.max(income[index][0] + arr[restA - 1]
            , income[index][1] + arr[restA]);
        }
      }

    }
    return arr[N/2];
  }


  // 这题有贪心策略 :
  // 假设一共有10个司机，思路是先让所有司机去A，得到一个总收益
  // 然后看看哪5个司机改换门庭(去B)，可以获得最大的额外收益
  // 这道题有贪心策略，打了我的脸
  // 但是我课上提到的技巧请大家重视
  // 根据数据量猜解法可以省去大量的多余分析，节省时间
  // 这里感谢卢圣文同学
  public static int maxMoney3(int[][] income) {
    int N = income.length;
    int[] arr = new int[N];
    int sum = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = income[i][1] - income[i][0];
      sum += income[i][0];
    }
    Arrays.sort(arr);
    int M = N >> 1;
    for (int i = N - 1; i >= M; i--) {
      sum += arr[i];
    }
    return sum;
  }

  // 返回随机len*2大小的正数矩阵
  // 值在0~value-1之间
  public static int[][] randomMatrix(int len, int value) {
    int[][] ans = new int[len << 1][2];
    for (int i = 0; i < ans.length; i++) {
      ans[i][0] = (int) (Math.random() * value);
      ans[i][1] = (int) (Math.random() * value);
    }
    return ans;
  }

  public static void main(String[] args) {
    int N = 10;
    int value = 100;
    int testTime = 500;
    System.out.println("测试开始");
    for (int i = 0; i < testTime; i++) {
      int len = (int) (Math.random() * N) + 1;
      int[][] matrix = randomMatrix(len, value);
      int ans1 = maxMoney1(matrix);
      int ans2 = maxMoney2(matrix);
      int ans3 = maxMoneySelf2(matrix);
      if (ans1 != ans2 || ans1 != ans3) {
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println("Oops!");
        break;
      }
    }
    System.out.println("测试结束");
  }

}
