import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		List<Integer> rlist = new ArrayList<Integer>();
		
		for (int i = 0; i < T; i++) {
			List<Integer[]> list = new ArrayList<Integer[]>();
			int n = Integer.parseInt(br.readLine());
			for (int l = 0; l < 2; l++) {
				st = new StringTokenizer(br.readLine());
				Integer[] tmp = new Integer[n];
				for (int j = 0; j < n; j++) {
					tmp[j] = Integer.parseInt(st.nextToken()); 
				}
				list.add(tmp);
			}
			//////////////// 입력 ///////////////////
			
			int dp[][] = new int[2][n + 2];

			for (int k = 2; k < n + 2; k++) {
				for (int j = 0; j < 2; j++) {
					int cur = list.get(j)[k - 2];
					if (j == 0) {//위에꺼
						dp[j][k] = Math.max(dp[1][k - 1] + cur, dp[1][k - 2] + cur);
					}
					else { //아래꺼
						dp[j][k] = Math.max(dp[0][k - 1] + cur, dp[0][k - 2] + cur);
					}
				}
			}
			rlist.add(Math.max(dp[0][n + 1], dp[1][n + 1]));
		}//case
		
		for (int i = 0; i < rlist.size(); i++) {
			System.out.println(rlist.get(i));
		}
		
	}//main
}
