package sort.demo.com;

/**
 * @author xumaosheng
 * @date 2019/9/25 16:41
 */
public class _01SelectSort {
	public static void main(String[] args) {
		Solution solution = new _01SelectSort().new Solution();
		int[] arr = {4, 29, 6, 5, 2, 9, 43, 23};
		int[] arr1 = solution.selectSort(arr);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	public class Solution {
		public int[] selectSort(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				int index = i;
				for (int j = i; j < arr.length; j++) {
					index = arr[j] < arr[index] ? j : index;
				}
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
			return arr;
		}
	}
}
