import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] com;
	static boolean[] visit;
	static int cnt = 0;;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
        	int n = Integer.parseInt(br.readLine());
        	int[] dp = new int[n+3];
        	dp[1] = 1;
        	dp[2] = 2;
        	dp[3] = 4;
        	if(n <= 3) bw.write(dp[n]+"\n");
        	else {
	        	for(int i = 4; i <= n; i++) {
	        		dp[i] = dp[i-1] + dp[i-2] +dp[i-3];
	        	}
	        	bw.write(dp[n]+"\n");
        	}
        }
        bw.flush();
    }
}
