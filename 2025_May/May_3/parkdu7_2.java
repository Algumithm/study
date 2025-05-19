
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List<int[]> list = new ArrayList<>();
	static int targetA, targetB, N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		targetA = Integer.parseInt(st.nextToken());
		targetB = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[] {a, b});
		}
		
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean visited[] = new boolean[M];
//		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i)[0] + list.get(i)[1]);
			if(list.get(i)[1] == targetA) {
				q.add(new int[] { list.get(i)[0] , 1 });
				visited[i] = true;
			}
			if(list.get(i)[0] == targetA) {
				q.add(new int[] { list.get(i)[1] , 1 });
				visited[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(cur[0] + " " + cur[1]);
			if(cur[0] == targetB) {
				return cur[1];
			}
			
			for (int i = 0; i < list.size(); i++) {
				if(!visited[i] && cur[0] == list.get(i)[1]) {
					visited[i] = true;
					q.add(new int[] {list.get(i)[0] , cur[1] + 1});
				}
				if(!visited[i] && cur[0] == list.get(i)[0]) {
					visited[i] = true;
					q.add(new int[] {list.get(i)[1] , cur[1] + 1});
				}
			}
			
		}
		
		return -1;
	}
}
