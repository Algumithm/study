import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int[][] dp;
    static int N, min;
    
    public static void main(String[] args) throws Exception {
    	int TC = Integer.parseInt(br.readLine());
    	for(int tc = 1; tc <= TC; tc++) {
	    	N = Integer.parseInt(br.readLine());
	    	map = new int[2][N];
	    	dp = new int[2][N];
	    	for(int i = 0; i < 2; i++) {
	    		st = new StringTokenizer(br.readLine());
	    		for(int j = 0; j < N; j++) {
	    			map[i][j] = Integer.parseInt(st.nextToken());
	    		}	
	    	}
	    	if(N == 1) {
	    		bw.write(Math.max(map[0][0], map[1][0]) + "\n");
	    	} else {
		    	dp[0][0] = map[0][0];
		    	dp[1][0] = map[1][0];
		    	
		    	dp[0][1] = map[1][0] + map[0][1];
		    	dp[1][1] = map[1][1] + map[0][0];
		    	
		    	for(int i = 2; i < N; i++) {
		    		dp[0][i] = Math.max(dp[1][i-2] + map[0][i], dp[1][i-1] + map[0][i]);
		    		dp[1][i] = Math.max(dp[0][i-2] + map[1][i], dp[0][i-1] + map[1][i]);
		    	}
		    	
		    	int max = Math.max(dp[0][N-1], dp[1][N-1]);
		    	bw.write(max+"\n");
	    	}
    	}
    	bw.flush();
    }
}
