import java.util.*;
import java.io.*;

class Main
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[][] map, dp;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 0; j <= s.length()-1; j++) {
				map[i][j+1] = s.charAt(j) - '0';
			}
		}
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 1) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1])+1;
					ans = Math.max(dp[i][j], ans);
				}
			}
		}
		System.out.println(ans*ans);
	}
}
