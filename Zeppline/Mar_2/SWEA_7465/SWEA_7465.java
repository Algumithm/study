import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] VISITED;
	static List<Integer>[] GRAPH;
	
	static void findGroup(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		VISITED[idx] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next:GRAPH[cur]) {
				if(!VISITED[next]) {
					VISITED[next] = true;
					q.offer(next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			VISITED = new boolean[N+1];
			GRAPH = new ArrayList[N+1];
			
			for(int i = 1; i <= N; i++) {
				GRAPH[i] = new ArrayList<>();
			}
			
			for(int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				GRAPH[x].add(y);
				GRAPH[y].add(x);
			}
			
			int count = 0;

			for(int i = 1; i <= N; i++) {
				if(!VISITED[i]) {
					findGroup(i);
					count++;
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
		br.close();
	}
}
