import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] grid;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			for (int j = 1; j <= M; j++) {
				grid[i][j] = Character.getNumericValue(temp.charAt(j - 1));
			}
		}
		// dp[i][j] -> i, j 에서 만들 수 있는 가장 큰 정사각형 변의 길이

        int maxL = 0;
        
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (grid[i][j] == 1) {
					  //왼쪽, 위쪽, 왼쪽위대각선  셋 중 가장 작은 변의 길이 + 1
            dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            maxL = Math.max(maxL, dp[i][j]);
        }
			}
		}
		
        System.out.println(maxL * maxL);
	}//main
}
