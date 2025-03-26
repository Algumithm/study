package algo.boj;

import java.util.*;
import java.io.*;

public class BOJ_9251{
	static char[] str1;
	static char[] str2;
	static Integer[][] dp;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();

		//dp 테이블 초기화
		dp = new Integer[str1.length][str2.length];

		System.out.println(lcs(str1.length-1, str2.length-1));
	}
	public static int lcs(int a, int b) {
		// 문자열 인덱스가 범위 벗어나면 0 반환
		if(a<0||b<0)
			return 0;
		// dp 테이블에 값 없으면 계산
		if(dp[a][b]==null) {
			dp[a][b]=0;
			// 두 문자 같으면 이전 인덱스의 LCS 결과를 +1
			if(str1[a] == str2[b]){
				dp[a][b] = lcs(a-1, b-1)+1;
			}	
			else{ // 두 문자 다르면 왼쪽 또는 위쪽 값 중 최댓값 선택
				dp[a][b] = Math.max(lcs(a-1,b), lcs(a,b-1));
			}
		}
		// 계산된 값 반환
		return dp[a][b];
	}
}
