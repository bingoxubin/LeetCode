package sort.demo.com;

/**
 * @author xumaosheng
 * @date 2019/10/4 15:15
 */
// 最好情况  O(n)
// 最坏情况  O(n2)
public class _03InsertSort {
	public static void main(String[] args) {
		int[] arr = {5, 2, 0, 7, 9, 8, 4, 1, 3};
		Solution solution = new _03InsertSort().new Solution();
		int[] arr1 = solution.insertSort(arr);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	public class Solution {
		public int[] insertSort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (arr[j] > arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
			return arr;
		}
	}
}
