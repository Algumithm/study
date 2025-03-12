import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920 {
	static int TARGET;
	static int TARGET_NUM;
	static int[] NUMBERS;
	static int RESULT;
	
	static void findNum(int prev, int cur, int next) {
		if(NUMBERS[cur] == TARGET_NUM) {
			RESULT = 1;
			return;
		}
		
		int center = 0;
		if(NUMBERS[cur] > TARGET_NUM) center = (prev + cur)/2;
		else if(NUMBERS[cur] < TARGET_NUM) center = (cur + next)/2;

		if(cur == center) return;
		
		if(NUMBERS[cur] > TARGET_NUM) findNum(prev, center, cur);
		else if(NUMBERS[cur] < TARGET_NUM) findNum(cur, center, next);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		TARGET = Integer.parseInt(br.readLine());
		NUMBERS = new int[TARGET];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < TARGET; i++) {
			NUMBERS[i] = Integer.parseInt(st.nextToken());
		}
		
		int T = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());

		Arrays.sort(NUMBERS);
		
		for(int i = 0; i < T; i++) {
			TARGET_NUM = Integer.parseInt(st.nextToken());
			RESULT = 0;
			int center = TARGET/2;
			findNum(0, center, NUMBERS.length);
			sb.append(RESULT);
			sb.append("\n");
//			System.out.println(RESULT);
		}
		System.out.println(sb);
		br.close();
	}
}
