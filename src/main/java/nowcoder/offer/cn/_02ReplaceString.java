//替换空格
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/9 19:04
 */
public class _02ReplaceString {
	public static void main(String[] args) {
		Solution solution = new _02ReplaceString().new Solution();
		StringBuffer str = new StringBuffer("We Are Happy");
		String result = solution.replaceSpace(str);
		System.out.println(result);
	}

	public class Solution {
		public String replaceSpace(StringBuffer str) {
			String str1;
			char[] cr = new String(str).toCharArray();
			String result = "";
			for (int i = 0; i < cr.length; i++) {
				String temp = String.valueOf(cr[i]);
				if (" ".equals(temp)) {
					result += "%20";
				} else {
					result += temp;
				}
			}
			return result;
		}
	}

}
