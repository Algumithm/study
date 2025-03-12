package _0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2583 {
	static int M, N, K, count;
	static int grid[][];
	static int dxdy[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			for (int j = startX; j < endX; j++) {
				for (int j2 = startY; j2 < endY; j2++) {
					grid[j][j2]++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(grid[i][j] == 0) {
					count = 0;
					dfs(i, j);
					list.add(count);
				}
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}//main
	
	static void dfs(int x, int y) {
		if(grid[x][y] != 0) {
			return;
		}
		grid[x][y]++;
		count++;
		
		for(int[] d : dxdy) {
			int nx = x + d[0];
			int ny = y + d[1];
			if(!isEdge(nx, ny)) {
				dfs(nx, ny);
			}
		}
	}//dfss
	
	static boolean isEdge(int i, int j) {
        if(i < 0 || i >= N || j < 0 || j >= M) {
            return true;
        }
        return false;
    }//isEdge?
	
}//bj2583
