import java.util.*;

class Solution {

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> serverEndTime = new LinkedList<>(); // 종료시간을 기록

        for (int time = 0; time < 24; time++) {
            // 1. 현재 시간에 종료된 서버는 제거
            while (!serverEndTime.isEmpty() && serverEndTime.peek() <= time) {
                serverEndTime.poll();
            }

            // 2. 현재 시간대에 필요한 서버 수 계산
            int requiredServers = players[time] / m;

            // 3. 부족한 서버 수만큼 증설
            int shortage = requiredServers - serverEndTime.size();
            if (shortage > 0) {
                answer += shortage;
                for (int i = 0; i < shortage; i++) {
                    serverEndTime.offer(time + k); // k시간 뒤에 만료될 서버
                }
            }
        }

        return answer;
    }
}
