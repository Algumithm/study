import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] grid;
	static boolean[][] visited;
	static int[][] dxdy = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == -1)
					visited[i][j] = true;
			}
		}
		
		System.out.println(bfs());
	}//mainn
	
	static int bfs() {
		int count = 0;
		int maxCount = Integer.MIN_VALUE;
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(grid[i][j] == 1) {
					q.add(new int[] {i, j, count});
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] crd = q.poll();
			maxCount = Math.max(maxCount, crd[2]);
			
			for(int[] d : dxdy) {
				int nx = crd[0] + d[0];
				int ny = crd[1] + d[1];
				
				if(!isEdge(nx, ny)) {
					if(!visited[nx][ny]) {
						q.add(new int[] {nx, ny, crd[2] + 1});
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j])
					return -1;
			}
		}
		
		return maxCount;
	}//bfs
	
	static boolean isEdge(int x, int y) {
		return( x >= N || x < 0 || y >= M || y < 0);
	}//isEdge
	
}//bj
