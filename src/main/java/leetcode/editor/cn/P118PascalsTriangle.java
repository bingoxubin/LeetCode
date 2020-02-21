//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角
public class P118PascalsTriangle {
	public static void main(String[] args) {
		Solution solution = new P118PascalsTriangle().new Solution();
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> generate(int numRows) {
			//[
			//     [1],
			//    [1,1],
			//   [1,2,1],
			//  [1,3,3,1],
			// [1,4,6,4,1]
			//]
			List<List<Integer>> result = new ArrayList<>();
			if (numRows < 1) return result;
			List<Integer> list = new ArrayList<>();
			list.add(1);
			result.add(list);
			for (int i = 2; i <= numRows; i++) { //3
				List<Integer> temp = new ArrayList<>();
				temp.add(1);
				List<Integer> mid = result.get(i - 2);  //[1,1]
				for (int j = 1; j < i - 1; j++) {
					temp.add(mid.get(j - 1) + mid.get(j));
				}
				temp.add(1);
				result.add(temp);
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}