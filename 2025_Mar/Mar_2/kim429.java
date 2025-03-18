package swea;

import java.util.*;
import java.io.*;

public class BOJ_10971 {
	
	static int N;
	static int[][] array;
	static int[] visited;
	static int sum;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		visited = new int[N];
		sum = 0;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(, 0);
		
		System.out.println(min);
	}

	static void dfs(int row, int mask) {
		if(row==N) {
			for(int i = 0; i < N ; i++) {
				System.out.print(visited[i]);
			}
			System.out.println();
			//System.out.println(sum);
			int s = visited[0];
			for(int i = 1; i < N; i++) {
				sum += array[s][visited[i]];
				//System.out.println("sum : " + sum);
				if(i == N-1) {
					sum += array[visited[i]][visited[0]];
				}
				s = visited[i];
			}
			min = Math.min(min, sum);
			sum = 0;
			return;
		}
		for(int col = 0; col < N; col++) {
			if(((mask&(1<<col)) == 0) && array[row][col] != 0) {
				visited[row] = col;
				dfs(row+1, mask | (1<<col));
			}
		}
	}
}
