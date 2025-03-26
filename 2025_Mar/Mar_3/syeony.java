package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9251_LCS {
	static Integer[][] dp;
	static String line1, line2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		line1=br.readLine();
		line2=br.readLine();
		
		dp=new Integer[line1.length()][line2.length()];
		
		System.out.println(lcs(line1.length()-1,line2.length()-1));
	}
	
	static int lcs(int a, int b) {
		if(a<0 || b<0) {
			return 0;
		}
		
		if(dp[a][b]==null) {
			dp[a][b]=0;
			if(line1.charAt(a)==line2.charAt(b)) {
				dp[a][b]=lcs(a-1,b-1)+1;
			}else {
				dp[a][b]=Math.max(lcs(a-1,b), lcs(a,b-1));
			}
		}
		return dp[a][b];
	}
}
