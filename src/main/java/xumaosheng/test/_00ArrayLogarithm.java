package xumaosheng.test;

import sort.demo.com._02BubbleSort;

import java.util.Arrays;

/**
 * @author xumaosheng
 * @date 2019/10/4 15:56
 */
public class _00ArrayLogarithm {
	//随机产生一个随机数组
	public static int[] generateRandomArray(int size, int value) {
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((value + 1) * Math.random());
		}
		return arr;
	}

	//正确的方法
	public static void rightMethod(int[] arr) {
		Arrays.sort(arr);
	}

	//拷贝数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	//判断是否相等
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null) && (arr2 != null) || (arr1 != null) && (arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	//打印数组
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	//主方法
	public static void main(String[] args) {
		int testTime = 500000;
		int size = 10;
		int value = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(size, value);
			int[] arr2 = copyArray(arr1);
			int[] arr3 = copyArray(arr1);
			new _02BubbleSort().new Solution().bubbleSort(arr1);
			rightMethod(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr3);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking Fucked!");
	}

}
