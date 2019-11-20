//二维数组中的查找
// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

//思路：
// 从二维数组的左下角开始遍历：
//
// 若查找的目标值小于当前遍历值，则向上查找；
//
// 若查找的目标值大于当前遍历值，则向右查找；
//
// 若命中，则返回true;
//
// 若遍历完还没找到，返回false。

package nowcoder.offer.cn;

import java.util.Arrays;

/**
 * @author xumaosheng
 * @date 2019/9/9 19:04
 */
public class _01FindInDoubleArray {
	public static void main(String[] args) {
		Solution1 solution1 = new _01FindInDoubleArray().new Solution1();
		Solution2 solution2 = new _01FindInDoubleArray().new Solution2();
		int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}};
		int target = 8;
		boolean out1 = solution1.Find(target, nums);
		System.out.println(out1);
		boolean out2 = solution2.Find(target, nums);
		System.out.println(out2);
	}

	public class Solution1 {
		public boolean Find(int target, int[][] array) {
			int x = array.length - 1;
			int y = 0;
			while (x >= 0 && y <= array[0].length - 1) {
				if (target < array[x][y]) {
					x--;
				} else if (target > array[x][y]) {
					y++;
				} else {
					return true;
				}
			}
			return false;
		}
	}

	public class Solution2 {
		public boolean Find(int target, int[][] array) {
			int x = 0;
			int y = array[0].length - 1;
			while (x < array.length && y > -1) {
				if (target > array[x][y]) {
					x++;
				} else if (target < array[x][y]) {
					y--;
				} else {
					return true;
				}
			}
			return false;
		}
	}

}
