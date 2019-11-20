//包含main函数的栈
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

//思路：
//借助辅助栈实现：
// 	压栈时：若辅助栈为空，则将节点压入辅助栈。否则，当当前节点小于等于辅助栈栈顶元素时将节点压入辅助栈。
// 	出栈时：若辅助栈和数据栈栈顶元素相同，则同时出栈。否则，只出栈数据栈元素。

package nowcoder.offer.cn;

import java.util.Stack;

/**
 * @author xumaosheng
 * @date 2019/9/9 23:19
 */
public class _20ContainMainStack {
	public static void main(String[] args) {
		Solution solution = new _20ContainMainStack().new Solution();
		solution.push(2);
		solution.push(4);
		solution.push(9);
		solution.push(1);
		solution.push(7);
		solution.push(6);
		solution.push(5);
		System.out.println(solution.min());
		System.out.println(solution.top());
	}

	public class Solution {
		private Stack stack = new Stack();
		private Stack minStack = new Stack();

		public void push(int node) {
			//当辅助栈为空或者当前节点值小于等于辅助栈栈顶元素才压栈
			if (minStack.isEmpty() || node <= (Integer) minStack.peek()) {
				minStack.push(node);
			}
			stack.push(node);
		}

		public void pop() {
			if (stack.peek() == minStack.peek()) {
				minStack.pop();
			}
			stack.pop();
		}

		public int top() {
			return (Integer) stack.peek();
		}

		public int min() {
			return (Integer) minStack.peek();
		}
	}
}
