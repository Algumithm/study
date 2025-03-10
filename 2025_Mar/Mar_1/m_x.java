
import java.util.*;
import java.io.*;

class Node{
	int x;
	int y;
	int count;
	public Node(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
public class Main {
	
	
	static int n;
	static int m;
	static int [][] a;
	static boolean [][] visited;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,-1,1};
	static int [][] b;
	static ArrayDeque<Node> queue;
	static boolean in_range(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) {
			return true;
		}
		return false;
	}
	static void BFS() {  //기본적인 bfs구현이라 큰 설명은 생략
		while(!queue.isEmpty()) {
			for(int k = 0;k<4;k++) {
				int x = queue.getFirst().x + dx[k];
				int y = queue.getFirst().y + dy[k];
				if(in_range(x, y) && !visited[x][y] && a[x][y] != 0) {
					visited[x][y] = true;
					b[x][y] = queue.getFirst().count + 1;
					queue.addLast(new Node(x, y, queue.getFirst().count + 1));
				}
			}
			queue.pollFirst();
		}
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		b = new int[n][m];
		visited = new boolean[n][m];
		queue = new ArrayDeque<Node>();
		for(int i  =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] == 2) {  // 2인 곳에서 출발해야하니까 그곳의 좌표를 큐에 넣어줌
					queue.add(new Node(i,j,0));
					visited[i][j] = true;
				}
			}
		}
		BFS();
		for(int i  =0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(!visited[i][j] && a[i][j] != 0) {   // 방향이 가로막혀있는곳은 방문하지않았고 0이 아닌지점이다 이럴떈 -1 출력
					bw.write(-1 + " ");
				}
				else {
					bw.write(b[i][j] + " ");
				}
			}
			bw.write("\n");
		}
		bw.close();
	}
}
