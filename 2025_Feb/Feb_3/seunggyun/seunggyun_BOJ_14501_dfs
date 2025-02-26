package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501_dfs {
	static int max = Integer.MIN_VALUE;
	static int N;
	static int[] T;
	static int[] P;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	
	    T = new int[N + 1]; 
	    P = new int[N + 1]; 
	
	    for (int i = 1; i <= N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        T[i] = Integer.parseInt(st.nextToken());
	        P[i] = Integer.parseInt(st.nextToken());
	    }
	    dfs(1, 0);
	    System.out.println(max);
	}
	
	
	static void dfs(int idx, int count) {
		if(idx > N) {
			max = Math.max(max, count);
			return;
		}
		
		// 한 경우
		if (idx + T[idx] <= N + 1) { 
            dfs(idx + T[idx], count + P[idx]);
        }
		// 안 한 경우
		dfs(idx + 1, count);
	}
}
