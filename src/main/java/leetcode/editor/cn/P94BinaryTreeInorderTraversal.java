//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
		List<Integer> result = new ArrayList<Integer>();

		public List<Integer> inorderTraversal1(TreeNode root) {
			if (root == null) return result;
			inorderTraversal1(root.left);
			result.add(root.val);
			inorderTraversal1(root.right);
			return result;
		}

		//BFS
		public List<Integer> inorderTraversal(TreeNode root) {
			if (root == null) return result;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					result.add(root.val);
					root = root.right;
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}