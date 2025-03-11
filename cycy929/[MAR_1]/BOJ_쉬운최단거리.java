package algo_0310;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_쉬운최단거리 {  // 실버1 백준 14940 쉬운 최단거리
	static int n,m,sx,sy;
	static int [][] arr;
	static int [][] visited;
	static int [][] count;
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	static StringBuilder sb = new StringBuilder();
	static class Node{
		int x,y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) { // 0은 갈수없음 .1은 갈수있음. 2목표지점
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new int [n][m];
		arr = new int[n][m];
		count = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs(sx,sy);
		
		arr[sx][sy] = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(visited[i][j]==0 && arr[i][j] == 1)
					sb.append(-1 + " ");
				else {
					sb.append(count[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	static boolean in_range(int x, int y) {
		return (x>=0 && y>=0 && x<n && y<m);
	}
	
	static void bfs(int x, int y) {  //bfs
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x,y));
		visited[x][y] = 1;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			for(int i = 0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(in_range(nx, ny)) {
				if(arr[nx][ny]==0) continue;
				if(visited[nx][ny]==1) continue;
				
				queue.offer(new Node(nx,ny));
				count[nx][ny] = count[node.x][node.y]+1;
				visited[nx][ny] = 1;
				
			}
			
		}
	}
}
}
