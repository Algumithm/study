package _0520;

import java.io.*;
import java.util.*;
import java.lang.*;

public class bj2638 {
	static int N, M;
	static int[][] grid;
	static int[][] dxdy = {{-1, 0}, {1, 0}, {0 ,-1}, {0, 1}};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    
        System.out.println(bfs());
       
	}
	
	static int bfs() {
		int cnt = 0;
		
		while(!checkAllMelted()) {
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {0, 0});
			int[][] countGrid = new int[N][M];
			boolean visited[][] = new boolean[N][M];
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0], y = cur[1];
				
				for (int[] d : dxdy) {
					int nx = x + d[0], ny = y + d[1];
					
					if(!isEdge(nx,ny) && !visited[nx][ny] && grid[nx][ny] == 0) {
						q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
					else if(!isEdge(nx,ny) && grid[nx][ny] == 1) {
						countGrid[nx][ny]++;
					}
					
				}
			}//countGrid 채우기
			melt(countGrid);
			cnt++;
		}//녹이기
		
		
		return cnt;
	}
	
	
	static boolean checkAllMelted() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != 0)
					return false;
			}
		}
		
		return true;
	}
	
	static void melt(int[][] count) {
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i].length; j++) {
				if (grid[i][j] == 1 && count[i][j] >= 2) {
					grid[i][j] = 0;
				}
			}
		}
	}
	
	static boolean isEdge(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}
}
