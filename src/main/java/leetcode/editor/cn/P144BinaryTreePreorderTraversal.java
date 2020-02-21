//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的前序遍历
public class P144BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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

		public List<Integer> preorderTraversal1(TreeNode root) {
			if (root == null) return result;
			result.add(root.val);
			preorderTraversal1(root.left);
			preorderTraversal1(root.right);
			return result;
		}

		//BFS
		public List<Integer> preorderTraversal(TreeNode root) {
			if (root == null) return result;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode temp = stack.pop();
				result.add(temp.val);
				if (temp.right != null) stack.push(temp.right);
				if (temp.left != null) stack.push(temp.left);
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}