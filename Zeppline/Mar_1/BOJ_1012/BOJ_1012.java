import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int GROUND = 0;
	final static int VEGI = 1;
	
	final static int[][] XY = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				map[x][y] = VEGI;
			}
			
			int count = 0;
			
			Queue<Node> q = new LinkedList<Node>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == VEGI && !visited[i][j]) {
						q.offer(new Node(i, j));
						count++;
					}
					while(!q.isEmpty()) {
						Node n = q.poll();
						for(int[] d:XY) {
							int x = n.x + d[0], y = n.y + d[1];
							if(	x >= 0 && x < N &&
								y >= 0 && y < M &&
								!visited[x][y] &&
								map[x][y] == VEGI) {
								visited[x][y] = true;
								q.offer(new Node(x, y));
							}
						}
					}
				}
			}
			System.out.println(count);
		}
		
		br.close();
	}
}
