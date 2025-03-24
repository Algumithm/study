package retest5;

import java.util.Scanner;

public class Main0321_내리막길 { // 골드3 백준1895 내리막길
	static int m, n, h;
	static int[][] map, dp;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m][n];
		dp = new int[m][n];

		h = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}

		dfs(0, 0);
		System.out.println(dp[0][0]);
	}

	static boolean in_range(int x, int y) {
		return (x >= 0 && y >= 0 && x < m && y < n);
	}

	static void dfs(int x, int y) {
		// 목적지 도착
		if (x == m - 1 && y == n - 1) {
			dp[x][y] = 1;
			return;
		}

		// 이미 계산 경로임.
		if (dp[x][y] != -1) {
			return;
		}

		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (in_range(nx, ny) && map[x][y] > map[nx][ny]) {

				if (dp[nx][ny] == -1) {
					dfs(nx, ny);
				}
				dp[x][y] += dp[nx][ny]; // 경로 개수 더하기
			}
		}
	}
}
