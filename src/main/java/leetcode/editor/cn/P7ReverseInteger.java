//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

package leetcode.editor.cn;

//Java：整数反转
public class P7ReverseInteger {
	public static void main(String[] args) {
		Solution solution = new P7ReverseInteger().new Solution();
		// TO TEST
		System.out.println(solution.reverse(1463847412));
		System.out.println(solution.reverse(2147483647));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int reverse(int x) {
			int result = 0;
			while (x != 0) {
				int pop = x % 10;
				x = x / 10;//-2147483648 ~ 2147483647
				if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && pop > 7)) return 0;
				if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && pop < -8)) return 0;
				result = result * 10 + pop;
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}