import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int[] dis;
    static boolean[] visit;
    static int N, M;
    static class node{
    	int v;
    	int cost;
    	node(int v, int cost) {
    		this.v = v;
    		this.cost = cost;
    	}
    }
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    	map = new int[N+1][N+1];
    	dis = new int[N+1];
    	visit = new boolean[N+1];
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			map[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		map[a][b] = Math.min(map[a][b], Integer.parseInt(st.nextToken()));
    	}
    	st = new StringTokenizer(br.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int goal = Integer.parseInt(st.nextToken());
    	di(start);
    	bw.write(dis[goal]+"\n");
    	bw.flush();
    }
    
    static void di(int start) {
    	PriorityQueue<node> pq = new PriorityQueue<node>((o1, o2)->o1.cost-o2.cost);
    	pq.add(new node(start, 0));
    	for(int i = 1; i <= N; i++) {
    		dis[i] = Integer.MAX_VALUE;
    	}
    	dis[start] = 0;
    	
    	
    	while(!pq.isEmpty()) {
    		node cur = pq.poll();
    		if(visit[cur.v]) continue;
    		visit[cur.v] = true;
    		
    		for (int i = 1; i <= N; i++) {
                if (!visit[i] && map[cur.v][i] != Integer.MAX_VALUE) {
                    int newDist = cur.cost + map[cur.v][i];
                    if (newDist < dis[i]) {
                        dis[i] = newDist;
                        pq.add(new node(i, newDist));
                    }
                }
            }
    	}
    }
}
