import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] grid;
	static boolean[][] visited;
	static int N, M;
	static int[] start = new int[2];
	static int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 2) {
					start[0] = i;
					start[1] = j;
				}
				else if(grid[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
		
		bfs(start[0],start[1], 0);
		
	}//main
	
	static void bfs(int x, int y, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y, cnt});
		visited[x][y] = true;
		grid[x][y] = cnt;
		
		while(!q.isEmpty()) {
			int[] crd = q.poll();
			grid[crd[0]][crd[1]] = crd[2];
			
			for (int[] d: dxdy) {
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
				if(visited[i][j] == false)
					grid[i][j] = -1;
			}
		}
        
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
	}//bfs
	
	static boolean isEdge(int x, int y) {
		return (x >= N || x < 0 || y >= M || y < 0);
	}
}//swea
