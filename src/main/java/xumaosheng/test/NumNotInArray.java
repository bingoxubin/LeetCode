package xumaosheng.test;

/**
 * @author xumaosheng
 * @date 2019/9/25 15:03
 */
public class NumNotInArray {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 5, 6, 8, 9};
		int[] arr1 = {0, 2, 5, 7, 9, 10};
		Solution solution = new NumNotInArray().new Solution();
		int[] arr2 = solution.numNotInArray(arr, arr1);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}

	public class Solution {
		public int[] numNotInArray(int[] arr, int[] arr1) {
			int[] result = new int[13];
			int i = 0, j = 0, k = 0;
			while (i < arr.length && j < arr1.length) {
				if (arr[i] == arr1[j]) {
					i++;
					j++;
				} else if (arr[i] > arr1[j]) {
					j++;
					result[k++] = arr1[j];
				} else if (arr[i] < arr1[j]) {
					i++;
					result[k++] = arr1[j];
				}
			}
			return result;
		}
	}
}
