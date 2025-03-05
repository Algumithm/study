import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt = 0;
	static int row;
	static int col;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		visit = new boolean[row][col];
		int start_x = -1;
		int start_y = -1;
		
		for(int i = 0; i < row; i++) {
			String s = br.readLine();
			for(int j = 0; j < col; j++) {
				if(s.charAt(j) == 'O') {
					map[i][j] = 0;
				} else if(s.charAt(j) == 'P') {
					map[i][j] = 1;
				} else if(s.charAt(j) == 'X') {
					map[i][j] = -1;
				} else if(s.charAt(j) == 'I') {
					map[i][j] = 0;
					start_x = i;
					start_y = j;
				}
			}
		}

		dfs(start_x, start_y);
		if(cnt == 0)bw.write("TT\n");
		else bw.write(cnt + "\n");
		bw.flush();
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		if(map[x][y] == 1) cnt++;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(check(nx, ny) && map[nx][ny] >= 0 && !visit[nx][ny])
				dfs(nx, ny);
		}
	}
	
	static boolean check(int x, int y) {
		if(x<0||y<0||x>=row||y>=col) return false;
		else return true;
	}
}
