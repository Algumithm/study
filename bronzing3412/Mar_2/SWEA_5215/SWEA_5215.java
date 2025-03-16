import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] ham;
	static int max;
	static int N, L;
	public static void main(String[] args) throws Exception{
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++ ) {
			bw.write("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ham = new int[N][2];
			max = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ham[i][0] = Integer.parseInt(st.nextToken());
				ham[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0);
			
			bw.write(max+"\n");
		}
		bw.flush();
	}
	
	static void dfs(int cur, int sum_score, int sum_cal) {
		if(sum_cal > L) {	
			return;
		}
		max = Math.max(max, sum_score);
		
		if(cur < N) {
			dfs(cur+1, sum_score + ham[cur][0], sum_cal + ham[cur][1]);
			dfs(cur+1, sum_score, sum_cal);
		}
	}
}
