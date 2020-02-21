//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：对称二叉树
public class P101SymmetricTree {
	public static void main(String[] args) {
		Solution solution = new P101SymmetricTree().new Solution();
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
		public boolean isSymmetric(TreeNode root) {
			return helper(root, root);
		}

		public boolean helper(TreeNode rootleft, TreeNode rootright) {
			if (rootleft == null && rootright == null) return true;
			if (rootleft == null || rootright == null) return false;
			if (rootleft.val != rootright.val) return false;
			return helper(rootleft.left, rootright.right) && helper(rootleft.right, rootright.left);
		}

		//BFS
		public boolean isSymmetric1(TreeNode root) {
			List<TreeNode> result = new LinkedList<>();
			result.add(root);
			result.add(root);
			while (!result.isEmpty()) {
				TreeNode node1 = result.remove(0);
				TreeNode node2 = result.remove(0);
				if (node1 == null && node2 == null) continue;
				if (node1 == null || node2 == null) return false;
				if (node1.val != node2.val) return false;
				result.add(node1.left);
				result.add(node2.right);
				result.add(node1.right);
				result.add(node2.left);
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}