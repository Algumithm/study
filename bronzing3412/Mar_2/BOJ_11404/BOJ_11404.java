import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static boolean[] visit;
    static final int INF = Integer.MAX_VALUE / 2;
    static int[] dis;
    
    public static void main(String[] args) throws Exception {
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	map = new int[N+1][N+1];
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			map[i][j] = INF;
    			if(i == j) map[i][j] = 0;
    		}
    	}
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		map[a][b] = Math.min(map[a][b], c);
    	}
    	
    	for(int k = 1; k <= N; k++) {
    		for(int i = 1; i <= N; i++) {
    			for(int j = 1; j <= N; j++) {
    				map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
    			}
    		}
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			System.out.print((map[i][j] == INF ? 0 : map[i][j]) + " ");
    		}
    		System.out.println();
    	}
    	bw.flush();
    }
}
