//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串

package leetcode.editor.cn;

//Java：Z 字形变换
public class P6ZigzagConversion {
	public static void main(String[] args) {
		Solution solution = new P6ZigzagConversion().new Solution();
		// TO TEST
		String leetcodeishiring = solution.convert("LEETCODEISHIRING", 4);
		System.out.println(leetcodeishiring);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String convert(String s, int numRows) {
			char[][] arr = new char[numRows][s.length()];
			StringBuilder sb = new StringBuilder();
			int index = 0;
			int col = 0;
			int row = 0;
			if (s.length() <= 2 || numRows == 1) {
				return s;
			}
			while (index < s.length()) {
				while (row < numRows && index < s.length()) {
					arr[row++][col] = s.charAt(index++);
				}
				row--;
				while (row > 0 && index < s.length()) {
					arr[--row][++col] = s.charAt(index++);
				}
				row++;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] != '\u0000') {
						sb.append(arr[i][j]);
					}
				}
			}

			return sb.toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}