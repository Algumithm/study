import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] MAP;
	
	static int SIZE;
	
	static int RESULT = Integer.MIN_VALUE;
	
	static void work(int index, int money) {
		if (index >= SIZE) {
            RESULT = Math.max(RESULT, money);
            return;
        }
		if(index + MAP[index][0] <= SIZE) {
			work(index + MAP[index][0], money + MAP[index][1]);
		}
		work(index+1, money);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SIZE = Integer.parseInt(br.readLine());
		
		MAP = new int[SIZE][2];
		
		for(int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		work(0, 0);
		
		System.out.println(RESULT);
		
		br.close();
	}
}
