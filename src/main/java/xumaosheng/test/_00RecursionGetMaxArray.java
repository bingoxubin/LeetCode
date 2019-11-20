package xumaosheng.test;

/**
 * @author xumaosheng
 * @date 2019/10/5 1:05
 */
public class _00RecursionGetMaxArray {
	public static int getMax(int[] arr, int left, int right) {
		if (left == right) {
			return arr[left];
		}

		int middle = (left + right) / 2;
		int maxleft = getMax(arr, left, middle);
		int maxright = getMax(arr, middle + 1, right);
		return Math.max(maxleft, maxright);
	}

	public static void main(String[] args) {
		int[] arr = {4, 2, 3, 4, 5, 6, 7, 8, 4, 2, 19, 10};
		System.out.println(getMax(arr, 0, arr.length - 1));
	}
}
