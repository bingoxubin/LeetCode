//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：相同的树
public class P100SameTree {
	public static void main(String[] args) {
		Solution solution = new P100SameTree().new Solution();
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
		public boolean isSameTree1(TreeNode p, TreeNode q) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(p);
			queue.add(q);//两个树的节点进队列
			while (!queue.isEmpty()) {
				TreeNode f = queue.poll();//出队列，如果队列头为空，返回null
				TreeNode s = queue.poll();
				if (f == null && s == null) continue;
				else if (f == null || s == null || f.val != s.val) return false;
				queue.add(f.left);
				queue.add(s.left);
				queue.add(f.right);
				queue.add(s.right);
			}
			return true;
		}

		//DFS
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if (p == null && q == null) return true;
			if (p == null || q == null) return false;
			if (p.val != q.val) return false;
			System.out.println("p:" + p.val + "===" + "q:" + q.val);
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}