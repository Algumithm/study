package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {  // 단지번호 붙이기 - dfs
	static int n;
	static int[][] arr;
	static int[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int count;
	static ArrayList<Integer> cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr=new int[n][n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		
		visited = new int[n][n];
		cnt = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]==1 && visited[i][j]==0) {
					count =0;
					dfs(i, j);
					cnt.add(count);
				}
			}
		}
		
		System.out.println(cnt.size());
		Collections.sort(cnt);
		for(int a : cnt) {
			System.out.println(a);
		}
		

		sc.close();
	}

	static boolean in_range(int x, int y) { // 경계선 검사
		return (0 <= x && x < n && 0 <= y && y < n);
	}

	static void dfs(int x, int y) {
		visited[x][y] = 1;
		count++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (in_range(nx, ny) && visited[nx][ny] == 0 && arr[nx][ny] == 1) {
				
				dfs(nx,ny);
			}
		}
	}
}
