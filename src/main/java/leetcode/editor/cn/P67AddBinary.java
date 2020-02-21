//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串

package leetcode.editor.cn;

//Java：二进制求和
public class P67AddBinary {
	public static void main(String[] args) {
		Solution solution = new P67AddBinary().new Solution();
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		// public String addBinary(String a, String b) {
		// 	int alen = a.length() - 1;
		// 	int blen = b.length() - 1;
		// 	StringBuilder result = new StringBuilder();
		// 	int temp = 0;
		// 	while (alen >= 0 || blen >= 0) {
		// 		int sum = temp;
		// 		if (alen >= 0) {
		// 			sum = sum + a.charAt(alen) - '0';
		// 			alen--;
		// 		}
		// 		if (blen >= 0) {
		// 			sum = sum + b.charAt(blen) - '0';
		// 			blen--;
		// 		}
		// 		result.append(sum % 2);
		// 		temp = sum / 2;
		// 	}
		// 	if (temp == 1) {
		// 		result.append(1);
		// 	}
		// 	return result.reverse().toString();
		// }
		public String addBinary(String a, String b) {
			char[] arra = a.toCharArray();
			char[] arrb = b.toCharArray();
			int lena = arra.length - 1;
			int lenb = arrb.length - 1;
			StringBuilder result = new StringBuilder();
			int temp = 0;
			int sum = 0;
			while (lena > 0 || lenb > 0) {
				if (lena > 0) {
					temp = sum + arra[lena] - '0';
					lena--;
				}
				if (lenb > 0) {
					temp = sum + arrb[lenb] - '0';
					lenb--;
				}
				result.append(temp % 2);
				sum = temp / 2;
			}
			if (sum == 1) {
				result.append(1);
			}
			return result.reverse().toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}