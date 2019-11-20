package com.epoint.bigdata;

import java.util.HashMap;
import java.util.Map;

public class GetTwoDataSum {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 9};
		int target = 15;
		GetTwoDataSum gtds = new GetTwoDataSum();
		// 暴力法
		int[] arr1 = gtds.twoSumHash(nums, target);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		// 两遍Hash
		int[] arr2 = gtds.twoSumHash(nums, target);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		// 一遍Hash
		int[] arr3 = gtds.twoSumHash2(nums, target);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
	}

	// 暴力法
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// 两遍Hash
	public int[] twoSumHash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp) && map.get(temp) != i) {
				return new int[] { i, map.get(temp) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// 一遍Hash
	public int[] twoSumHash2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp)) {
				return new int[] { map.get(temp), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
