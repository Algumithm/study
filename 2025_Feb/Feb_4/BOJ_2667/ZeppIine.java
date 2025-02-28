import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[][] MAP;
	static boolean[][] VISITED;
	static int[] HOUSEARR;
	static int SIZE;
	static int COUNT;
	
	static int HOUSECOUNT;

	final static char ROAD = '0';
	final static char HOUSE = '1';
	final static int[][] XY = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	static void checkBlock(int i, int j) {
		if(MAP[i][j] == ROAD) return;
		
		
		VISITED[i][j] = true;
		HOUSECOUNT++;
		
		for(int[] d:XY) {
			int x = i + d[0];
			int y = j + d[1];
			if(x >= 0 && x < SIZE && y >= 0 && y < SIZE && !VISITED[x][y]) {
				checkBlock(x, y);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		SIZE = Integer.parseInt(br.readLine());
		COUNT = 0;
		
		MAP = new char[SIZE][SIZE];
		VISITED = new boolean[SIZE][SIZE];
		HOUSEARR = new int[SIZE*SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			MAP[i] = st.nextToken().toCharArray();
		}
				
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(MAP[i][j] == HOUSE && !VISITED[i][j]) {
					HOUSECOUNT = 0;
					checkBlock(i, j);
					HOUSEARR[COUNT] = HOUSECOUNT;
					COUNT++;
				}
			}
		}

		System.out.println(COUNT);

		Arrays.sort(HOUSEARR);
		
		for(int i = (SIZE*SIZE)-COUNT; i < SIZE*SIZE; i++) {
			System.out.println(HOUSEARR[i]);
		}
		
		br.close();
	}
}
