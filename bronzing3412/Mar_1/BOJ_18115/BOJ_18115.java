import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Deque<Integer> dq = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
			
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for(int i = N; i > 0; i--) {
			int a = Integer.parseInt(st.nextToken());
			arr[i-1] = a;
		}
		
		for(int i = 1; i <= N; i++) {
			int a = arr[i-1];
			if(a == 1) {
				dq.addFirst(i);
			} else if(a == 2) {
				int b = dq.pollFirst();
				dq.addFirst(i);
				dq.addFirst(b);
			} else if(a == 3) {
				dq.addLast(i);
			}
		}
		for(int i = 0; i < N; i++) {
			bw.write(dq.pollFirst() + " ");
		}
		bw.flush();
	}

}
