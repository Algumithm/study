import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int SIZE;
	static int COUNT;
	static int BOTTLE;
	static int[][] HIVE;
	static int[] HONEY;
	
	static int checkHoney(int i, int j, int money, int depth, int now) {
		if(j + COUNT > SIZE) return 0;
		if(depth == COUNT) {
			if(BOTTLE >= now) return money;
			else return 0;
		}
		int nowHoney = 0;
		nowHoney = Math.max(
				checkHoney(i, j, money + HIVE[i][j+depth]*HIVE[i][j+depth], depth+1, now + HIVE[i][j+depth]),
				checkHoney(i, j, money, depth+1, now));
		
		return nowHoney;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			SIZE = Integer.parseInt(st.nextToken());
			COUNT = Integer.parseInt(st.nextToken());
			BOTTLE = Integer.parseInt(st.nextToken());
			
			HIVE = new int[SIZE][SIZE];
			HONEY = new int[SIZE*SIZE];
			
			for(int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < SIZE; j++) {
					HIVE[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i < SIZE; i++) {
				for(int j = 0; j < SIZE; j++) {
					HONEY[(i*SIZE)+j] = checkHoney(i, j, 0, 0, 0);
				}
			}
			
			int result = 0;
			
			for(int i = 0; i < HONEY.length; i++) {
				for(int j = i + COUNT; j < HONEY.length; j++) {
					int temp = HONEY[i] + HONEY[j];
					result = Math.max(result, HONEY[i] + HONEY[j]);
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}
}
