import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int SIZE;
	static int LEN;
	static int RESULT;
	static int[][] MAP;
	
	static void swap(int i, int j) {
		int temp = MAP[i][j];
		MAP[i][j] = MAP[j][i];
		MAP[j][i] = temp;
	}
	
	static void rotate() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(j > i) swap(i, j);
			}
		}
	}
	
	static boolean checkFlat(int[] list, int i, int j) {
		for(int x = i; x < j; x++) {
			if(list[x] != list[x+1]) return false;
		}
		return true;
	}
	
	static boolean checkAngle(boolean[] list, int i, int j) {
		for(int x = i; x <= j; x++) {
			if(list[x]) return false;
		}
		return true;
	}
	
	static void checkRunway(int idx, int len) {
		boolean[] angle = new boolean[SIZE];
		int[] runway = MAP[idx];
		
		// 맨 끝 칸이 낮은 경우는 무슨 수를 써도 불가능함
		if(runway[0] < runway[1] || runway[SIZE-2] > runway[SIZE-1]) return;
		
		// 경사로 길이 만큼 파인 경우 경사로를 놓아도 의미가 없음
		for(int i = 0; i < SIZE-(len+1); i++) {
			if(	runway[i] == runway[i+len+1] &&
				runway[i] > runway[i+1] && 
				runway[i+len] < runway[i+len+1]) {
				return;
			}
		}
		
		for(int i = 0; i < SIZE-LEN; i++) {
			// 경사로+1칸이 평평한 경우
			if(checkFlat(runway, i, i+len)) continue;
			// 경사로+1칸 중 마지막 칸이 높은 경우
			else if(runway[i] > runway[i+1] &&
					runway[i] - runway[i+1] == 1 &&
					checkAngle(angle, i+1, i+len) &&
					checkFlat(runway, i+1, i+len)) {
				for(int x = i+1; x <= i+len; x++) {
					angle[x] = true;
				}
			}
			// 경사로+1칸 중 첫번째 칸이 높은 경우
			else if(runway[i+len-1] < runway[i+len] &&
					runway[i+len] - runway[i+len-1] == 1 &&
					checkAngle(angle, i, i+len-1) &&
					checkFlat(runway, i, i+len-1)) {
				for(int x = i; x <= i+len-1; x++) {
					angle[x] = true;
				}
			}
		}
		
		int road = runway[0];
		for(int i = 1; i < SIZE; i++) {
			if(runway[i] == road) continue;
			if(road > runway[i] && angle[i] ||
				road < runway[i] && angle[i-1]) road = runway[i];
			else return;
		}
		
		RESULT++;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			SIZE = Integer.parseInt(st.nextToken());
			LEN = Integer.parseInt(st.nextToken());
			RESULT = 0;
			
			MAP = new int[SIZE][SIZE];
			
			for(int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < SIZE; j++) {
					MAP[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < SIZE; i++) {
				checkRunway(i, LEN);
			}
			
			rotate();

			for(int i = 0; i < SIZE; i++) {
				checkRunway(i, LEN);
			}
			
			System.out.println("#" + test_case + " " + RESULT);
		}
		br.close();
	}
}
