package algumi;

import java.util.Scanner;

public class Main {  // 골드5 9251
    static int[][] memo;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int len1 = str1.length();
        int len2 = str2.length();

        memo = new int[len1 + 1][len2 + 1];

        // 초기화
        for (int i = 0; i <= len1; i++)
            for (int j = 0; j <= len2; j++)
                memo[i][j] = -1;

        lcs(str1, str2, len1, len2);

        System.out.println(result);
    }

    static void lcs(String s1, String s2, int m, int n) {
        // 이미 계산한 값이면 반환
        if (memo[m][n] != -1) return;

        if (m == 0 || n == 0) {
            memo[m][n] = 0;
            return;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            lcs(s1, s2, m - 1, n - 1);
            memo[m][n] = 1 + memo[m - 1][n - 1];
        } else {
            lcs(s1, s2, m - 1, n);
            lcs(s1, s2, m, n - 1);
            memo[m][n] = Math.max(memo[m - 1][n], memo[m][n - 1]);
        }
        result = memo[m][n];
    }
}
