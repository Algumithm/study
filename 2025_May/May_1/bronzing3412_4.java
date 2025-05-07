import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int F, S, G, U, D;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {	
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visit = new boolean[F+1];
		int ans = bfs();
		if(ans == -1) bw.write("use the stairs");
		else bw.write(ans + "\n");
		bw.flush();
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {S,0});
		visit[S] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curf = cur[0];
			int cnt = cur[1];
			if(curf == G) return cnt;
			if(curf + U <= F && !visit[curf+U]) {
				q.add(new int[] {curf+U, cnt+1});
				visit[curf+U] = true;
			}
			if(curf - D >= 1 && !visit[curf-D]) {
				q.add(new int[] {curf-D, cnt+1});
				visit[curf-D] = true;
			}
		}
		return -1;
	}
}
