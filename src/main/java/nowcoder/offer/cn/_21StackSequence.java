//栈的压入、弹出序列
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
// （注意：这两个序列的长度是相等的）

//思路：
//定义两个变量in、out分别代表入栈序列数组下标和出栈序列数组下标。
// 当in小于入栈序列数组长度时，执行以下循环：
// 	1.当前元素
// 	2.当栈非空且栈顶元素等于出栈序列当前值，则一直出栈并移动out指针。
// 最后判断栈是否为空即可。（即将入栈序列数组全部压栈了，但并不是一次全部压入）

package nowcoder.offer.cn;

import java.util.Stack;

/**
 * @author xumaosheng
 * @date 2019/9/9 23:21
 */
public class _21StackSequence {
	public static void main(String[] args) {
		Solution solution = new _21StackSequence().new Solution();
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {4, 5, 3, 1, 2};
		System.out.println(solution.IsPopOrder(arr1, arr2));
	}

	public class Solution {
		public boolean IsPopOrder(int[] pushA, int[] popA) {
			Stack stack = new Stack();
			int in = 0, out = 0;
			while (in < pushA.length) {
				stack.push(pushA[in++]);//每次先进栈
				//若栈顶元素与出栈顺序数组当前元素相等，则循环出栈
				while (!stack.isEmpty() && (Integer) stack.peek() == popA[out]) {
					stack.pop();
					out++;
				}
			}
			//无需判断数组长度为0的情况，因为数组长度为0，栈本来就是空的。
			return stack.isEmpty() == true;
		}
	}
}
