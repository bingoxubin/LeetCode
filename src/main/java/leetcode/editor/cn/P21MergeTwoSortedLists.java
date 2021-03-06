//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
	public static void main(String[] args) {
		Solution solution = new P21MergeTwoSortedLists().new Solution();
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

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		//非递归
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode result = new ListNode(0);
			ListNode temp = result;
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					temp.next = new ListNode(l1.val);
					temp = temp.next;
					l1 = l1.next;
				} else {
					temp.next = new ListNode(l2.val);
					temp = temp.next;
					l2 = l2.next;
				}
			}
			while (l1 != null) {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
				temp = temp.next;
			}
			while (l2 != null) {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
				temp = temp.next;
			}
			return result.next;
		}

		//递归
		public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
			if (l1 == null) return l2;
			if (l2 == null) return l1;

			ListNode head = null;
			if (l1.val <= l2.val) {
				head = l1;
				head.next = mergeTwoLists(l1.next, l2);
			} else {
				head = l2;
				head.next = mergeTwoLists(l1, l2.next);
			}
			return head;

			// if(l1 == null)  return l2;
			// if(l2 == null)  return l1;
			// if(l1.val < l2.val){
			// 	l1.next = mergeTwoLists(l1.next,l2);
			// 	return l1;
			// }
			// else{
			// 	l2.next = mergeTwoLists(l2.next,l1);
			// 	return l2;
			// }
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}