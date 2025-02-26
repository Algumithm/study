package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501_dp {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1]; 
        int[] P = new int[N + 1]; 
        int[] dp = new int[N + 2]; 

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            //안 하는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            //하는 경우
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

    		for (int ㅏ = 1; ㅏ < dp.length; ㅏ++) {
    			System.out.print(dp[ㅏ] + " ");
    		}
    		System.out.println();
        }

        System.out.println(dp[N + 1]);
		
	}//main
	
}//bj14501
