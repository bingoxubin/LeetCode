//用两个栈实现队列
//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

//思路
//      进栈：
// 		直接进stack1
// 		出栈：
// 		若stack2不为空，则出栈。
// 		否则，当stack1不为空时，将stack1中的元素依次出栈并压人stack2中。最后，弹出stack2的栈顶元素。
package nowcoder.offer.cn;

import java.util.Stack;

/**
 * @author xumaosheng
 * @date 2019/9/9 19:25
 */
public class _05TwoStacksRealizeQueues {
	public static void main(String[] args) {
		Solution solution = new _05TwoStacksRealizeQueues().new Solution();
		solution.push(1);
		solution.push(2);
		solution.push(3);
		solution.push(4);
		solution.push(5);
		solution.push(6);
		while (!solution.stack2.empty() || !solution.stack1.empty()) {
			System.out.println(solution.pop());
		}
	}

	public class Solution {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			if (!stack2.empty()) {
				return stack2.pop();
			} else {
				while (!stack1.empty()) {
					stack2.push(stack1.pop());
				}
				return stack2.pop();
			}
		}
	}
}
