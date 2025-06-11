import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[T + 1]; // 1-based
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[T + 1][W + 1];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                int currentTree = w % 2 == 0 ? 1 : 2; // 현재 위치한 나무 : 이동 횟수 짝수면 1번 홀수면 2번
                int get = arr[t] == currentTree ? 1 : 0; // t초에 현재 위치한 나무에서 자두를 얻을 수 있는지

                if (w == 0) {
                    dp[t][w] = dp[t - 1][w] + get;
                } else {
                    dp[t][w] = Math.max(dp[t - 1][w], dp[t - 1][w - 1]) + get;
                }
            }
//        	debug();
        }

        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(max, dp[T][w]);
        }

        System.out.println(max);
        
        
    }
    
    public static void debug() {
    	for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
    	System.out.println();
    }
}
