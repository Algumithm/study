import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static int[] num; 
	static int[] dp;
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	dp = new int[N+1];
    	if(N <= 1) {
    		bw.write(1+"\n");
    	} else {
    		dp[1] = 1;
	    	for(int i = 2; i <= N; i++) {
	    		int min = Integer.MAX_VALUE;
	    		for(int j = 1; j*j <= i; j++) {
	    			min = Math.min(min, dp[i-j*j]);
	    		}
	    		dp[i] = min+1;
	    	}
	    	bw.write(dp[N]+"\n");
    	}
    	bw.flush();
    }
}
