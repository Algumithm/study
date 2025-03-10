import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[height][width];
			int[] pw = new int[8];
			int count = 0;
			int x = 0, y = 0;
			
			for(int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				for(int j = 0; j < width; j++) {
					map[i][j] = temp.charAt(j) - '0';
					if(map[i][j] == 1) {
						x = i;
						y = j;
					}
				}
			}
			
			for(int i = y - 55; i <= y;) {
				 if( map[x][i] == 0 &&
					 map[x][i+1] == 0 &&
					 map[x][i+2] == 0) {
					 if( map[x][i+3] == 1 &&
						 map[x][i+4] == 1) {
						 pw[count] = 0;
					 } else {
						 pw[count] = 9;
					 }
				 } else if( map[x][i] == 0 &&
						 	map[x][i+1] == 0) {
					 if( map[x][i+2] == 1 &&
						 map[x][i+3] == 1) {
							 pw[count] = 1;
					 } else {
						 pw[count] = 2;
					 }
				 } else {
					 if( map[x][i+1] == 1 &&
						 map[x][i+2] == 1 &&
						 map[x][i+3] == 1 &&
						 map[x][i+4] == 1) {
						 pw[count] = 3;
					 } else if(  map[x][i+1] == 1 &&
								 map[x][i+2] == 1 &&
								 map[x][i+3] == 1) {
						 pw[count] = 7;
					 } else if(  map[x][i+1] == 1 &&
								 map[x][i+2] == 1) {
						 if( map[x][i+3] == 0 &&
							 map[x][i+4] == 0 &&
							 map[x][i+5] == 0) {
							 pw[count] = 5;
						 } else {
							 pw[count] = 8;
						 }
					 } else {
						 if( map[x][i+2] == 0 &&
							 map[x][i+3] == 0 &&
							 map[x][i+4] == 0) {
							 pw[count] = 4;
						 } else {
							 pw[count] = 6;
						 }
					 }
				 }
				 count++;
				 i += 7;
			}
			
			int checkPW = 0;
			
			checkPW += (pw[0] + pw[2] + pw[4] + pw[6]) * 3;
			checkPW += pw[1] + pw[3] + pw[5] + pw[7];

			int result = 0;
			
			for(int i = 0; i < pw.length; i++) {
				result += pw[i];
			}
			
			if(checkPW % 10 == 0) System.out.println("#" + test_case + " " + result);
			else System.out.println("#" + test_case + " " + 0);
		}
		br.close();
	}
}
