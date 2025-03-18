import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ob[] bag;
    static int[][] dp;
    static class ob {
    	int wei;
    	int value;
    	
    	ob(int wei, int value) {
    		this.wei = wei;
    		this.value = value;
    	}
    }
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	bag = new ob[N+1];
    	dp = new int[N+1][K+1];
    	
    	for(int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		bag[i] = new ob(a, b);
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 0; j <= K; j++) {
    			if(bag[i].wei > j) {
    				dp[i][j] = dp[i-1][j];
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bag[i].wei] + bag[i].value);
    			}
    		}
    	}
    	
    	bw.write(dp[N][K] + "\n");
    	
    	bw.flush();
    }
}
