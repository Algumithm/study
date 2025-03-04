import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1949 {
	static int SIZE;
	static int TOP;
	static int STRUCT;
	static int[][] MAP;
	static boolean[][] VISITED;
	static int RESULT;
	
	final static int[][] XY = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	static void hike(int i, int j, int walk) {
		if(walk > RESULT) RESULT = walk;
		
		for(int[] d:XY) {
			int dx = i + d[0];
			int dy = j + d[1];
			
			if(dx >= 0 && dx < SIZE && dy >= 0 && dy < SIZE) {
				if(MAP[dx][dy] < MAP[i][j] && !VISITED[dx][dy]) {
					VISITED[dx][dy] = true;
					hike(dx, dy, walk+1);
					VISITED[dx][dy] = false;
				}
			}
		}
	}
	
	static void findTop(){
		VISITED = new boolean[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(MAP[i][j] == TOP) {
					VISITED[i][j] = true;
					hike(i, j, 1);
					VISITED[i][j] = false;
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			SIZE = Integer.parseInt(st.nextToken());
			STRUCT = Integer.parseInt(st.nextToken());
			
			MAP = new int[SIZE][SIZE];
			
			TOP = 0;
			RESULT = 0;
			
			for(int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < SIZE; j++) {
					MAP[i][j] = Integer.parseInt(st.nextToken());
					if(MAP[i][j] > TOP) TOP = MAP[i][j];
				}
			}
			
			findTop();
			
			for(int k = 1; k <= STRUCT; k++) {
				for(int i = 0; i < SIZE; i++) {
					for(int j = 0; j < SIZE; j++) {
						MAP[i][j] -= k;
						findTop();
						MAP[i][j] += k;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + RESULT);
		}
		br.close();
	}
}
