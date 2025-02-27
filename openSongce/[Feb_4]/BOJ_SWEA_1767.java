import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= test_n; i++) {
			 
			
			List<int[]> list = new ArrayList();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			
			
			int[][] arr = new int[n][n];
			boolean[][] visited = new boolean[n][n]; 
			
			
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					if(arr[j][k] == 1 && (j == 0 || k == 0 || j == n-1 || k == n-1)) {
						arr[j][k] = 0;
						visited[j][k] = true;
					}else if(arr[j][k] == 1) {
						visited[j][k] = true;
						list.add(new int[] {k,j});
					}
				}
			}
			
			for(int [] a : list) {
				System.out.println(a[0] + " " + a[1]);
			}
			
			for(int j = 0; j < n; j++) {
				
				for(int k = 0; k < n; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			
			find(list.get(0)[0], list.get(0)[1], arr, visited, 0, 0, 1, list);
			
			
			System.out.println("#" + i + " " + min);
		}
	}
	
	
	
	static void find(int x, int y, int[][] arr, boolean[][] visited, int sum, int b, int idx, List<int[]> list) {
		int n = arr.length;
		int num = 0;
		boolean success = false;
		if(idx == list.size()) {
			if(sum==max) {
				min = Math.min(min, b);
			}else if(sum > max) {
				max = Math.max(max, sum);
				min = b;
			}
			return;
		}
		
			
		

			// x축 오른쪽
			for(int i = x+1; i < n; i++) {
				System.out.println("(" + i + ", " + y + ")");
				if(visited[y][i]) {
					for(int j = i-1; j > x; j--) {
						visited[y][j] = false;
					}
					num = 0;
					break;
				}else {
					visited[y][i] = true;
					num++;
				}
				success = true;
				
				for(int j = 0; j < n; j++) {
					
					for(int k = 0; k < n; k++) {
						System.out.print(visited[j][k] + " ");
					}
					System.out.println();
				}
				System.out.println();
				
			}
			if(success) {
				find(list.get(idx)[0], list.get(idx)[1], arr, visited, sum+1, b+num, idx+1, list);
				num = 0;
				for(int i = x+1; i < n; i++) {
					visited[y][i] = false;
				}
				success = false;
			}
			
			
			
			// x축 왼쪽
			for(int i = x-1; i >= 0; i--) {
				if(visited[y][i]) {
					for(int j = i+1; j < x; j++) {
						visited[y][j] = false;
					}
					num = 0;
					break;
				}else {
					visited[y][i] = true;
					num++;
				}
				
				for(int j = 0; j < n; j++) {
					
					for(int k = 0; k < n; k++) {
						System.out.print(visited[j][k] + " ");
					}
					System.out.println();
				}
				System.out.println();
				
				
			}
			if(success) {
				find(list.get(idx)[0], list.get(idx)[1], arr, visited, sum+1, b+num, idx+1, list);
				num = 0;
				for(int i = x-1; i >= 0; i--) {
					visited[y][i] = false;
				}
				success = false;
			}
			
			
			
			// y축 위쪽
			for(int i = y+1; i < n; i++) {
				if(visited[i][x]) {
					for(int j = i-1; j > y; j--) {
						visited[j][x] = false;
					}
					num = 0;
					break;
				}else {
					visited[i][x] = true;
					num++;
				}
				
				for(int j = 0; j < n; j++) {
					
					for(int k = 0; k < n; k++) {
						System.out.print(visited[j][k] + " ");
					}
					System.out.println();
				}
				System.out.println();
				
			}
			if(success) {
				find(list.get(idx)[0], list.get(idx)[1], arr, visited, sum+1, b+num, idx+1, list);
				num = 0;
				for(int i = y+1; i < n; i++) {
					visited[i][x] = false;
				}
				success = false;
			}
			
			
			
			// y축 아랫쪽
			for(int i = y-1; i >= 0; i--) {
				if(visited[i][x]) {
					for(int j = i+1; j < y; j++) {
						visited[j][x] = false;
					}
					num = 0;
					break;
				}else {
					visited[i][x] = true;
					num++;
				}
				
				for(int j = 0; j < n; j++) {
					
					for(int k = 0; k < n; k++) {
						System.out.print(visited[j][k] + " ");
					}
					System.out.println();
				}
				System.out.println();
				
			}
			if(success) {
				find(list.get(idx)[0], list.get(idx)[1], arr, visited, sum+1, b+num, idx+1, list);
				num = 0;
				for(int i = y-1; i >= n; i--) {
					visited[i][x] = false;
				}
				success = false;
			}

		
		
	}
}
