//链表中环的路口节点
package nowcoder.offer.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xumaosheng
 * @date 2019/9/10 1:08
 */
public class _55EntranceInList {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*
		 思路：
			 若存在环，遍历的时候第一个重复出现的节点就是环的入口节点。
			 利用Set即可。
			 每遍历一个节点，则判断set中是否已经存在，存在则返回该节点。
			 否则，将该节点加入到set中，并将链表指针后移。
	*/
	public class Solution {

		public ListNode EntryNodeOfLoop(ListNode pHead) {
			Set<ListNode> set = new HashSet<ListNode>();
			while (pHead.next != null) {
				if (!set.contains(pHead)) {
					set.add(pHead);
					pHead = pHead.next;
				} else {
					return pHead;
				}
			}
			return null;
		}
	}
}
