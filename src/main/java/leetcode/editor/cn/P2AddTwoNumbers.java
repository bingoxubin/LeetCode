//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package leetcode.editor.cn;

//Java：两数相加
public class P2AddTwoNumbers {
	public static void main(String[] args) {
		Solution solution = new P2AddTwoNumbers().new Solution();
		// TO TEST
	}

//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode result = new ListNode(0);
			int sum = 0;
			int cur = 0;
			ListNode result1 = result;
			while (l1 != null || l2 != null) {
				sum = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + cur;
				//求十位数，进的数
				cur = sum / 10;
				//求个位数
				sum = sum % 10;
				result1.next = new ListNode(sum);
				result1 = result1.next;
				if (l1 != null) l1 = l1.next;
				if (l2 != null) l2 = l2.next;
			}
			if (cur > 0) {
				result1.next = new ListNode(cur);
			}
			return result.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}