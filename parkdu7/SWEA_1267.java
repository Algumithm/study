import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int V, E;
	static List<int[]> list;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int c = 1; c <= 10; c++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList<int[]>();
			visited = new boolean[V + 1];

			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new int[] {a, b});
			}

			System.out.print("#" + c + " ");
			
			for (int i = 1; i <= V; i++) {
				if(!visited[i]) {
					bfs(i);
				}
			}

			System.out.println();
		}
	}//main
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[1] == start && !visited[list.get(i)[0]]) {
				return;
			}
		}
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i)[0] == node && !visited[list.get(i)[1]]){
					boolean canGo = true;
					for (int j = 0; j < list.size(); j++) {
						if (list.get(j)[1] == list.get(i)[1] && !visited[list.get(j)[0]]) {
							canGo = false;
							break;
						}
					}
					if(canGo) {
						visited[list.get(i)[1]] = true;
						q.add(list.get(i)[1]);
					}
				}
			}
		}
	}//bfs
}//swea1267
