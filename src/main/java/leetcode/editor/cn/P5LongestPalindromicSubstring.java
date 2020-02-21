//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
	public static void main(String[] args) {
		Solution solution = new P5LongestPalindromicSubstring().new Solution();
		// TO TEST
		solution.longestPalindrome("babad");
		System.out.println("babad".substring(0, 3));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//babad   ^#b#a#b#a#d#$
		public String longestPalindrome(String s) {
			StringBuilder sb = new StringBuilder("^");
			for (int i = 0; i < s.length(); i++) {
				sb.append("#").append(s.charAt(i));
			}
			sb.append("#&");

			int c = 0;
			int r = 0;
			int centerPoint = 0;
			int maxlen = 0;
			int[] p = new int[sb.length()];
			for (int i = 1; i < sb.length() - 1; i++) {
				p[i] = r > i ? Math.min(r - i, p[2 * c - i]) : 0;

				while (sb.charAt(i - 1 - p[i]) == sb.charAt(i + 1 + p[i])) {
					p[i]++;
				}

				if (r < i + p[i]) {
					c = i;
					r = i + p[i];
				}

				if (p[i] > maxlen) {
					maxlen = p[i];
					centerPoint = i;
				}
			}

			int beginIndex = (centerPoint - maxlen - 1) / 2;
			return s.substring(beginIndex, beginIndex + maxlen);

			// // 改造字符串，每个字符间添加#。添加头^尾$两个不同的字符用于消除边界判断
			// StringBuilder sb = new StringBuilder("^");
			// for (int i = 0, len = s.length(); i < len; i++)
			// 	sb.append("#").append(s.charAt(i));
			// sb.append("#$");
			//
			// //  ^#b#a#b#a#d#$
			// // [0010303010100]  i=6 c=6 r=9  i=7 c=6 r=9
			// // c:回文中心   r:回文子串右边到达的地方    centerIndex:p[i]中最大值的i      maxLen:p[i]中最大的值
			// int c = 0, r = 0, len = sb.length(), centerIndex = 0, maxLen = 0;
			// int[] p = new int[len];
			//
			// for (int i = 1; i < len - 1; i++) {
			// 	p[i] = r > i ? Math.min(r - i, p[2 * c - i]) : 0;
			//
			// 	// 基于当前点为中心扩展寻找回文
			// 	while (sb.charAt(i - 1 - p[i]) == sb.charAt(i + 1 + p[i]))
			// 		p[i]++;
			//
			// 	// 如果扩展后的右边界值大于当前右边界值则更新
			// 	if (i + p[i] > r) {
			// 		c = i;
			// 		r = i + p[i];
			// 	}
			//
			// 	// 寻找最大值与中心点
			// 	if (p[i] > maxLen) {
			// 		maxLen = p[i];
			// 		centerIndex = i;
			// 	}
			// }
			//
			// int beginIndex = (centerIndex - 1 - maxLen) / 2;
			// return s.substring(beginIndex, beginIndex + maxLen);
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}