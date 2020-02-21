//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学

package leetcode.editor.cn;

//Java：2的幂
public class P231PowerOfTwo {
	public static void main(String[] args) {
		Solution solution = new P231PowerOfTwo().new Solution();
		System.out.println(solution.isPowerOfTwo(1));
		System.out.println(3 >> 1);
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		// public boolean isPowerOfTwo(int n) {
		// 	if (n <= 0) return false;
		// 	int result = n & (n - 1);
		// 	if (result == 0) {
		// 		return true;
		// 	} else {
		// 		return false;
		// 	}
		// }
		public boolean isPowerOfTwo(int n) {
			while (true) {
				if (n == 1) {
					return true;
				}
				if (n % 2 == 0) {
					n = n / 2;
				} else {
					return false;
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}