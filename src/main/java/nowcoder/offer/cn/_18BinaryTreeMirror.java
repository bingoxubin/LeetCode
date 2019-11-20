//二叉树的镜像
//操作给定的二叉树，将其变换为源二叉树的镜像。

//思路：
//      二叉树的镜像定义：源二叉树
// 		8
// 		/  \
// 		6   10
// 		/ \  / \
// 		5  7 9 11
// 		镜像二叉树
// 		8
// 		/  \
// 		10   6
// 		/ \  / \
// 		11 9 7  5
//
// 		当树不为空时，交换其左孩子和右孩子，并对他们的左孩子和右孩子也做同样的处理。

package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/9 23:14
 */
public class _18BinaryTreeMirror {

	public static void main(String[] args) {
		//TODO
	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		public void Mirror(TreeNode root) {
			TreeNode temp;
			if (root != null) {
				temp = root.left;
				root.left = root.right;
				root.right = temp;
				Mirror(root.left);
				Mirror(root.right);
			}
		}
	}
}
