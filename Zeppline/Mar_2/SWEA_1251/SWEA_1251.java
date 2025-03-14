import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Node implements Comparable<Node>{
		int index;
		double cost;
		
		Node(int index, double cost){
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = Integer.parseInt(br.readLine());
			
			long[][] island = new long[size][2];
			
			double[][] graph = new double[size][size];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer	st2 = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < size; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
				island[i][1] = Integer.parseInt(st2.nextToken());
			}
			
			double tax = Double.parseDouble(br.readLine());
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(i == j) continue;
					long xdist = island[i][0] - island[j][0];
					long ydist = island[i][1] - island[j][1];
                    double dist = Math.sqrt(xdist * xdist + ydist * ydist);
                    graph[i][j] = tax * dist * dist;
				}
			}
			
			boolean[] visited = new boolean[size];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0.0));

            double totalCost = 0.0;

            while (!pq.isEmpty()) {
                Node n = pq.poll();
                int cur = n.index;

                if (visited[cur]) continue;
                visited[cur] = true;
                totalCost += n.cost;

                for (int i = 0; i < size; i++) {
                    if (!visited[i] && graph[cur][i] > 0) {
                        pq.add(new Node(i, graph[cur][i]));
                    }
                }
            }
            
			System.out.println("#" + test_case + " " + Math.round(totalCost));
		}
		br.close();
	}
}
