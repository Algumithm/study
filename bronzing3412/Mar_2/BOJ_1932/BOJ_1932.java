import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
    	
    	int N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	dp = new int[N][N];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < i+1; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dp[0][0] = map[0][0];
    	
    	for(int i = 1; i < N; i++) {
    		for(int j = 0; j < i+1; j++) {
    			if(j-1 < 0) {
    				dp[i][j] = dp[i-1][j] + map[i][j];
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j] + map[i][j], dp[i-1][j-1] + map[i][j]);
    			}
    		}
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for(int j = 0; j < N; j++) {
			max = Math.max(max, dp[N-1][j]);
		}
    	System.out.println(max);
    }
}
