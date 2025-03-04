import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				if(q.isEmpty()) bw.write(0 + "\n");
				else bw.write(q.poll()+"\n");
			}
			else q.add(a);
		}
		bw.flush();
	}
}
