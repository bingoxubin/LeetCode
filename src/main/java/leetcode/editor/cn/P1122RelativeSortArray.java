//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

//Java：数组的相对排序
public class P1122RelativeSortArray {
	public static void main(String[] args) {
		Solution solution = new P1122RelativeSortArray().new Solution();
		int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
		int[] arr2 = {2, 1, 4, 3, 9, 6};
		int[] result = solution.relativeSortArray(arr1, arr2);
		for (int i : result) {
			System.out.print(i + " ");
		}
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] relativeSortArray(int[] arr1, int[] arr2) {
			int[] result = new int[arr1.length];
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < arr1.length; i++) {
				if (map.containsKey(arr1[i])) {
					map.put(arr1[i], map.get(arr1[i]) + 1);
				} else {
					map.put(arr1[i], 1);
				}
			}
			int index = 0;
			for (int j = 0; j < arr2.length; j++) {
				if (map.containsKey(arr2[j])) {
					int temp = map.get(arr2[j]);
					while (temp > 0) {
						result[index++] = arr2[j];
						temp--;
					}
					map.put(arr2[j], 0);
				}
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int value : map.keySet()) {
				if (map.get(value) != 0) {
					list.add(value);
				}
			}
			//test
			Iterator<Integer> iterator = list.iterator();
			while(iterator.hasNext()){
				System.out.print(iterator.next()+" ");
			}
			System.out.println();

			Collections.sort(list);
			for (int k = 0; k < list.size(); k++) {
				if (map.containsKey(list.get(k))) {
					int temp = map.get(list.get(k));
					while (temp > 0) {
						result[index++] = list.get(k);
						temp--;
					}
					map.put(list.get(k), 0);
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}