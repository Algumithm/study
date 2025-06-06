import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static boolean[][] visit;
	static int[][] dis;
	static StringTokenizer st;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		map = new int[row+1][col+1];
		visit = new boolean[row+1][col+1];
		dis = new int[row+1][col+1];
		for(int i = 1; i <= row; i++) {
			String s = br.readLine();
			for(int j = 1; j <= col; j++) {
				map[i][j] = s.charAt(j-1) - '0';
			}
		}
		bfs(1,1);
		bw.write(dis[row][col] + "\n");
		bw.flush();
	}
	
	static void bfs(int x, int y) {
		dis[x][y] = 1;
		q.add(new int[] {x, y});
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			x = temp[0];
			y = temp[1];
			for(int i = 0; i < 4; i++) {
				int newx = x+dx[i];
				int newy = y+dy[i];
				if(check(newx, newy) && !visit[newx][newy] && map[newx][newy] == 1) {
					visit[newx][newy] = true;
					q.add(new int[] {newx, newy});
					dis[newx][newy] = dis[x][y]+1;
				}
			}
		}
	}
	
	static boolean check(int newx, int newy) {
		if(newx < 0 || newy < 0 || newx >= visit.length || newy >= visit[0].length) return false;
		else return true;
	}
}
