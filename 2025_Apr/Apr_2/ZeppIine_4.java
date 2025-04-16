import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1753 {
	
	final static int INF = Integer.MAX_VALUE;

	static class Node{
		int end;
		int weight;
		
		Node(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	
    public static void main(String[] args) throws Exception {
    	
    	System.setIn(new FileInputStream("src/input.txt"));
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int[] weight = new int[V+1];
        
        for(int i = 0; i <= V; i++) {
        	weight[i] = INF;
        }
        
        int start = Integer.parseInt(br.readLine());
        
        List<Node>[] graph= new ArrayList[V+1];
        
        for(int i = 1; i <= V; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        weight[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int idx = Integer.parseInt(st.nextToken());
        	
        	graph[idx].add(new Node(Integer.parseInt(st.nextToken()),
        	Integer.parseInt(st.nextToken())));
        }
        
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
        	Node n = pq.poll();
        	
        	for(Node nn:graph[n.end]) {
        		if(weight[nn.end] > weight[n.end] + nn.weight) {
        			weight[nn.end] = weight[n.end] + nn.weight;
        			pq.add(new Node(nn.end, weight[nn.end]));
        		}
        	}
        }
        
        for(int i = 1; i <= V; i++) {
        	System.out.println(weight[i] == INF ? "INF" : weight[i]);
        }
        
        br.close();
    }
}
