//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package leetcode.editor.cn;

import java.util.HashMap;

//Java：两数之和
public class P1TwoSum {
	public static void main(String[] args) {
		Solution solution = new P1TwoSum().new Solution();
		// TO TEST
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] ret = solution.twoSum(nums, target);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(i + " ");
		}
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			if (nums.length < 2 || nums == null) {
				return new int[]{-1, -1};
			}
			int[] ret = new int[]{-1, -1};
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (hm.containsKey(target - nums[i])) {
					ret[0] = hm.get(target - nums[i]);
					ret[1] = i;
					break;
				}
				hm.put(nums[i], i);
			}
			return ret;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}