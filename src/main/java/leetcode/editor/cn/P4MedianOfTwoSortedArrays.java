//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package leetcode.editor.cn;

//Java：寻找两个有序数组的中位数
public class P4MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
		int[] arr1 = {1, 3};
		int[] arr2 = {2, 4};
		solution.findMedianSortedArrays(arr1, arr2);
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			if (nums1.length > nums2.length) {
				return findMedianSortedArrays(nums2, nums1);
			}
			int len = nums1.length + nums2.length;
			int cut1 = 0;   //nums1切割后左边数个数
			int cut2 = 0;   //nums2切割后左边数个数
			int cutL = 0;   //切割短的数组   用于二分切割
			int cutR = nums1.length;
			while (cut1 <= nums1.length) {
				cut1 = (cutR - cutL) / 2 + cutL;
				cut2 = len / 2 - cut1;
				double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
				double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
				double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
				double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
				if (L1 > R2) {
					cutR = cut1 - 1;
				} else if (R1 < L2) {
					cutL = cut1 + 1;
				} else {
					if (len % 2 == 0) {
						L1 = Math.max(L1, L2);
						R1 = Math.min(R1, R2);
						return (L1 + R1) / 2;
					} else {
						return Math.min(R1, R2);
					}
				}
			}
			return -1;
		}

		public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
			double d = 0.0;
			int[] result = new int[nums1.length + nums2.length];
			int i = 0;
			int j = 0;
			int resulti = 0;
			while (i < nums1.length || j < nums2.length) {
				if (i == nums1.length) {
					result[resulti++] = nums2[j++];
				} else if (j == nums2.length) {
					result[resulti++] = nums1[i++];
				} else if (nums1[i] < nums2[j]) {
					result[resulti++] = nums1[i++];
				} else if (nums1[i] >= nums2[j]) {
					result[resulti++] = nums2[j++];
				}
			}
			for (int k = 0; k < result.length; k++) {
				System.out.println(result[k] + " ");
			}
			if (result.length % 2 == 0) {
				d = ((result[result.length / 2 - 1] + result[result.length / 2]) / 2.0);
			} else {
				d = (double) result[(result.length - 1) / 2];
			}
			System.out.println("d-----" + d);
			return d;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}