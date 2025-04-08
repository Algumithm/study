import java.util.*;
import java.io.*;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, T;
	static int[][] p;
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			p = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				p[i][0] = a;
				p[i][1] = b;
			}
			Arrays.sort(p, (o1, o2) -> Integer.compare(o1[1], o2[1]));
			int cnt = 0;
			int min = 999999;
			for(int i = 0; i < N; i++) {
				if(p[i][0] < min) {
					cnt++;
					min = Math.min(p[i][0], min);
				}
			}
			System.out.println(cnt);
		} 
	}
}
