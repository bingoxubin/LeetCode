package bingoabin.algorithm.demo;

/**
 * @author bingoabin
 * @date 2020/4/14 17:31
 */
public class _01arraylisttree {
	//遍历数组
	void traverseArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

		}
	}

	//遍历链表
	class ListNode {
		int val;
		ListNode next;
	}

	void traverseListItreator(ListNode head) {
		for (ListNode p = head; p.next != null; p = p.next) {

		}
	}

	void traverseListRecursion(ListNode head) {
		traverseListRecursion(head.next);
	}

	//二叉树遍历
	class TreeNode {
		int val;
		TreeNode left, right;
	}

	void traverseTreeRecursion(TreeNode head) {
		traverseTreeRecursion(head.left);
		traverseTreeRecursion(head.right);
	}

	//多叉树遍历  演化为图
	class GraphNode {
		int val;
		GraphNode[] child;
	}

	void traverseGraphRecursion(GraphNode head) {
		for (GraphNode temp : head.child) {
			traverseGraphRecursion(temp);
		}
	}
}
