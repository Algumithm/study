import java.lang.*;
import java.util.*;
import java.io.*;


public class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[][] strs = new String[n][n];
		for(int i = 0; i < n; i++) {
			strs[i] = br.readLine().split("");
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(strs[i][j]);
//			}
//			System.out.println();
//		}
		int normalResult = 0;
		boolean[][] visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i, j, strs, strs[i][j], visited);
					normalResult++;
				}
			}
		}
		
		int result = 0;
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(strs[i][j].equals("G")) {
					strs[i][j] = "R";
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i, j, strs, strs[i][j], visited);
					result++;
				}
			}
		}
		
		System.out.println(normalResult + " " + result);
	}
	
	static void dfs(int i, int j, String[][] arr, String color, boolean[][] visited) {
		visited[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = j + dx[k];
			int ny = i + dy[k];
			
			if(nx >= 0 && nx < n && ny < n && ny >= 0) {
				if(!visited[ny][nx] && arr[ny][nx].equals(color)) {
					visited[ny][nx] = true;
					dfs(ny, nx, arr, color, visited);
				}
			}
		}
		
	}
}
