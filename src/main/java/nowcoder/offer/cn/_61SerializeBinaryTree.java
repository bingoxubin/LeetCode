//序列化二叉树

package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/10 1:16
 */
public class _61SerializeBinaryTree {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	/*
		思路：
			序列化：前序遍历，若节点为空则输出“#”，节点之间用“，”隔开。
			反序列化：反之。
	*/
	public class Solution {
		int index = -1;

		String Serialize(TreeNode root) {
			StringBuffer sb = new StringBuffer();
			if (root == null) {
				sb.append("#,");
				return sb.toString();
			}
			sb.append(root.val + ",");
			sb.append(Serialize(root.left));
			sb.append(Serialize(root.right));
			return sb.toString();
		}

		TreeNode Deserialize(String str) {
			if (str == null) {
				return null;
			}
			index++;
			String[] splits = str.split(",");
			TreeNode root = null;
			if (!splits[index].equals("#")) {
				root = new TreeNode(Integer.valueOf(splits[index]));
				root.left = Deserialize(str);
				root.right = Deserialize(str);
			}
			return root;
		}
	}
}
