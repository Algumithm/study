import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);  // 요청 시간 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);  // 소요 시간 기준

        int time = 0;
        int total = 0;
        int i = 0;
        int count = 0;

        while (count < jobs.length) {
            // 현재 시간까지 요청된 작업들 큐에 삽입
            while (i < jobs.length && jobs[i][0] <= time) {
                pq.add(jobs[i++]);
            }

            if (pq.isEmpty()) {
                time = jobs[i][0];  // 대기할 작업이 없으면 시간 점프
            } else {
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0];  // 요청부터 끝까지 걸린 시간
                count++;
            }
        }

        return total / jobs.length;
    }
}
