import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static final int[][] XY = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
		};
		
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int depth;
		
		Node(int x, int y, int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
		
				public int compareTo(Node o) {
						return Integer.compare(this.depth, o.depth);
				}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = Integer.parseInt(br.readLine());
			
			int[][] map = new int[size][size];
			int[][] dist = new int[size][size];
			
			for(int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for(int j = 0; j < size; j++) {
					map[i][j] = line.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
						pq.add(new Node(0, 0, 0));
						dist[0][0] = 0;
						
						int totalDepth = 0;
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				int x = n.x, y = n.y, curDepth = n.depth;
				
				if(x == size-1 && y == size-1) {
					totalDepth = curDepth;
				}
				
				if(dist[x][y] < curDepth) continue;
				
				for(int[] d:XY) {
					int nx = x + d[0], ny = y + d[1];
					if(nx >= 0 && nx < size &&
						ny >= 0 && ny < size) {
						int nextDepth = curDepth + map[nx][ny];
						
						if(nextDepth < dist[nx][ny]) {
							dist[nx][ny] = nextDepth;
							pq.add(new Node(nx, ny, nextDepth));
						}
					}
				}
			}
						
			System.out.println("#" + test_case + " " + totalDepth);
		}
		br.close();
	}
}