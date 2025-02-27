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
    	
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	num = new int[N+1];
    	dp = new int[N+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= N; i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		dp[i] = dp[i-1] + num[i];
    	}
    	
    	for(int i = 1; i <= M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int sum = dp[b]-dp[a-1];
    		
    		bw.write(sum+"\n");
    	}
    	
    	bw.flush();
    }
}
