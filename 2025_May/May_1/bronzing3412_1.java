import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int TC, N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {	
		TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i+=2) {
				if(i+2 < N) 
					max = Math.max(max, arr[i+2]-arr[i]);
			}
			for(int i = 1; i < N; i+=2) {
				if(i+2 < N)
					max = Math.max(max, arr[i+2]-arr[i]);
			}
			bw.write(max + "\n");
		}
		bw.flush();
	}
}
