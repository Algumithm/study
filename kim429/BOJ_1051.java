package swea;

import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class BOJ1051 {
	static int[][] square;
	static int[][] array = new int[2][4];
	static int N;
	static int M;
	static int side;
	static int max_side;
	static int num;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		square = new int[N][M];
		
		if(N > M) {
			side = N;
			max_side = N;
		} else {
			side = M;
			max_side = M;
		}
		
		answer = 1;

		for (int i = 0; i < N; i++) {
			String stt = br.readLine();
			for (int j = 0; j < M; j++) {
				square[i][j] = Character.getNumericValue(stt.charAt(j));
			}
		}

		for (int i = 0; i < side -1; i++) {
			search(side - i -1);
			if (answer > 1) {
				break;
			}
		}
		System.out.println(answer);
	}

	static void search(int num) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i+num > N-1 || j+num > M-1) {
					break;
				}
				if(square[i][j] == square[i + num][j] && square[i+num][j] == square[i][j+num] && square[i][j +num] == square[i+num][j+num]) {
					answer = (num+1) * (num+1);
				}
			}
		}
	}
}
