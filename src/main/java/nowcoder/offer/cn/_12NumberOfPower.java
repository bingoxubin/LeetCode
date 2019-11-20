//数值的整数次方
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。\

//思路：
// 		懒，直接库函数
//
// 		利用数学知识：
// 		若指数为0，则无论底数如何结果都为1；
// 		若指数大于0，则直接累乘指数次。
// 		否则，先求指数的绝对值次累乘，再取倒数。
//
// 		利用位运算，回头再写。

package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/9 19:45
 */
public class _12NumberOfPower {
	public static void main(String[] args) {
		Solution1 solution1 = new _12NumberOfPower().new Solution1();
		double result = solution1.Power(1.413, 5);
		System.out.println(result);
	}

	public class Solution1 {
		public double Power(double base, int exponent) {
			return Math.pow(base, exponent);
		}
	}

	public class Solution2 {
		public double Power(double base, int exponent) {
			double result = 1d;
			int i;
			if (exponent == 0) {
				return 1d;
			} else if (exponent > 0) {
				for (i = 0; i < exponent; i++) {
					result *= base;
				}
			} else {
				exponent = -exponent;
				for (i = 0; i < exponent; i++) {
					result *= base;
				}
				result = 1 / result;
			}
			return result;
		}
	}
}
