import java.util.*;
import java.io.*;

class Main
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[][] card;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		card = new int[N][5];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				card[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int sum = -1;
		for(int a = 0; a < N; a++) {
			for(int b = 0; b < 3; b++) {
				for(int c = b+1; c < 4; c++) {
					for(int d = c+1; d < 5; d++) {
						int sum2 = (card[a][b] + card[a][c] + card[a][d])%10;
						if(sum <= sum2) {
							sum = sum2;
							ans = a;
						}
					}
				}
			}
		} 
		System.out.println(ans+1);
	}
}
