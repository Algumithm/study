import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static boolean[][] visit;
	static StringTokenizer st;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count = 0;
	
	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		visit = new boolean[row][col];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int ld =Integer.parseInt(st.nextToken());
			int lu =Integer.parseInt(st.nextToken());
			int rd =Integer.parseInt(st.nextToken());
			int ru =Integer.parseInt(st.nextToken());
			input(ld, lu, rd, ru);
		}
		
		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visit[i][j]) {
					cnt++;
					dfs(i, j);
					arr.add(count);
					count = 0;
				}
				
			}
		}
		arr.sort(null);
		bw.write(cnt + "\n");
		for(int i = 0; i < arr.size(); i++) {
			bw.write(arr.get(i) + " ");
		}
		bw.flush();
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		count++;
		for(int i = 0; i < 4; i++) {
			int newx = x+dx[i];
			int newy = y+dy[i];
			if(check(newx, newy) && !visit[newx][newy]) {
				dfs(newx, newy);
			}
		}
	}
	
	static void input(int ld, int lu, int rd, int ru) {
		for(int i = lu; i < ru; i++) {
			for(int j = ld; j < rd; j++) {
				visit[i][j] = true;
			}
		}
	}
	
	static boolean check(int newx, int newy) {
		if(newx < 0 || newy < 0 || newx >= visit.length || newy >= visit[0].length) return false;
		else return true;
	}
}
