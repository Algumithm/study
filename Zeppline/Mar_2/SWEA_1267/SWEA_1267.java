import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] VISITED;
	static List<Integer>[] GRAPH;
	static Stack<Integer> STACK;
	
	static void findLastPoint(int idx) {
		VISITED[idx] = true;
		for(int next:GRAPH[idx]) {
			if(!VISITED[next]) findLastPoint(next);
		}
		STACK.add(idx);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			VISITED = new boolean[V+1];
			GRAPH = new ArrayList[V+1];
			STACK = new Stack<Integer>();
			
			for(int i = 1; i <= V; i++) {
				GRAPH[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= E; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				GRAPH[x].add(y);
			}
			
			for(int i = 1; i <= V; i++) {
				if(!VISITED[i]) findLastPoint(i);
			}
			
			sb.append("#").append(test_case).append(" ");
			
			while(!STACK.isEmpty()) sb.append(STACK.pop()).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
