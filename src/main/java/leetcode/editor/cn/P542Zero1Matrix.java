//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：01 矩阵
public class P542Zero1Matrix {
	public static void main(String[] args) {
		Solution solution = new P542Zero1Matrix().new Solution();
		int[][] arr = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
		int[][] result = solution.updateMatrix_2(arr);
		for (int i = 0; i < result.length; i++) {
			for (int i1 = 0; i1 < result[i].length; i1++) {
				System.out.print(result[i][i1] + " ");
			}
			System.out.println();
		}
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//TODO
		private int row;
		private int col;
		private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		/**
		 * DP（两次遍历，可 AC）
		 */
		public int[][] updateMatrix_1(int[][] matrix) {
			row = matrix.length;
			col = matrix[0].length;
			// 第一次遍历，正向遍历，根据相邻左元素和上元素得出当前元素的对应结果
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (matrix[i][j] == 1) {
						matrix[i][j] = row + col;
					}
					if (i > 0) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
					}
					if (j > 0) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
					}
				}
			}
			// 第二次遍历，反向遍历，根据相邻右元素和下元素及当前元素的结果得出最终结果
			for (int i = row - 1; i >= 0; i--) {
				for (int j = col - 1; j >= 0; j--) {
					if (i < row - 1) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
					}
					if (j < col - 1) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
					}
				}
			}
			return matrix;
		}

		/**
		 * BFS（迭代实现，可 AC）
		 */
		public int[][] updateMatrix_2(int[][] matrix) {
			row = matrix.length;
			col = matrix[0].length;
			Queue<int[]> queue = new LinkedList<>();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (matrix[i][j] == 0) {
						// 将所有 0 元素作为 BFS 第一层
						queue.add(new int[]{i, j});
					} else {
						matrix[i][j] = row + col;
					}
				}
			}
			while (!queue.isEmpty()) {
				int[] s = queue.poll();
				// 搜索上下左右四个方向
				for (int[] v : vector) {
					int r = s[0] + v[0], c = s[1] + v[1];
					if (r >= 0 && r < row
							&& c >= 0 && c < col
							&& matrix[r][c] > matrix[s[0]][s[1]] + 1) {
						matrix[r][c] = matrix[s[0]][s[1]] + 1;
						queue.add(new int[]{r, c});
					}
				}
			}
			return matrix;
		}

		/**
		 * DFS（递归实现，解答正确，但是会超时，下方是优化版）
		 */
		public int[][] updateMatrix_3(int[][] matrix) {
			row = matrix.length;
			col = matrix[0].length;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (matrix[i][j] == 1) {
						matrix[i][j] = row + col;
					}
				}
			}
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						updateMatrix(matrix, i, j);
					}
				}
			}
			return matrix;
		}

		/**
		 * DFS（递归实现，优化版，可 AC）
		 */
		public int[][] updateMatrix(int[][] matrix) {
			row = matrix.length;
			col = matrix[0].length;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					// 优化：如果元素在 0 附近，保留元素值 1，不在 0 附近，初始化为一个较大值
					if (matrix[i][j] == 1
							&& !((i > 0 && matrix[i - 1][j] == 0)
							|| (i < row - 1 && matrix[i + 1][j] == 0)
							|| (j > 0 && matrix[i][j - 1] == 0)
							|| (j < col - 1 && matrix[i][j + 1] == 0))) {
						matrix[i][j] = row + col;
					}
				}
			}
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					// 优化：将元素值为 1 的点作为深搜起点，降低递归深度
					if (matrix[i][j] == 1) {
						updateMatrix(matrix, i, j);
					}
				}
			}
			return matrix;
		}

		/**
		 * DFS 递归函数
		 */
		private void updateMatrix(int[][] matrix, int r, int c) {
			// 搜索上下左右四个方向
			for (int[] v : vector) {
				int nr = r + v[0], nc = c + v[1];
				if (nr >= 0 && nr < row && nc >= 0 && nc < col && matrix[nr][nc] > matrix[r][c] + 1) {
					matrix[nr][nc] = matrix[r][c] + 1;
					updateMatrix(matrix, nr, nc);
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}