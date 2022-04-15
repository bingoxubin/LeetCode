//小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下： 
//
// 
// 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0 
// 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。 
// 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人 
// 
//
// 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号
//为 n-1 的小伙伴处的方案数；若不能到达，返回 0。 
//
// 示例 1： 
//
// 
// 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3 
//
// 输出：3 
//
// 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->
//3->4。 
// 
//
// 示例 2： 
//
// 
// 输入：n = 3, relation = [[0,2],[2,1]], k = 2 
//
// 输出：0 
//
// 解释：信息不能从小 A 处经过 2 轮传递到编号 2 
// 
//
// 限制： 
//
// 
// 2 <= n <= 10 
// 1 <= k <= 5 
// 1 <= relation.length <= 90, 且 relation[i].length == 2 
// 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1] 
// 
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//Java：传递信息
public class PLCP_07ChuanDiXinXi {
	public static void main(String[] args) {
		Solution solution = new PLCP_07ChuanDiXinXi().new Solution();
		// TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		int res = 0;

		public int numWays(int n, int[][] relation, int k) {
			HashMap<Integer, ArrayList<Integer>> map = new HashMap();
			for (int[] num : relation) {
				if (!map.containsKey(num[0])) map.put(num[0], new ArrayList<Integer>());
				map.get(num[0]).add(num[1]);
			}
			dfs(map, n, k, 0);
			return res;
		}

		public void dfs(HashMap<Integer, ArrayList<Integer>> map, int n, int k, int cur) {
			if (k < 0) return;
			if (k == 0 && cur == n - 1) {
				res++;
				return;
			}
			ArrayList<Integer> list = map.get(cur);
			if (list == null) return;
			for (Integer i : list) {
				dfs(map, n, k - 1, i);
			}
		}

		public int numWays1(int n, int[][] relation, int k) {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(0);
			while (!queue.isEmpty() && k > 0) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int num = queue.poll();
					for (int j = 0; j < relation.length; j++) {
						if (relation[j][0] == num) {
							queue.offer(relation[j][1]);
						}
					}
				}
				k--;
			}
			if (k > 0) return 0;
			int res = 0;
			while (!queue.isEmpty()) {
				res += queue.poll() == n - 1 ? 1 : 0;
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}