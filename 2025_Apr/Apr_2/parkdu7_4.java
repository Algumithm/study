import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int src, des, weight;
	
	Edge(int s, int d, int w){
		src = s; des = d; weight = w;
	}
}

public class Main {
	static int V, E, startNode;
	static List<Edge>[] adjList;
	static int[] min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		startNode = Integer.parseInt(br.readLine()) - 1; // 0 - based
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		min = new int[V];
		for (int i = 0; i < V; i++) {
			min[i] = Integer.MAX_VALUE; //초기화
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[s - 1].add(new Edge(s - 1, d - 1, w)); // 0 - based
		}
		
		findMinValue();
		
		for (int i = 0; i < V; i++) {
			if (min[i] == Integer.MAX_VALUE) { //도달할 수 없으면
				System.out.println("INF");
				continue;
			}
			System.out.println(min[i]);
		}
	}//main
	
	static void findMinValue() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]); //가중치 기준으로 정렬
		pq.add(new int[] {startNode, 0}); // 첫값은 현재 노드, 두번째 값은 가중치
		boolean[] visited = new boolean[V];
		
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int currentNode = cur[0];
			int weight = cur[1];
			
			if (visited[currentNode]) continue; 
            //PriortyQueu이므로 처음 방문했다면 그게 최솟값이므로 방문처리하고 탐색X
			visited[currentNode] = true;
			
			min[currentNode] = Math.min(min[currentNode], weight);
			for (Edge edge : adjList[currentNode]) {
				if (currentNode == edge.src) {
					pq.add(new int[] {edge.des, weight + edge.weight});
				}
			}
		}
	}
}
