//构建乘积数组
package nowcoder.offer.cn;

/**
 * @author xumaosheng
 * @date 2019/9/10 1:06
 */
public class _51BuildProductArray {
	/*
    思路：
        版本1：暴力算法，没什么可以解释。

        版本2：由于暴力算法复杂度为O(n^2),很多重复计算，故可利用计算过的部分值来减少时间复杂度。
        画一个n*n的图，很容易可以利用计算过的值，先求下三角部分，利用迭代，计算出B[i]的左半部分；
        上三角也是一样，不过由于计算上三角的时间已经没有空闲的空间可以存放临时结果，所以需要定义一个临时
        变量temp来存放。
*/
	public class Solution {
		//版本2
		public int[] multiply(int[] A) {
			int[] B = new int[A.length];
			B[0] = 1;
			//计算下三角部分（即算出B[i]的左半部分),计算过的存在B[i-1]中。
			for (int i = 1; i < B.length; i++) {
				B[i] = B[i - 1] * A[i - 1];
			}
			//计算上三角（即算出B[i]的右半部分），计算过的存在temp中。
			int temp = 1;
			for (int j = B.length - 2; j >= 0; j--) {
				temp *= A[j + 1];
				B[j] *= temp;
			}
			return B;
		}

		//版本1
    /*
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int temp;
        for(int i=0;i<B.length;i++){
            temp = 1;
            for(int j=0;j<A.length;j++){
                if(i != j){
                    temp *= A[j];
                }
            }
            B[i] = temp;
        }
        return B;
    }
    */
	}
}
