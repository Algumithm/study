import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_n = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= test_n; tc++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);
            
            int[] score = new int[n];
            int[] kcal = new int[n];
            
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                score[i] = Integer.parseInt(input[0]);
                kcal[i] = Integer.parseInt(input[1]);
            }
            
            // dp[j] : 칼로리 j 이하로 섭취할 때 얻을 수 있는 최대 점수
            int[] dp = new int[L + 1];
            
            // 각 재료(아이템)에 대해 DP 배열을 갱신합니다.
            for (int i = 0; i < n; i++) {
                // 0/1 배낭 문제이므로, 뒤에서부터(j = L ~ kcal[i]) 업데이트합니다.
                for (int j = L; j >= kcal[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - kcal[i]] + score[i]);
                }
            }
            
            System.out.println("#" + tc + " " + dp[L]);
        }
    }
}
