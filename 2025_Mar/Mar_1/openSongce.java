import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] distance;
	static int[] dx = { 0, 0, 1, -1};
	static int[] dy = { 1, -1, 0, 0};
	static int x,y;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		m = Integer.parseInt(strs[1]);
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		distance = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			strs = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
				if(arr[i][j]==2) {
					x = j;
					y = i;
				}
			}
		}
		
		bfs(x,y);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					distance[i][j] = -1;
				}
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList();
		int[] start = {x,y};
		queue.add(start);
		visited[y][x] = true;
		distance[y][x] = 0;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(bound(new int[] {nx,ny}) && !visited[ny][nx] && arr[ny][nx]==1) {
					queue.add(new int[] {nx,ny});
					visited[ny][nx] = true;
					distance[ny][nx] = distance[temp[1]][temp[0]] + 1;
				}
				
			}
		}
		
		
		
	}
	
	
	static boolean bound(int[] pos) {
		if(pos[0]<m && pos[1] < n && pos[0] >=0 && pos[1] >=0) {
			return true;
		}else {
			return false;
		}
	}
}
