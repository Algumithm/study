import java.util.Arrays;

public class Solution {

	final int MAX = Integer.MAX_VALUE;
	
    public int solution(int[][] info, int n, int m) {
        int answer = MAX;
        
        int len = info.length;

        int[][] dp = new int[len + 1][m];
        for (int[] row : dp) Arrays.fill(row, MAX);
        dp[0][0] = 0;

        for (int i = 0; i < len; i++) {
            int aCost = info[i][0];
            int bCost = info[i][1];

            for (int b = 0; b < m; b++) {
                if (dp[i][b] == MAX) continue;

                if (dp[i][b] + aCost < n) {
                    dp[i + 1][b] = Math.min(dp[i + 1][b], dp[i][b] + aCost);
                }

                if (b + bCost < m) {
                    dp[i + 1][b + bCost] = Math.min(dp[i + 1][b + bCost], dp[i][b]);
                }
            }
        }
        for (int b = 0; b < m; b++) answer = Math.min(answer, dp[len][b]);

        return (answer == MAX) ? -1 : answer;
    }
}