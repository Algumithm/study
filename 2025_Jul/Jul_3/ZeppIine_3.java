import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PGM_부대복귀 {
	
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for (int[] r:roads) {
            int n1 = r[0];
            int n2 = r[1];
            
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int[] dist = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	dist[i] = -1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        dist[destination] = 0;
        q.add(destination);

        while (!q.isEmpty()) {
            int n1 = q.poll();
            
            for (int n2:graph[n1]) {
                if (dist[n2] == -1) {
                    dist[n2] = dist[n1] + 1;
                    q.add(n2);
                }
            }
        }

        int[] answer = new int[sources.length];
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}
