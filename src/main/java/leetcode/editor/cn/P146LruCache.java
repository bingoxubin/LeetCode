//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package leetcode.editor.cn;

import java.util.HashMap;

//Java：LRU缓存机制
public class P146LruCache {

	//leetcode submit region begin(Prohibit modification and deletion)
	class LRUCache {
		class CacheNode {
			int key;
			int value;
			CacheNode pre;
			CacheNode next;
		}

		public void putNode(CacheNode node) {
			node.pre = first;
			node.next = first.next;

			first.next.pre = node;
			first.next = node;
		}

		public void delNode(CacheNode node) {
			CacheNode pre = node.pre;
			CacheNode next = node.next;

			pre.next = next;
			next.pre = pre;
		}

		public void moveToHead(CacheNode node) {
			delNode(node);
			putNode(node);
		}

		public CacheNode popLast() {
			CacheNode tail = last.pre;
			delNode(tail);
			return tail;
		}

		CacheNode first = null;
		CacheNode last = null;
		int size;
		int capacity;
		HashMap<Integer, CacheNode> mapping = new HashMap<>();

		public LRUCache(int capacity) {
			int size = 0;
			this.capacity = capacity;
			first = new CacheNode();
			last = new CacheNode();
			first.next = last;
			last.pre = first;
		}

		public int get(int key) {
			if (mapping.containsKey(key)) {
				CacheNode result = mapping.get(key);
				moveToHead(result);
				return result.value;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (mapping.containsKey(key)) {
				mapping.get(key).value = value;
				moveToHead(mapping.get(key));
			} else {
				CacheNode temp = new CacheNode();
				temp.key = key;
				temp.value = value;

				mapping.put(key, temp);
				putNode(temp);

				size++;
				if (size > capacity) {
					CacheNode tmp = popLast();
					mapping.remove(tmp.key);
					size--;
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}