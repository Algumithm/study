import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int row;
	static int col;
	static int B;
	static int min = Integer.MAX_VALUE;
	static int min_idx = 0;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i <= 256; i++) {
			calc(i);
		}
		bw.write(min + " " + min_idx + "\n");
		bw.flush();
	}
	
	static void calc(int n) {
		int b = B;
		int time = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] >= n) {
					time += (map[i][j]-n)*2;
					b += map[i][j]-n;
				} else {
					time += (n-map[i][j]);
					b -= n-map[i][j];
				}
			}
		}
		if(b >= 0 && time <= min) {
			min_idx = n;
			min = time;
		}
	}

}
