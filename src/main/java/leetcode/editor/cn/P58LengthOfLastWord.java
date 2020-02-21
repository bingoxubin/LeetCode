//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串

package leetcode.editor.cn;

//Java：最后一个单词的长度
public class P58LengthOfLastWord {
	public static void main(String[] args) {
		Solution solution = new P58LengthOfLastWord().new Solution();
		System.out.println(solution.lengthOfLastWord("Hello World"));
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLastWord(String s) {
			int result = 0;
			s = s.trim();
			char[] temp = s.toCharArray();
			if (temp.length == 0) {
				return 0;
			}
			for (int i = temp.length - 1; i >= 0; i--) {
				if (s.charAt(i) != ' ') {
					result = result + 1;
				} else {
					break;
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}