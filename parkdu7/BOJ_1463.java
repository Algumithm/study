import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int dp[] = new int[N + 1];
        
        for (int i = N - 1; i >= 0; i--) {
        	dp[i] = dp[i + 1] + 1;
        	
			if(i * 2 <= N) { // 2배수가 N안에 있으면
				dp[i] = Math.min(dp[i], dp[i * 2] + 1); // 1뺀거랑 2나눈거랑 비교 
			}
			
			if(i * 3 <= N) { // 3배수가 N 안에 있으면
				dp[i] = Math.min(dp[i], dp[i * 3] + 1); // 1뺀거랑 3나눈거랑 비교 
			}
		}
        
        System.out.println(dp[1]);
	}//main
}
