import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] graph;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				dfs(i, N);
				cnt++;
			}
		}
		sb.append(cnt+"\n");
		bw.write(sb.toString());
		bw.flush();
	}
	static void dfs(int n, int N) {
		visit[n] = true;
		for(int i = 1; i <= N; i++) {
			if(!visit[i] && graph[n][i] == 1) {
				dfs(i, N);
			}
		}
	}
}
