import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int[][] dis;
    static int N, min;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	map = new int[N+1][N+1];
    	dis = new int[N+1][N+1];
    	for(int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			dis[i][j] = dis[i-1][j] + dis[i][j-1] + map[i][j] - dis[i-1][j-1];
    		}
    	}
    	
    	for(int m = 0; m < M; m++) {
    		st = new StringTokenizer(br.readLine());
    		int sx = Integer.parseInt(st.nextToken());
    		int sy = Integer.parseInt(st.nextToken());
    		int ex = Integer.parseInt(st.nextToken());
    		int ey = Integer.parseInt(st.nextToken());
    		int ans = dis[ex][ey]-(dis[ex][sy-1] + dis[sx-1][ey] - dis[sx-1][sy-1]); 
    		bw.write(ans + "\n");
    	}
    	bw.flush();
    }
}
