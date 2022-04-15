//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package leetcode.editor.cn;

//Java：反转链表 II
public class P92ReverseLinkedListIi {
	public static void main(String[] args) {
		Solution solution = new P92ReverseLinkedListIi().new Solution();
		// TO TEST
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			ListNode result = new ListNode(-1);
			result.next = head;
			ListNode pre = result;
			ListNode cur = result.next;
			for (int i = 0; i < m - 1; i++) {
				pre = pre.next;
				cur = cur.next;
			}
			for (int i = 0; i < n - m; i++) {
				ListNode temp = cur.next;
				cur.next = cur.next.next;
				temp.next = pre.next;
				pre.next = temp;
			}
			return result.next;
		}
	}

	// public class ListNode {
	// 	int val;
	// 	ListNode next;
	//
	// 	ListNode(int x) {
	// 		val = x;
	// 	}
	// }

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
//leetcode submit region end(Prohibit modification and deletion)
}