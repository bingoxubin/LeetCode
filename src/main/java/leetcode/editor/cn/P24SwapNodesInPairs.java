//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表

package leetcode.editor.cn;

//Java：两两交换链表中的节点
public class P24SwapNodesInPairs {
	public static void main(String[] args) {
		Solution solution = new P24SwapNodesInPairs().new Solution();
		// TO TEST
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */

	class Solution {
		public ListNode swapPairs(ListNode head) {
			if (head == null || head.next == null) return head;
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode result = dummy;
			while (result.next != null && result.next.next != null) {
				ListNode first = result.next;
				ListNode second = result.next.next;
				result.next = second;
				first.next = second.next;
				second.next = first;
				result = first;
			}
			return dummy.next;
		}

		public ListNode swapPairs1(ListNode head) {
			if (head == null || head.next == null) return head;
			ListNode first = head;
			ListNode second = head.next;
			first.next = swapPairs(second.next);
			second.next = first;
			return second;
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}