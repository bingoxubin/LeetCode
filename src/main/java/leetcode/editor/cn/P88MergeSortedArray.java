//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;

//Java：合并两个有序数组
public class P88MergeSortedArray {
	public static void main(String[] args) {
		Solution solution = new P88MergeSortedArray().new Solution();
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
		solution.merge(nums1, 3, nums2, 3);
		for (int i : nums1) {
			System.out.print(i + " ");
		}
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//从后往前
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int ml = m - 1;
			int nl = n - 1;
			int len = m + n - 1;
			while (len >= 0) {
				if (ml < 0) {
					nums1[len--] = nums2[nl--];
				} else if (nl < 0) {
					nums1[len--] = nums1[ml--];
				} else if (nums1[ml] > nums2[nl]) {
					nums1[len--] = nums1[ml--];
				} else if (nums1[ml] <= nums2[nl]) {
					nums1[len--] = nums2[nl--];
				}
			}
		}

		//比较容易想到，用一个辅助数组
		public void merge1(int[] nums1, int m, int[] nums2, int n) {
			int[] result = new int[nums1.length];
			int temp = 0;
			int i = 0;
			int j = 0;
			while (i < m && j < n) {
				if (nums1[i] < nums2[j]) {
					result[temp++] = nums1[i++];
				} else {
					result[temp++] = nums2[j++];
				}
			}
			if (i == m) {
				while (j < n) {
					result[temp++] = nums2[j++];
				}
			}
			if (j == n) {
				while (i < m) {
					result[temp++] = nums1[i++];
				}
			}
			for (int i1 = 0; i1 < result.length; i1++) {
				nums1[i1] = result[i1];
			}
		}
//leetcode submit region end(Prohibit modification and deletion)
	}
}