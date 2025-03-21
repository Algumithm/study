import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int[][][] dp;
    static int N;
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	map= new int[N+1][N+1];
    	dp = new int[N+1][N+1][3];
    	
    	for(int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 1) map[i][j] = -1;
    		}
    	}
    	dp[1][2][0] = 1;
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			if(map[i][j] != -1)
    				dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j-1][0] + dp[i][j-1][2]);
    			if(map[i][j] != -1) 
    				dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j][1] + dp[i-1][j][2]);
    			if(map[i][j] != -1 && map[i-1][j] != -1 && map[i][j-1] != -1)
    				dp[i][j][2] = Math.max(dp[i][j][2], dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]);
    		}
    	}
    	
    	System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    	
    	bw.flush();
    }
}
