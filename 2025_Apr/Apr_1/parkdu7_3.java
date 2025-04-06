import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] grid;
	static int count;
	static boolean visited[][];
	static int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visited = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, grid[i][j]);
					count++;
				}
			}
		}
		
		System.out.print(count + " ");

		//적록색약인 사람이 볼때 G -> R로 수정
		visited = new boolean[N][N]; //visited 초기화
		count = 0; //count 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(grid[i][j] == 'G')
					grid[i][j] = 'R';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, grid[i][j]);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}//main
	
	static void dfs(int x, int y, char c) {
		visited[x][y] = true;
      
		for (int[] d : dxdy) {
			int nx = x + d[0];
			int ny = y + d[1];
			
			if(!isEdge(nx, ny) && !visited[nx][ny] && grid[nx][ny] == c) {
				visited[nx][ny] = true;
				dfs(nx, ny, c);
			}
		}
	}//dfs
	
	static boolean isEdge(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N);
	}
}
