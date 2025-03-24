package study0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0323_마인크래프트 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(min > arr[i][j]) min = arr[i][j];
				if(max < arr[i][j]) max = arr[i][j];
			}
		}
		
		int time = Integer.MAX_VALUE;
		int high = 0;

		for(int i = min; i <= max; i++) {
			int cnt = 0;
			int block = B;
			//좌표 j k
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(i < arr[j][k]) {
						cnt += ((arr[j][k] - i) * 2);
						block += (arr[j][k] - i);
					}else {
						cnt += (i - arr[j][k]);
						block -= (i - arr[j][k]);
					}
				}
			}
			
			if(block < 0) continue;
			
			if(time >= cnt) {
				time = cnt;
				high = i;
			}
		}
		System.out.println(time + " " + high);
	}

}
