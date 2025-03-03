import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> arr2;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr2 = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			arr2.add(Integer.parseInt(st.nextToken()));
		}
		arr2.sort(null);
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
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(!visit[i] && !arr3.contains(arr2.get(i-1))) {
				arr3.add(arr2.get(i-1));
				visit[i] = true;
				arr.add(arr2.get(i-1));
				com(N, M, r+1, arr, i);
				arr.remove(arr.size()-1);
				visit[i] = false;
			}
		}
	}
}
