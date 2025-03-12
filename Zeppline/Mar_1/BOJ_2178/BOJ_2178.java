import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int WALL = 0;
	final static int ROAD = 1;
	
	final static int[][] XY = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	
	static class Node{
		int x;
		int y;
		int len;
		
		Node(int x, int y, int len){
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';	
			}
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 1));
		visited[0][0] = true;
		
		int result = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.x == N-1 && n.y == M-1) result = n.len;
			
			for(int[] d:XY) {
				int x = n.x + d[0], y = n.y + d[1];
				if(	x >= 0 && x < N &&
					y >= 0 && y < M &&
					!visited[x][y] &&
					map[x][y] == ROAD) {
					visited[x][y] = true;
					q.offer(new Node(x, y, n.len+1));
				}
			}
		}
		System.out.println(result);
		
		br.close();
	}
}
