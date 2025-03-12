import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] house;
    static int[][] dp;
    static int N;
    
    public static void main(String[] args) throws Exception {
    	
    	N = Integer.parseInt(br.readLine());
    	house = new int[N][N];
    	dp = new int[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 3; j++) {
    			house[i][j] =Integer.parseInt(st.nextToken());
    		}
    	}
    	dp[0][0] = house[0][0];
    	dp[0][1] = house[0][1];
    	dp[0][2] = house[0][2];
    	
    	for(int i = 1; i < N; i++) {
    		dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
    		dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
    		dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
    	}
    	
    	int min = Integer.MAX_VALUE;
    	min = Math.min(dp[N-1][0], min);
    	min = Math.min(dp[N-1][1], min);
    	min = Math.min(dp[N-1][2], min);
    	bw.write(min+"\n");
        bw.flush();
    }

}
