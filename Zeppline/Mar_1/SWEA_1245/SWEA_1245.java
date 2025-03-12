import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int COUNT;
	static double[] BALANCE;
	static int[][] ASTEROID;
	
	static final double EPSILON = 1e-13;
	
	static double getPower(int astIdx, double balancePoint) {
		double dist = Math.abs(ASTEROID[astIdx][0] - balancePoint);
		double power = ASTEROID[astIdx][1] / Math.pow(dist, 2);
		return power;
	}
	
	static void findBalancePoint(int astIdx, double prev, double cur, double next) {
		double prevPower = 0, nextPower = 0;; 
		for(int i = 0; i <= astIdx; i++) {
			prevPower += getPower(i, cur);
		}
		for(int i = astIdx+1; i < COUNT; i++) {
			nextPower += getPower(i, cur);
		}
		
		if(Math.abs(prevPower - nextPower) < EPSILON) {
			BALANCE[astIdx] = cur;
			return;
		}
		
		double center = 0.0;
		if(prevPower > nextPower) center = Math.abs(cur + next)/2;
		else if(prevPower < nextPower) center = Math.abs(prev + cur)/2;
		
		if (Math.abs(cur - center) < EPSILON) {
            BALANCE[astIdx] = center;
            return;
        }
		
		if(prevPower > nextPower) findBalancePoint(astIdx, cur, center, next);
		else if(prevPower < nextPower) findBalancePoint(astIdx, prev, center, cur);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			COUNT = Integer.parseInt(br.readLine());
			
			ASTEROID = new int[COUNT][2];
			BALANCE = new double[COUNT-1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < COUNT; i++) {
				ASTEROID[i][0] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < COUNT; i++) {
				ASTEROID[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < BALANCE.length; i++) {
				double center = Math.abs(ASTEROID[i][0] + ASTEROID[i+1][0])/2;
				findBalancePoint(i, ASTEROID[i][0], center, ASTEROID[i+1][0]);
			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < BALANCE.length; i++) {
				System.out.printf("%.10f ", BALANCE[i]);
			}
			System.out.println();
		}
		br.close();
	}
}
