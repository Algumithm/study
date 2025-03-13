//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cs = Integer.parseInt(br.readLine()); 
		for (int c = 1; c <= cs; c++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (parent[i] == i) count++;
			}

			System.out.println("#" + c + " " + count);
		}
	}//main

	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}//find

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) parent[rootB] = rootA;
	}//union
	
}//swea
