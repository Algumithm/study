import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[][] grid;
	static boolean visited[];
	static int start;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        min = Integer.MAX_VALUE; 
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        for (int i = 0; i < N; i++) {
			start = i;
			dfs(i, 0, 1);
		}
        
        System.out.println(min);
	}//main
	
	static void dfs(int idx, int sum, int cnt) {
		if(cnt == N && grid[idx][start] != 0) {
			min = Math.min(min, sum + grid[idx][start]);
			return;
		}
		
		visited[idx] = true;
		
		for (int i = 0; i < N; i++) {
			if(!visited[i] && grid[idx][i] != 0) {
				dfs(i, sum + grid[idx][i], cnt + 1);
			}
		}
		
		visited[idx] = false;
	}
}//bj
