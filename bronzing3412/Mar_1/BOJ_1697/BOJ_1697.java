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
	static boolean[] visit;
	static Queue<node> q;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[100001];
		int ans = bfs(N, K);
		bw.write(ans+"\n");
		bw.flush();
	}
	
	static int bfs(int N, int K) {
		q = new LinkedList<node>();
		q.add(new node(N, 0));
		visit[N] = true;
		while(!q.isEmpty()) {
			node a = q.poll();
			if(a.value == K) return a.depth;
			if(check(a.value-1)&&!visit[a.value-1]) {
				q.add(new node(a.value-1, a.depth+1));
				visit[a.value-1] = true;
			}
			if(check(a.value+1)&&!visit[a.value+1]) {
				q.add(new node(a.value+1, a.depth+1));
				visit[a.value+1] = true;
			}
			if(check(a.value*2)&&!visit[a.value*2]) {
				q.add(new node(a.value*2, a.depth+1));
				visit[a.value*2] = true;
			}
		}
		return -1;
	}
	
	static boolean check(int n) {
		if(n < 0 || n >100000) return false;
		else return true;
	}
}
