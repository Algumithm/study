import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int grid[][];
	static int o;
	static boolean visited[];
	static double max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cs = Integer.parseInt(br.readLine());
		for (int c = 1; c <= cs; c++) {
			max = Integer.MIN_VALUE;
			o = Integer.parseInt(br.readLine());
			grid = new int[o][o];
			visited = new boolean[o];
			
			for (int i = 0; i < o; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < o; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 1.0);

			System.out.printf("#%d %.6f%n", c, max * 100);
		}//case
	}//main
	
	static void dfs(int idx, double p) {

		if (p <= max) return;
		if(idx == o) {
			max = Math.max(max, p);
			return;
		}

		for (int i = 0; i < o; i++) {
			if(!visited[i]) {
				double per;
				visited[i] = true;
				per = p * (grid[idx][i] / 100.0);
				dfs(idx + 1, per);
				visited[i] = false;
			}
		}
		
		
	}//dfss
}//swea
