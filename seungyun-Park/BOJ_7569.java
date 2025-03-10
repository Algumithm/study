import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int[][][] grid;
	static boolean[][][] visited;
	static int[][] dxdydz = { {-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M][H];
		visited = new boolean[N][M][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					grid[i][j][k] = Integer.parseInt(st.nextToken());
					if(grid[i][j][k] == -1)
						visited[i][j][k] = true;
				}
			}	
		}
		
		System.out.println(bfs());
	}//mainn
	
	static int bfs() {
		int count = 0;
		int maxCount = Integer.MIN_VALUE;
		Queue<int[]> q = new LinkedList<>();
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(grid[i][j][k] == 1) {
						q.add(new int[] {i, j, k, count});
						visited[i][j][k] = true;
					}
				}
			}
		}
		while(!q.isEmpty()) {
			int[] crd = q.poll();
			maxCount = Math.max(maxCount, crd[3]);
			
			for(int[] d : dxdydz) {
				int nx = crd[0] + d[0];
				int ny = crd[1] + d[1];
				int nz = crd[2] + d[2];
				
				if(!isEdge(nx, ny, nz)) {
					if(!visited[nx][ny][nz]) {
						q.add(new int[] {nx, ny, nz, crd[3] + 1});
						visited[nx][ny][nz] = true;
					}
				}
			}
		}

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!visited[i][j][k])
						return -1;
				}
			}
		}
		
		return maxCount;
	}//bfs
	
	static boolean isEdge(int x, int y, int z) {
		return( x >= N || x < 0 || y >= M || y < 0 || z < 0 || z >= H);
	}//isEdge
	
}//bj
