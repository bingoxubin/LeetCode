//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层次遍历
public class P102BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
		//BFS
		public List<List<Integer>> levelOrder1(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null) return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> temp = new ArrayList<Integer>();
				while (size > 0) {
					TreeNode tempnode = queue.poll();
					temp.add(tempnode.val);
					if (tempnode.left != null) queue.add(tempnode.left);
					if (tempnode.right != null) queue.add(tempnode.right);
					size--;
				}
				result.add(temp);
			}
			return result;
		}

		//DFS
		List<List<Integer>> value = new ArrayList<List<Integer>>();

		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null) return value;
			helper(root, 0);
			return value;
		}

		public void helper(TreeNode root, int level) {
			if (value.size() == level) value.add(new ArrayList<Integer>());
			value.get(level).add(root.val);
			if (root.left != null) helper(root.left, level + 1);
			if (root.right != null) helper(root.right, level + 1);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}