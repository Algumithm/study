import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 빈 문자열은 0개 조각으로 가능

        for (int i = 1; i <= t.length(); i++) {
            for (String s : strs) {
                int len = s.length();
                if (i >= len && t.substring(i - len, i).equals(s) && dp[i - len] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - len] + 1);
                }
            }
        }

        return dp[t.length()] == Integer.MAX_VALUE ? -1 : dp[t.length()];
    }
}
