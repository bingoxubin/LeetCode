//从尾到头打印链表
//输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

//思路：
//      采用递归：
// 		若当前节点不为空，则递归其后继节点，并将当前节点加入list中。
//
// 		采用数据结构栈实现：
// 		利用栈“后进先出”特性
//
// 		利用ArrayList的public void add(int index, E element)：
// 		从前往后遍历，每次插在list的最前面位置。

package nowcoder.offer.cn;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author xumaosheng
 * @date 2019/9/9 19:11
 */
public class _03PrintArrayList {
	public static void main(String[] args) {
		ListNode ln1 = new _03PrintArrayList().new ListNode(1);
		ListNode ln2 = new _03PrintArrayList().new ListNode(2);
		ListNode ln3 = new _03PrintArrayList().new ListNode(3);
		ListNode ln4 = new _03PrintArrayList().new ListNode(4);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;

		Solution1 solution1 = new _03PrintArrayList().new Solution1();
		Solution2 solution2 = new _03PrintArrayList().new Solution2();
		Solution3 solution3 = new _03PrintArrayList().new Solution3();
		ArrayList<Integer> list = solution3.printListFromTailToHead(ln1);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution1 {
		ArrayList<Integer> list = new ArrayList<Integer>();

		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
			if (listNode != null) {
				printListFromTailToHead(listNode.next);
				list.add(listNode.val);
			}
			return list;
		}
	}

	public class Solution2 {
		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
			Stack<ListNode> stack = new Stack<>();
			ArrayList<Integer> list = new ArrayList<>();
			while (listNode != null) {
				stack.push(listNode);
				listNode = listNode.next;
			}

			while (!stack.empty()) {
				list.add(stack.pop().val);
			}
			return list;
		}
	}

	public class Solution3 {
		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (listNode != null) {
				list.add(0, listNode.val);
				listNode = listNode.next;
			}
			return list;
		}
	}

}
