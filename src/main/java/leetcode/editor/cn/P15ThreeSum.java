//给定一个包含 n 个整数的数组 ，判断  中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组  = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
	public static void main(String[] args) {
		Solution solution = new P15ThreeSum().new Solution();
		// TO TEST
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(solution.threeSum(nums));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			Arrays.sort(nums);
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < nums.length - 2; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) continue;
				int pre = i + 1;
				int last = nums.length - 1;
				int sum = -nums[i];
				while (pre < last) {
					if (nums[pre] + nums[last] == sum) {
						result.add(Arrays.asList(nums[i], nums[pre], nums[last]));
						while (pre < last && nums[pre] == nums[pre + 1]) pre++;
						while (pre < last && nums[last] == nums[last - 1]) last--;
						pre++;
						last--;
					} else if (nums[pre] + nums[last] < sum) {
						pre++;
					} else {
						last--;
					}
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}