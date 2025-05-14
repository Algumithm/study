import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int grid[][][] = new int[4][4][2];
	static int max = Integer.MIN_VALUE;
	static int d[][] = {{0, 0}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 1 ↑, 2 ↖ , 3 ←, 4 ↙, 5 ↓, 6 ↘, 7 →, 8 ↗
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				grid[i][j][0] = Integer.parseInt(st.nextToken());
				grid[i][j][1] = Integer.parseInt(st.nextToken());
				// 0은 번호, 1은 방향
			}
		}
		
		int sum = grid[0][0][0];
		int dir = grid[0][0][1];
		grid[0][0][0] = -1;

		dfs(grid, 0, 0, dir, sum);
		
		System.out.println(max);
	}//main

	static void dfs(int[][][] map, int x, int y, int dir, int sum) {
	    max = Math.max(max, sum);

	    map = moveFish(map, x, y);

	    for (int i = 1; i <= 3; i++) {
	        int nx = x + d[dir][0] * i;
	        int ny = y + d[dir][1] * i;

	        if (isEdge(nx, ny)) break;
	        if (map[nx][ny][0] <= 0) continue;

	        int[][][] newMap = copyMap(map);

	        int fishNum = newMap[nx][ny][0];
	        int sharkDir = newMap[nx][ny][1];

	        newMap[x][y][0] = 0; 
	        newMap[nx][ny][0] = -1;
	        dfs(newMap, nx, ny, sharkDir, sum + fishNum);
	    }
	}//dfs(상어가 먹이 고르는 함수)
	
	static int[][][] moveFish(int[][][] map, int sharkX, int sharkY) {
		int[][][] tmap = copyMap(map);
		
		for (int num = 1; num <= 16; num++) {
			int[] fLoc = findFishLoc(tmap, num);
			if (fLoc == null) continue;
			int fx = fLoc[0], fy = fLoc[1];

			int dir = tmap[fx][fy][1];

			for (int i = 0; i < 8; i++) {
				int ndir = (dir + i - 1) % 8 + 1;
				int nx = fx + d[ndir][0];
				int ny = fy + d[ndir][1];

				if (isEdge(nx, ny) || (nx == sharkX && ny == sharkY)) continue;

				//물고기 swap
				int[] temp = tmap[nx][ny];
				tmap[nx][ny] = tmap[fx][fy];
				tmap[nx][ny][1] = ndir;
				tmap[fx][fy] = temp;
				break;
			}
		}
		return tmap;
	}//moveFish
	
	static boolean isEdge(int x, int y) {
		return x < 0 || x > 3 || y < 0 || y > 3;
	}//isEdge

	static boolean canSharkMove(int[][][] map, int x, int y, int dir) {
		for (int i = 1; i <= 3; i++) {
			int nx = x + d[dir][0] * i;
			int ny = y + d[dir][1] * i;
			if (isEdge(nx, ny)) break;
			if (map[nx][ny][0] > 0) return true;
		}
		return false;
	}//canSharkMove?
	
	static int[][][] copyMap(int[][][] map) {
		int[][][] copy = new int[4][4][2];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copy[i][j][0] = map[i][j][0];
				copy[i][j][1] = map[i][j][1];
			}
		}
		return copy;
	}//copyGrid
	
	static int[] findFishLoc(int[][][] map, int num) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j][0] == num) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}//findFishLoc
}
