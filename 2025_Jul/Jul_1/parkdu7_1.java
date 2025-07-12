class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] need = new int[24];
        for (int i = 0; i < 24; i++) {
            if (players[i] >= m) {
                need[i] = (players[i] - m) / m + 1;
            }
        }

        int[] timer = new int[24 + k + 1];
        int active = 0;

        for (int t = 0; t < 24; t++) {
            
            active -= timer[t];

            int diff = need[t] - active;
            if (diff > 0) {
                answer += diff;
                active += diff;
                timer[t + k] += diff;
            }
        }
        return answer;
    }
}
