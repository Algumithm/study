import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class bj10026 {
	static int COUNT;
	static int SIZE;
	static char[][] PAINTING;
	static boolean[][] VISITED;
	
	final static int[][] XY = {
		{1, 0},
		{-1, 0},
		{0, 1},
		{0, -1}
	};
	
	static void seePainting() {
    	COUNT = 0;
        VISITED = new boolean[SIZE][SIZE];
        
        for(int i = 0; i < SIZE; i++) {
        	for(int j = 0; j < SIZE; j++) {
        		if(!VISITED[i][j]) {
        			COUNT++;
        			checkColor(i, j, PAINTING[i][j]);
        		}
        	}
        }
        
        System.out.print(COUNT);
	}
	
	static void checkColor(int x, int y, char color) {
		VISITED[x][y] = true;
		if(color == 'G') PAINTING[x][y] = 'R';
		
		for(int[] d:XY) {
			int nx = d[0] + x;
			int ny = d[1] + y;
			if(	nx >= 0 && nx < SIZE &&
				ny >= 0 && ny < SIZE &&
				!VISITED[nx][ny] &&
				PAINTING[nx][ny] == color) {
				checkColor(nx, ny, color);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        SIZE = Integer.parseInt(br.readLine());
        
        PAINTING = new char[SIZE][SIZE];
        
        for(int i = 0; i < SIZE; i++) {
        	PAINTING[i] = br.readLine().toCharArray();
        }
        
        // R, G, B 구역별 dfs
        seePainting();
        
    	System.out.print(" ");
		    	
		// R, B 구역별 dfs
        seePainting();

        br.close();
    }
}
