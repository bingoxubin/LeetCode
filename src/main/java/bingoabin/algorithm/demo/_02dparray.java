package bingoabin.algorithm.demo;

/**
 * @author bingoabin
 * @date 2020/4/15 23:28
 */
public class _02dparray {
	public static void main(String[] args) {
		//正向遍历dp数组
		int m = 10;
		int n = 10;
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//计算dp[i][[j]
			}
		}

		//反向遍历dp数组
		for (int i = m - 1; i >= 0; i++) {
			for (int j = n - 1; j >= 0; j++) {
				//计算dp[i][j]
			}
		}

		//斜向遍历dp数组
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = l + i - 1;
				//计算dp[i][j]
			}
		}
	}
}
