//链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个结点。

//思路：
//快指针和慢指针，快指针先跑K个单位然后慢指针开始跑，快指针跑到最后一个节点的时候慢指针对应的就是链表中倒数第k个结点
//思路和上面一样，优化了一下，只遍历一遍链表即可。

package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/9 23:02
 */
public class _14KLastNodeInList {
	public static void main(String[] args) {
		ListNode ln1 = new _14KLastNodeInList().new ListNode(1);
		ListNode ln2 = new _14KLastNodeInList().new ListNode(2);
		ListNode ln3 = new _14KLastNodeInList().new ListNode(3);
		ListNode ln4 = new _14KLastNodeInList().new ListNode(4);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		Solution1 solution1 = new _14KLastNodeInList().new Solution1();
		System.out.println(solution1.FindKthToTail(ln1, 2).val);

	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution1 {
		public ListNode FindKthToTail(ListNode head, int k) {

			ListNode old = head;
			int count = 0;
			int length = 0;
			while (head != null) {
				++length;
				head = head.next;
			}

			int v = length - k;
			if (k <= 0 || k > length) {
				return null;
			}
			while (count < v) {
				old = old.next;
				++count;
			}
			return old;
		}
	}

	public class Solution2 {
		public ListNode FindKthToTail(ListNode head, int k) {
			int distance = 0;//表示两个指针之间的距离
			ListNode temp = head;
			while (head != null) {
				head = head.next;//head后移
				if (distance < k) {//如果距离达不到k，则head后移后，temp不动，距离加一
					distance++;
				} else {//如果距离达到k，则head后移后，temp也后移，一起向前移动一步，间距还是k
					temp = temp.next;
				}
			}
			if (distance == k) {
				return temp;
			}
			return null;//链表长度小于k的情况
		}
	}
}
