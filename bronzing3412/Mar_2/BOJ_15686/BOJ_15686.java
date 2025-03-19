import java.util.*;
import java.io.*;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static ArrayList<node> chicken, house;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	static class node{
		int x;
		int y;
		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[]) throws Exception {
		 st =new StringTokenizer(br.readLine());
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 map = new int[N][N];
		 house = new ArrayList<node>();
		 chicken = new ArrayList<node>();
		 for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0; j < N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
				 if(map[i][j] == 1) {
					 house.add(new node(i, j));
				 } else if(map[i][j] == 2) {
					 chicken.add(new node(i, j));
				 }
			 }
		 }
		 visit = new boolean[chicken.size()];
		 find(M, 0, 0);
		 bw.write(min + "\n");
		 bw.flush();
	}
	
	static void find(int n, int cnt, int idx) {
		if(cnt == n) {
			int sum = 0;
			for(int i = 0; i < house.size(); i++) {
				int min2 = 9999999;
				for(int j = 0; j < chicken.size(); j++) {
					if(visit[j])
						min2 = Math.min(min2, Math.abs(chicken.get(j).x - house.get(i).x) + Math.abs(chicken.get(j).y - house.get(i).y) );
				}
				sum += min2;
			}
			min = Math.min(min, sum);
			return;
		}
		for(int i = idx; i < chicken.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				find(n, cnt+1, i+1);
				visit[i] = false;
			}
		}
	}
}
