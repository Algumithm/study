import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String str1 = br.readLine();
	        String str2 = br.readLine();
	        int len1 = str1.length();
	        int len2 = str2.length();

	        int[][] dp = new int[len1 + 1][len2 + 1];

	        for (int i = 1; i <= len1; i++) {
	            for (int j = 1; j <= len2; j++) {
	                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	                    dp[i][j] = dp[i - 1][j - 1] + 1;  // 문자가 같으면 대각선 값 + 1
	                } else {
	                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // 위 or 왼쪽 값 중 최댓값
	                }
	            }
	        }
	        
	        // dp테이블 역으로 조회하면서 String 만들기
	        Stack<Character> result = new Stack<Character>();
	        int i = len1, j = len2;
	        while (i > 0 && j > 0) {
	            if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // 문자가 같으면 추가
	                result.add(str1.charAt(i - 1));
	                i--;
	                j--;
	            } else if (dp[i - 1][j] >= dp[i][j - 1]) { // 위쪽 값이 크면 위로 이동
	                i--;
	            } else { // 왼쪽 값이 크면 왼쪽 이동
	                j--;
	            }
	        }

	        System.out.println(dp[len1][len2]);
	        
	        while(!result.isEmpty()) {
	        	System.out.print(result.pop());
	        }
			
	}
}
