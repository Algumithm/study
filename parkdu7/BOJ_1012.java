import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int grid[][];
	static boolean visited[][];
	static int N, M, count;
	static int[][] dxdy = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cs = Integer.parseInt(br.readLine());
        
        for (int c = 1; c <= cs; c++) {
        	count = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            grid = new int[N][M];
            visited = new boolean[N][M];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				grid[x][y] = 1;
			}
            
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < M; j++) {
					if(grid[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
            
            System.out.println(count);
        }//case
    }//main
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for (int[] d : dxdy) {
				int nx = temp[0] + d[0];
				int ny = temp[1] + d[1];
				
				if(!isEdge(nx,ny) && !visited[nx][ny] && grid[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.add(new int[] {nx , ny});
				}
			}
		}
		count++;
	}//bfs
	
	static boolean isEdge(int x, int y) {
		return(x < 0 || x >= N || y >= M || y < 0);
	}
}//bj
