import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] WORK;
	static double RESULT;
	
	static void maxWork(int[] workNum, int k, double current) {
		if (current <= RESULT) return;
		
		if(k == workNum.length) {
			RESULT = Math.max(current, RESULT);
			return;
		}
		
		for(int i = 0; i < workNum.length; i++) {
			boolean check = false;
			for(int j:workNum) {
				if(i == j) {
					check = true;
					break;
				}
			}
			if(!check) {
				workNum[k] = i;
				maxWork(workNum, k+1, current * WORK[i][k] / 100);
				workNum[k] = -1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			WORK = new int[N][N];
			RESULT = Double.MIN_VALUE;
			
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					WORK[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] workNum = new int[N];
			
			for(int i = 0; i < workNum.length; i++) {
				workNum[i] = -1;
			}
			
			maxWork(workNum, 0, 100.0);
			System.out.printf("#%d %.6f\n", test_case, RESULT);
		}
		br.close();
	}
}
