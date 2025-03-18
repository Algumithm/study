package algo;

import java.util.Scanner;

class Solution0318_knapsack {
	static int N, K;
	static int[] v, c;
	static int[][] dp;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			v = new int[N + 1];
			c = new int[N + 1];
			dp = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				v[i] = sc.nextInt();
				c[i] = sc.nextInt();
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					if (j >= v[i]) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + c[i]);
					}else {
					dp[i][j] = dp[i-1][j];
					}
				}
			}

			System.out.println("#" + test_case + " " + dp[N][K]);
		}
		sc.close();
	}

}
