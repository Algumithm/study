import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        // 1. DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 2. LCS 길이 출력
        System.out.println(dp[n][m]);

        // 3. LCS 문자열 역추적
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lcs.append(A.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // LCS는 뒤에서부터 만들어졌기 때문에 뒤집어서 출력
        System.out.println(lcs.reverse().toString());
    }
}
