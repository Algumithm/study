import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
      
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int time = 0;       
        int totalTime = 0;  
        int index = 0;      
        int count = 0;      

        while (count < jobs.length) {
    
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];                    
                totalTime += time - job[0];        
                count++;
            } else {
                // 대기 큐가 비었
                time = jobs[index][0];
            }
        }

        return totalTime / jobs.length;
    }
}
