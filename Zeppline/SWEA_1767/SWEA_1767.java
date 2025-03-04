import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int SIZE;
	static int[][] MAP;
	static boolean[][] USED;
	
	static int CORECOUNT;
	static int[][] COREXY;
	
	static int S_CORE;
	static int MIN_WIRE;
	
	final static int CORE = 1;
	final static int[][] XY = {
		{1, 0},
		{-1, 0},
		{0, 1},
		{0, -1}
	};
	
	static void connectWire(int coreCount, int activeCore, int maxWire) {
	    if (coreCount == CORECOUNT) {
	        if (activeCore > S_CORE) {
	            S_CORE = activeCore;
	            MIN_WIRE = maxWire;
	        } else if (activeCore == S_CORE && MIN_WIRE > maxWire) {
	            MIN_WIRE = maxWire;
	        }
	        return;
	    }

	    connectWire(coreCount + 1, activeCore, maxWire);

	    int x = COREXY[coreCount][0];
	    int y = COREXY[coreCount][1];

	    for (int[] d : XY) {
	        int dx = d[0];
	        int dy = d[1];
	        
	        int wireLength = checkWire(x, y, dx, dy);
	        
	        if (wireLength > 0) {
	            setWire(x, y, dx, dy, true);
	            connectWire(coreCount + 1, activeCore + 1, maxWire + wireLength);
	            setWire(x, y, dx, dy, false);
	        }
	    }
	}

	static int checkWire(int x, int y, int dx, int dy) {
	    int length = 0;

	    while (true) {
	        x += dx;
	        y += dy;

	        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return length;
	        if (MAP[x][y] == CORE || USED[x][y]) return 0;

	        length++;
	    }
	}

	static void setWire(int x, int y, int dx, int dy, boolean place) {
	    while (true) {
	        x += dx;
	        y += dy;

	        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) break;

	        USED[x][y] = place;
	    }
	}

	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			SIZE = Integer.parseInt(br.readLine());
			MAP = new int[SIZE][SIZE];
			
			S_CORE = 0;
			MIN_WIRE = Integer.MAX_VALUE;
			USED = new boolean[SIZE][SIZE];
						
			CORECOUNT = 0;
			COREXY = new int[13][2];
			
			StringTokenizer st;
			for(int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < SIZE; j++) {
					MAP[i][j] = Integer.parseInt(st.nextToken());
					if(	MAP[i][j] == CORE &&
						i != 0 && i != SIZE-1 &&
						j != 0 && j != SIZE-1) {
						COREXY[CORECOUNT][0] = i;
						COREXY[CORECOUNT][1] = j;
						CORECOUNT++;
					}
				}
			}

			connectWire(0, 0, 0);
			
			System.out.println("#" + test_case + " " + MIN_WIRE);
		}
		br.close();
	}
}
