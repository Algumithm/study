import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int cntb = 0;
	static int cntw = 0;
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, N);
		bw.write(cntw+"\n");
		bw.write(cntb+"\n");
		bw.flush();
	}
	
	static void dfs(int row, int col, int N) {
		if(check_b(row, col, N)) {
			cntb++;
			return;
		}
		
		if(check_w(row, col, N)) {
			cntw++;
			return;
		}
		
		dfs(row+N/2, col, N/2);
		dfs(row+N/2, col+N/2, N/2);
		dfs(row, col, N/2);
		dfs(row, col+N/2, N/2);
	}
	
	static boolean check_b(int row, int col, int N) {
		for(int i = row; i < row+N; i++) {
			for(int j = col; j < col+N; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static boolean check_w(int row, int col, int N) {
		for(int i = row; i < row+N; i++) {
			for(int j = col; j < col+N; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
}
