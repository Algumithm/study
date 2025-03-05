import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int max;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		
		for(int i = 0; i < n; i++) {
			String[] strs = br.readLine().split("");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		List<Integer> list = new ArrayList();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				max = 0;
				if(arr[i][j] > 0) {
					dfs(j,i,n);
					list.add(max);
				}
				
//				for(int m = 0; m < n; m++) {
//					for(int l = 0; l < n; l++) {
//						System.out.print(arr[m][l] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
		}
		
		System.out.println(list.size());
		list.sort(null);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
	} // main
	
	static void dfs(int x, int y, int n) {
			arr[y][x] = 0;
			max++;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < n && ny < n && nx >=0 && ny >= 0 && arr[ny][nx]>0) {
					dfs(nx, ny, n);
				}
			}
		
		
	}
	
	
} // Test
