package swea;

import java.util.*;
import java.io.*;

public class BOJ_15649_2 { 
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new int[N+1];
		
		dfs(0);
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			depth = 0;
			for(int num = 0 ; num < M; num++) {
				System.out.print(arr[num] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
}
