//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		// Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
		// TreeNode node1 = new TreeNode(1);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node5 = new TreeNode(5);
		// TreeNode node6 = new TreeNode(6);
		// TreeNode node7 = new TreeNode(7);
		// TreeNode node8 = new TreeNode(8);
		// node1.left = node2;
		// node1.right = node3;
		// node2.left = node4;
		// node4.left = node5;
		// node4.right = node6;
		// node6.left = node7;
		// node6.right = node8;
		// solution.maxDepth1(node1);
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
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		//DFS
		public int maxDepth1(TreeNode root) {
			if (root == null) return 0;
			int left = maxDepth1(root.left);
			int right = maxDepth1(root.right);
			return Math.max(left, right) + 1;
		}

		//DFS
		public int maxDepth(TreeNode root) {
			return helper(root, 1);
		}

		int result = 0;

		public int helper(TreeNode root, int level) {
			if (root == null) return 0;
			helper(root.left, level + 1);
			helper(root.right, level + 1);
			result = Math.max(result, level);
			return result;
		}

		//BFS
		public int maxDepth2(TreeNode root) {
			if (root == null) return 0;
			int count = 0;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				count++;
				int size = queue.size();
				while (size > 0) {
					TreeNode temp = queue.poll();
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