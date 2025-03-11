package swea;

import java.util.*;
import java.io.*;

public class BOJ2578 {
	static int[][] empty = new int[5][5];
	static int[] speak = new int[25];
	static boolean bingo = false;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] bingo_list = new int[5][5];

		for(int i = 0; i < 5 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5 ; j++) {
				bingo_list [i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자가 부르는 숫자 입력
		for (int i = 0; i < 5; i++) {
		    st = new StringTokenizer(br.readLine()); // 한 줄에 5개 숫자 입력
		    for (int j = 0; j < 5; j++) {
		        speak[i * 5 + j] = Integer.parseInt(st.nextToken()); // 1차원 배열에 저장
		    }
		}

		
		for(int n = 0; n < 25; n++) {
			for(int i = 0; i < 5 ; i++) {
				for(int j = 0; j < 5 ; j++) {
					if(bingo_list[i][j] == speak[n]) {
						empty[i][j] = 1;
					}
				}
			}
			count = 0;
			garo();
			sero();
			cros();
			reverse_cros();
			
			if(count >= 3) {
				System.out.println(n+1);
				break;
			}
		}
	}
	
	static void garo() {
		for(int i = 0; i < 5 ; i++) {
			bingo = true;
			for(int j = 0; j < 5; j++) {
				if(empty[i][j] == 0) {
					bingo = false;
					break;
				}
			}
			if(bingo) {
				count +=1;
			}
		}
	}
	
	static void sero() {
		for(int j = 0; j < 5 ; j++) {
			bingo = true;
			for(int i = 0; i < 5; i++) {
				if(empty[i][j] == 0) {
					bingo = false;
					break;
				}
			}
			if(bingo) {
				count +=1;
			}
		}
	}
	
	static void cros() {
		bingo = true;
		for(int i = 0; i < 5 ; i++) {
			if(empty[i][i] == 0) {
				bingo = false;
				break;
			}
		}
		if(bingo) {
			count +=1;
		}
	}
	
	static void reverse_cros() {
		bingo = true;
		for(int i = 0; i < 5 ; i++) {
			if(empty[4-i][i] == 0) {
				bingo = false;
				break;
			}
		}
		if(bingo) {
			count +=1;
		}
	}
}
