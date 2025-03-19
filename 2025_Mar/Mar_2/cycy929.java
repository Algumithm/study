package algo;

import java.util.Scanner;

public class Main0316_외판원순회2 {    //백준 10971 외판원 순회2
	static int n;
	static int [][]w;
	static boolean [] visited;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = new int [n+1][n+1];
		visited = new boolean [n+1];
		min = Integer.MAX_VALUE;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				w[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		visited[1]=true;
		dfs(1,1,1,0);
		
		
		System.out.println(min);
	}
	static void dfs(int cnt, int start, int now, int cost) {
		if(cost>=min) return;
		
		if(cnt==n && w[now][start]>0) {
			min = Math.min(min, cost + w[now][start]);
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i] && w[now][i]>0) {
				visited[i] = true;
				dfs(cnt+1, start, i,cost + w[now][i]);
				visited[i] = false;
			}
		}
	}
	
}
