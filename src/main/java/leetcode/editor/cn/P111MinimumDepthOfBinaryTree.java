//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
		// TO TEST
	}

//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		//DFS
		public int minDepth1(TreeNode root) {
			if (root == null) return 0;
			int left = minDepth1(root.left);
			int right = minDepth1(root.right);
			return (root.left == null || root.right == null) ? left + right + 1 : Math.min(left, right) + 1;
		}

		//BFS
		public int minDepth2(TreeNode root) {
			if (root == null) return 0;
			int count = 0;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				count++;
				int size = queue.size();
				while (size > 0) {
					TreeNode temp = queue.poll();
					if (temp.left == null && temp.right == null) {
						queue.clear();
						break;
					}
					if (temp.left != null) queue.add(temp.left);
					if (temp.right != null) queue.add(temp.right);
					size--;
				}
			}
			return count;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}