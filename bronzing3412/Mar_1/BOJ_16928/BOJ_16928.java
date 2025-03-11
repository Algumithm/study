import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visit = new boolean[101];
    static int[] dis = new int[101];
    static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    static Queue<Integer> q = new LinkedList<Integer>();
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	for(int i = 0; i < N+M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		hm.put(a, b);
    	}
    	int start = 1;
    	bw.write(bfs(start, 0) + "\n");
        bw.flush();
    }
    
    static int bfs(int cur, int cnt) {
    	q.add(cur);
    	dis[cur] = cnt;
    	visit[cur] = true;
    	while(!q.isEmpty()) {
    		int a = q.poll();
    		if(a == 100) return dis[a];
    		for(int i = 1; i <= 6; i++) {
    			if(a+i <= 100 && !visit[a+i]) {
					if(hm.containsKey(a+i)) {
						int next = hm.get(a+i);
					    if (!visit[next]) {
					        visit[next] = true;
					        q.add(next);
					        dis[next] = dis[a] + 1;
					    }
					} else {
						visit[a+i] = true;
						q.add(a+i);
						dis[a+i] = dis[a]+1;
					}
    			}
    		}
    	}
    	return -1;
    }
}
