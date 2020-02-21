//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package leetcode.editor.cn;

//Java：爬楼梯
public class P70ClimbingStairs {
	public static void main(String[] args) {
		Solution solution = new P70ClimbingStairs().new Solution();
		// TO TEST
		System.out.println(solution.climbStairs(4));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//数组记录中间值
		public int climbStairs(int n) {
			int[] result = new int[n + 1];
			result[0] = 0;
			if (n < 1) return 0;
			if (n >= 1) result[1] = 1;
			if (n >= 2) result[2] = 2;
			if (n > 2) {
				for (int i = 3; i < result.length; i++) {
					result[i] = result[i - 1] + result[i - 2];
				}
			}
			return result[n];
		}

		//DP
		public int climbStairs2(int n) {
			if (n < 1) return 0;
			if (n == 1) return 1;
			if (n == 2) return 2;
			int a = 1;
			int b = 2;
			int temp = 0;
			for (int i = 3; i <= n; i++) {
				temp = b + a;
				a = b;
				b = temp;
			}
			return temp;
		}

		//递归  leetcode超时
		public int climbStairs1(int n) {
			int result = 0;
			if (n == 1) {
				return 1;
			}
			if (n == 2) {
				return 2;
			}
			result = climbStairs1(n - 2) + climbStairs1(n - 1);
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}