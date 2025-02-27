import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static int[] stair; 
	static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int TC = Integer.parseInt(br.readLine());
    	for(int tc = 1; tc <= TC; tc++) {
    		int N = Integer.parseInt(br.readLine());
    		long[] dp = new long[N+1];
    		if(N <= 3) {
    			bw.write(1+"\n");
    		} else {
    			dp[1] = 1;
    			dp[2] = 1;
    			dp[3] = 1;
    			
    			for(int i = 4; i <= N; i++) {
    				dp[i] = dp[i-2] + dp[i-3];
    			}
    			bw.write(dp[N] + "\n");
    		}
    		
    	}
    	bw.flush();
    }
}
