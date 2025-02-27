import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_n = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][n];
			List<int[]> peaks = new ArrayList<>();
			int high = Integer.MIN_VALUE;
			max = 0;

			// 지도 입력 및 최고봉 찾기
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > high) {
						high = arr[i][j];
						peaks.clear();
						peaks.add(new int[]{i, j});
					} else if (arr[i][j] == high) {
						peaks.add(new int[]{i, j});
					}
				}
			}

			// 최고점에서 DFS 시작
			for (int[] peak : peaks) {
				boolean[][] visited = new boolean[n][n];
				dfs(peak[0], peak[1], arr, visited, 1, k, true);
			}

			System.out.println("#" + t + " " + max);
		}
	}

	static void dfs(int y, int x, int[][] arr, boolean[][] visited, int length, int k, boolean chance) {
		int n = arr.length;
		visited[y][x] = true;
		max = Math.max(max, length);

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]) {
				if (arr[ny][nx] < arr[y][x]) {
					dfs(ny, nx, arr, visited, length + 1, k, chance);
				} else if (chance) {
					// K를 1~K까지 줄여보면서 최적의 경우 탐색
					for (int cut = 1; cut <= k; cut++) {
						if (arr[ny][nx] - cut < arr[y][x]) {
							int original = arr[ny][nx];
							arr[ny][nx] -= cut;
							dfs(ny, nx, arr, visited, length + 1, k, false);
							arr[ny][nx] = original; // 백트래킹
						}
					}
				}
			}
		}
		visited[y][x] = false;
	}
}
