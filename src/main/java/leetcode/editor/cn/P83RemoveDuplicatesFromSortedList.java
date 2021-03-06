//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

package leetcode.editor.cn;

//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
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
		public ListNode deleteDuplicates(ListNode head) {
			ListNode result = head;
			if(head == null) return result;
			while (head.next != null) {
				if (head.val == head.next.val) {
					head.next = head.next.next;
				} else {
					head = head.next;
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}