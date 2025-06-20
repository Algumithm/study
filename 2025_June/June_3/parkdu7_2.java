import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[2] != b[2]) return a[2] - b[2];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
            });
        int n = jobs.length;
        visited = new boolean[jobs.length];
        
        int minTime = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            minTime = Math.min(minTime, jobs[i][0]);
        }
        
        int time = minTime;
        int total = 0;
        
        while(!isAllVisited()){
            
            for(int i = 0; i < n; i++){
                if(!visited[i] && jobs[i][0] <= time){
                    pq.add(new int[]{i, jobs[i][0], jobs[i][1]});
                    visited[i] = true;
                }
            }
        
            while(!pq.isEmpty()){
                int[] cur = pq.poll();

                int start = cur[1]; int cost = cur[2];

                time += cost;
                total += time - start;

                for(int i = 0; i < n; i++){
                    if(!visited[i] && jobs[i][0] <= time){
                        pq.add(new int[]{i, jobs[i][0], jobs[i][1]});
                        visited[i] = true;
                    }
                }
            }
            
            time++;
        }
        
        answer = total / n;
        
        return answer;
    }
    
    static boolean isAllVisited(){
        
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
