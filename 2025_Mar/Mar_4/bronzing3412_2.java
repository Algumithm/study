import java.util.*;
import java.io.*;

class Main
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] tree;
	static ArrayList<Integer> grow;
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		tree = new int[N];
		grow = new ArrayList<>();
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			sum += tree[i];
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			grow.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(grow);
		for(int i = 0; i < N; i++) {
			sum += grow.get(i)*(i);
		}
		System.out.println(sum);
	}
}
