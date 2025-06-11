import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<int[]>[] graph;
	static boolean visited[];
	static int result[][];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        result = new int[N][N];
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			graph[x].add(new int[]{y, cost});
			graph[y].add(new int[]{x, cost});
		}
        
        for (int i = 0; i < N; i++) {
			result[i][i] = -1;
		}
        
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
			bfs(i);
		}
        
        printResult();
    }
    
    static void bfs(int start) {
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
    		if(a[1] != b[1]) return a[1] - b[1];
    		return b[2] - a[2];
    	});
    	
    	for (int[] next : graph[start]) {
    	    int nextIdx = next[0];
    	    int nextCost = next[1];

    	    if (!visited[nextIdx]) {
    	        pq.add(new int[] {nextIdx, nextCost, nextIdx});
    	    }
    	}
    	
    	
    	while(!pq.isEmpty()) {
    		if(checkRow(start))
    			break;
    		
    		int[] cur = pq.poll();
    		int curIdx = cur[0]; int curCost = cur[1]; int startIdx = cur[2];
    		if(visited[curIdx])
    			continue;
    		
    		visited[curIdx] = true;
    		if(result[start][curIdx] == 0) result[start][curIdx] = startIdx + 1;
//    		System.out.println((curIdx+1) + " " + curCost + " "  + (startIdx+1));
    		
    		for (int[] next : graph[curIdx]) {
    		    int nextIdx = next[0];
    		    int nextCost = next[1];

    		    if (!visited[nextIdx]) {
    		        pq.add(new int[] {nextIdx, curCost + nextCost, startIdx});
    		    }
    		}
    		
    	}
    	
    }
    
    static void printResult() {
    	for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if(result[i][j] == -1) {
					System.out.print("-" + " ");
				}
				else {
					System.out.print(result[i][j] + " ");			
				}
			}
			System.out.println();
		}
    }
    
    static boolean checkRow(int x) {
    	for (int i = 0; i < result.length; i++) {
			if(result[x][i] == 0)
				return false;
		}
    	return true;
    }
}
