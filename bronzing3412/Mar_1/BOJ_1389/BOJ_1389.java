import java.util.*;
import java.io.*;

public class Main {
	
	static class node{
		int value, depth;
		node(int value, int depth) {
			this.value = value;
			this.depth = depth;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] link; 
	static boolean[] visit;
	static int[] kevin;
	static Queue<node> q;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		link = new int[N+1][N+1];
		kevin = new int[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link[a][b] = 1;
			link[b][a] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			bfs(i, N);
		}
		int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 1; i <= N; i++) {
            if (kevin[i] < min) {
                min = kevin[i];
                ans = i;
            }
        }
		bw.write(ans+"\n");
		bw.flush();
	}
	
	static void bfs(int num, int N) {
		q = new LinkedList<node>();
		visit = new boolean[N+1];
		q.add(new node(num, 0));
		while(!q.isEmpty()) {
			node a = q.poll();
			kevin[num] += a.depth;
			for(int i = 1; i <= N; i++) {
				if(!visit[i] && link[a.value][i] == 1) {
					visit[i] = true;
					q.add(new node(i, a.depth+1));
				}
			}
		}
	}

}
