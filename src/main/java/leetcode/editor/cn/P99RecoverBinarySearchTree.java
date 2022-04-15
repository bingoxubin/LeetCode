//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：恢复二叉搜索树
public class P99RecoverBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new P99RecoverBinarySearchTree().new Solution();
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

	//递归中序遍历
	class Solution {
		TreeNode x = null, y = null, pred = null;

		public void swap(TreeNode a, TreeNode b) {
			int tmp = a.val;
			a.val = b.val;
			b.val = tmp;
		}

		public void findTwoSwapped(TreeNode root) {
			if (root == null) return;
			findTwoSwapped(root.left);
			if (pred != null && root.val < pred.val) {
				y = root;
				if (x == null) x = pred;
				else return;
			}
			pred = root;
			findTwoSwapped(root.right);
		}

		public void recoverTree(TreeNode root) {
			findTwoSwapped(root);
			swap(x, y);
		}
	}

	//迭代中序遍历
	class Solution1 {
		public void swap(TreeNode a, TreeNode b) {
			int tmp = a.val;
			a.val = b.val;
			b.val = tmp;
		}

		public void recoverTree(TreeNode root) {
			Deque<TreeNode> stack = new ArrayDeque();
			TreeNode x = null, y = null, pred = null;

			while (!stack.isEmpty() || root != null) {
				while (root != null) {
					stack.add(root);
					root = root.left;
				}
				root = stack.removeLast();
				if (pred != null && root.val < pred.val) {
					y = root;
					if (x == null) x = pred;
					else break;
				}
				pred = root;
				root = root.right;
			}

			swap(x, y);
		}
	}

	//Morris中序遍历
	class Solution2 {
		public void swap(TreeNode a, TreeNode b) {
			int tmp = a.val;
			a.val = b.val;
			b.val = tmp;
		}

		public void recoverTree(TreeNode root) {
			// predecessor is a Morris predecessor.
			// In the 'loop' cases it could be equal to the node itself predecessor == root.
			// pred is a 'true' predecessor,
			// the previous node in the inorder traversal.
			TreeNode x = null, y = null, pred = null, predecessor = null;

			while (root != null) {
				// If there is a left child
				// then compute the predecessor.
				// If there is no link predecessor.right = root --> set it.
				// If there is a link predecessor.right = root --> break it.
				if (root.left != null) {
					// Predecessor node is one step left
					// and then right till you can.
					predecessor = root.left;
					while (predecessor.right != null && predecessor.right != root)
						predecessor = predecessor.right;

					// set link predecessor.right = root
					// and go to explore left subtree
					if (predecessor.right == null) {
						predecessor.right = root;
						root = root.left;
					}
					// break link predecessor.right = root
					// link is broken : time to change subtree and go right
					else {
						// check for the swapped nodes
						if (pred != null && root.val < pred.val) {
							y = root;
							if (x == null) x = pred;
						}
						pred = root;

						predecessor.right = null;
						root = root.right;
					}
				}
				// If there is no left child
				// then just go right.
				else {
					// check for the swapped nodes
					if (pred != null && root.val < pred.val) {
						y = root;
						if (x == null) x = pred;
					}
					pred = root;

					root = root.right;
				}
			}
			swap(x, y);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}