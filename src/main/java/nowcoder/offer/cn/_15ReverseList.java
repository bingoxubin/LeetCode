//反转列表
//输入一个链表，反转链表后，输出新链表的表头。

//思路：
//本题的关键就是在于对next域的赋值，同时对下一个节点进行保存，然后对把下一个节点赋给新的节点，这样依次循环完所有的节点。每次使新插入的节点变成头第一个有效节点

package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/9 23:05
 */
public class _15ReverseList {
	public static void main(String[] args) {
		ListNode ln1 = new _15ReverseList().new ListNode(1);
		ListNode ln2 = new _15ReverseList().new ListNode(2);
		ListNode ln3 = new _15ReverseList().new ListNode(3);
		ListNode ln4 = new _15ReverseList().new ListNode(4);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		Solution solution = new _15ReverseList().new Solution();
		ListNode result = solution.ReverseList(ln1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		public ListNode ReverseList(ListNode head) {
			ListNode pre = null;
			ListNode next = null;
			while (head != null) {
				//TODO
				next = head.next;//next前移
				head.next = pre;//倒置
				pre = head;//pre前移
				head = next;//head前移
			}
			return pre;
		}
	}
}
