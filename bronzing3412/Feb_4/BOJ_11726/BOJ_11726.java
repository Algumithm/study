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
    	if(N == 1) {
    		bw.write(1+"\n");
    	} else if (N==2) {
    		bw.write(2+"\n");
    	} else {
    		dp[1] = 1;
    		dp[2] = 2;
    		for(int i = 3; i <= N; i++) {
    			dp[i] = (dp[i-1]+dp[i-2])%10007;
    		}
    		bw.write(dp[N]+"\n");
    	}
    	bw.flush();
    }
}
