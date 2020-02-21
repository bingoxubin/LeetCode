//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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

		public List<Integer> postorderTraversal1(TreeNode root) {
			if (root == null) return result;
			postorderTraversal1(root.left);
			postorderTraversal1(root.right);
			result.add(root.val);
			return result;
		}

		//BFS    Two Stack
		public List<Integer> postorderTraversal2(TreeNode root) {
			if (root == null) return result;
			Stack<TreeNode> stack1 = new Stack<TreeNode>();
			Stack<TreeNode> stack2 = new Stack<TreeNode>();
			stack1.push(root);
			while (!stack1.isEmpty()) {
				root = stack1.pop();
				stack2.push(root);
				if (root.left != null) stack1.push(root.left);
				if (root.right != null) stack1.push(root.right);
			}
			while (!stack2.isEmpty()) {
				result.add(stack2.pop().val);
			}
			return result;
		}

		//BFS    One Stack
		public List<Integer> postorderTraversal(TreeNode root) {
			if (root == null) return result;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			TreeNode c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && root != c.left && root != c.right) {
					stack.push(c.left);
				} else if (c.right != null && root != c.right) {
					stack.push(c.right);
				} else {
					result.add(stack.pop().val);
					root = c;
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}