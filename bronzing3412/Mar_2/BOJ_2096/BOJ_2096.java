import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int[][][] dp;
    static int N, M;

    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	map = new int[N][3];
    	dp = new int[N][3][2];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 3; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	dp[0][0][0] = map[0][0];
    	dp[0][0][1] = map[0][0];
    	dp[0][1][0] = map[0][1];
    	dp[0][1][1] = map[0][1];
    	dp[0][2][0] = map[0][2];
    	dp[0][2][1] = map[0][2];
    	
    	for(int i = 1; i < N; i++) {
    		dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]) + map[i][0];
    		dp[i][0][1] = Math.min(dp[i-1][0][1], dp[i-1][1][1]) + map[i][0];
    		dp[i][1][0] = Math.max(Math.max(dp[i-1][1][0], dp[i-1][0][0]), dp[i-1][2][0]) + map[i][1];
    		dp[i][1][1] = Math.min(Math.min(dp[i-1][1][1], dp[i-1][0][1]), dp[i-1][2][1]) + map[i][1];
    		dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][1][0]) + map[i][2];
    		dp[i][2][1] = Math.min(dp[i-1][2][1], dp[i-1][1][1]) + map[i][2];
    	}
    	
    	int max = Math.max(Math.max(dp[N-1][1][0], dp[N-1][0][0]), dp[N-1][2][0]);
    	int min = Math.min(Math.min(dp[N-1][1][1], dp[N-1][0][1]), dp[N-1][2][1]);
    	bw.write(max +" "+ min + "\n");
    	bw.flush();
    }
}
