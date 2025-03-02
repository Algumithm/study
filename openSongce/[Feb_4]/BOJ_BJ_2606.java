import java.lang.*;
import java.util.*;
import java.io.*;


public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int sum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int com_n = Integer.parseInt(br.readLine());
		
		int node_n = Integer.parseInt(br.readLine());
		graph = new ArrayList[com_n+1];
		visited = new boolean[com_n+1];
		for (int i = 1; i <= com_n; i++) {
            graph[i] = new ArrayList<>();
        }
		
		for(int i = 0; i < node_n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		sum = 0;
		dfs(1);
		System.out.println(sum);
	}
	
	
	static void dfs(int start) {
		visited[start] = true;
		
		for(int n : graph[start]) {
			if(!visited[n]) {
				sum++;
				dfs(n);
			}
		}
	}
}
