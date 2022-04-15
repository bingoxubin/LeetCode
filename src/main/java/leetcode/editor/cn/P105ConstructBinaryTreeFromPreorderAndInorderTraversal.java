//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

package leetcode.editor.cn;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		}

		private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
			if (pStart > pEnd || iStart > iEnd) return null;

			TreeNode treeNode = new TreeNode(preorder[pStart]);
			int index = 0;
			while (inorder[iStart + index] != preorder[pStart]) {
				index++;
			}
			treeNode.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
			treeNode.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
			return treeNode;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}