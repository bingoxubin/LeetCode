//字符流中第一个不重复的字符

package nowcoder.offer.cn;

import java.util.ArrayList;

/**
 * @author xumaosheng
 * @date 2019/9/10 1:07
 */
public class _54FirstNotRepeatChar {

	public class Solution {
		ArrayList<Character> list = new ArrayList<Character>();
		int[] hashTime = new int[256];

		//Insert one char from stringstream
		public void Insert(char ch) {
			hashTime[ch]++;
			list.add(ch);
		}

		//return the first appearence once char in current stringstream
		public char FirstAppearingOnce() {
			for (int i = 0; i < list.size(); i++) {
				if (hashTime[list.get(i)] == 1) {
					return list.get(i);
				}
			}
			return '#';
		}
	}
}
