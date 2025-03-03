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
		com(N, M , 0, arr, 1);
	}
	
	static void com(int N, int M, int r, ArrayList<Integer> arr, int idx) {
		if(r == M) {
			for(int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i <= N; i++) {
			if(!visit[i]) {
				arr.add(i);
				visit[i] = true;
				com(N, M, r+1, arr, i);
				visit[i] = false;
				arr.remove(arr.size()-1);
			}
		}
	}
}
