import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1, -1, 0};
	static int[] dy = {0, -1, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			strs = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        if (arr[i][j] == 1) {
		            int min = Integer.MAX_VALUE;
		            for (int k = 0; k < 3; k++) {
		                int nx = j + dx[k];
		                int ny = i + dy[k];
		                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
		                    min = Math.min(min, dp[ny][nx]);
		                } else {
		                    min = 0;
		                    break;
		                }
		            }
		            dp[i][j] = min + 1;
		        } else {
		            dp[i][j] = 0;
		        }
		        max = Math.max(max, dp[i][j]);
		    }
		}

		
		
		System.out.println(max*max);
	}
}
