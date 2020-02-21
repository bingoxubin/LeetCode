//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。 
//
// 注意：整数顺序将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
// 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
// 
// Related Topics 字符串

package leetcode.editor.cn;

//Java：报数
public class P38CountAndSay {
	public static void main(String[] args) {
		Solution solution = new P38CountAndSay().new Solution();
		// TO TEST
		System.out.println(solution.countAndSay(5));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String countAndSay(int n) {
			String result = "";
			if (n == 1) {
				return "1";
			}
			result = countAndSay(n - 1) + "*";
			System.out.println(result);
			StringBuilder sb = new StringBuilder();
			char[] temp = result.toCharArray();
			int count = 1;
			for (int i = 0; i < temp.length - 1; i++) {
				if (temp[i] == temp[i + 1]) {
					count++;
				} else {
					sb.append("" + count + temp[i]);
					count = 1;
				}
			}
			return sb.toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}