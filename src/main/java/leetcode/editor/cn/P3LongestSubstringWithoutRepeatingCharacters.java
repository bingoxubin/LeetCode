//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			HashMap<Character, Integer> hm = new HashMap<>();
			int result = 0;
			for (int i = 0, j = 0; j < s.length(); j++) {
				if (hm.containsKey(s.charAt(j))) {
					i = Math.max(hm.get(s.charAt(j)), i);
				}
				result = Math.max(result, j - i + 1);
				hm.put(s.charAt(j), j + 1);
			}
			return result;
		}

		public int lengthOfLongestSubstring1(String s) {
			int n = s.length();
			int res = 0;//记录最长子串的长度
			int end = 0, start = 0;//记录开始和结尾的下标
			Set<Character> set = new HashSet<>();//使用set容器不重复
			while (start < n && end < n) {
				if (set.contains(s.charAt(end))) {//如果窗口右侧的字符已经存在
					set.remove(s.charAt(start++));//左侧窗口边界向右
				} else {
					set.add(s.charAt(end++));//如果窗口中无重复，窗口右侧向右滑动
					res = Math.max(res, end - start);//同时记录当前最大长度
				}
			}
			return res;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)
}