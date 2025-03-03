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
		bw.flush();
	}
	
	static void com(int N, int M, int r, ArrayList<Integer> arr, int idx) throws Exception{
		if(r == M) {
			for(int i = 0; i < arr.size(); i++) {
				bw.write(arr.get(i) + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr.add(i);
			com(N, M, r+1, arr, i);
			arr.remove(arr.size()-1);
		}
	}
}
