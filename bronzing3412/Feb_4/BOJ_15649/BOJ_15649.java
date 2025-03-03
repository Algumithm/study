import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		visit = new boolean[N+1];
		per(N, M , 0, arr);
	}
	
	static void per(int N, int M, int r, ArrayList<Integer> arr) {
		if(r == M) {
			for(int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				arr.add(i);
				visit[i] = true;
				per(N, M, r+1, arr);
				visit[i] = false;
				arr.remove(arr.size()-1);
			}
		}
	}
}
