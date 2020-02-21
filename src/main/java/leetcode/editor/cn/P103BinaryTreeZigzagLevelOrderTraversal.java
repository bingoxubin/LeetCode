//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的锯齿形层次遍历
public class P103BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			if (root == null) return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			int index = 1;
			while (!queue.isEmpty()) {
				List<Integer> list = new ArrayList<Integer>();
				int size = queue.size();
				while (size > 0) {
					TreeNode node = queue.poll();
					if ((index & 1) == 1) list.add(node.val);
					if ((index & 1) == 0) list.add(0, node.val);
					if (node.left != null) queue.add(node.left);
					if (node.right != null) queue.add(node.right);
					size--;
				}
				result.add(list);
				index++;
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}