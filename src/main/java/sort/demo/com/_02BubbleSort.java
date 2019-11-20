package sort.demo.com;

/**
 * @author xumaosheng
 * @date 2019/9/25 16:25
 */
public class _02BubbleSort {
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 8, 6, 4, 1, 0};
		Solution solution = new _02BubbleSort().new Solution();
		int[] arr1 = solution.bubbleSort(arr);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	public class Solution {
		public int[] bubbleSort(int[] arr) {
			for (int end = arr.length - 1; end > 0; end--) {
				for (int i = 0; i < end; i++) {
					if (arr[i] > arr[i + 1]) {
						int temp = arr[i + 1];
						arr[i + 1] = arr[i];
						arr[i] = temp;
					}
				}
			}
			return arr;
		}
	}
}
