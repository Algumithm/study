import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static boolean[] visit;
    static int N, min;
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	visit = new boolean[N];
    	min = Integer.MAX_VALUE;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}	
    	}
    	
    	for(int i = 0; i < N; i++) {
    		dfs(i, 0, 1, i);
    		visit = new boolean[N];
    	}
    	bw.write(min+"\n");
    	bw.flush();
    }
    
    static void dfs(int cur, int sum, int cnt, int start) {
    	visit[cur] = true;
    	if(cnt == N) {
    		if(map[cur][start] != 0) {
    			sum += map[cur][start];
    			min = Math.min(sum, min);
    		}
    		return;
    	}
    	if(cur >= min) return;
    	for(int i = 0; i < N; i++) {
    		if(!visit[i] && map[cur][i] != 0) {
    			visit[i] = true;
    			dfs(i, sum+map[cur][i], cnt+1, start);
    			visit[i] = false;
    		}
    	}
    }
}
