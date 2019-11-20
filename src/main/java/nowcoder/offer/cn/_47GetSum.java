//求1-----n的和
//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

//利用&&的短路特性代替if
package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/10 1:00
 */
public class _47GetSum {
	public static void main(String[] args) {

	}

	public class Solution {
		public int Sum_Solution(int n) {
			int result = n;
			boolean flag = result > 0 && (result += Sum_Solution(n - 1)) > 0;
			return result;
		}
	}
}
