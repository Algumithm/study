import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        List<int[]> list = new ArrayList();
        for(int[] r : routes){
            list.add(r);
        }
        list.sort((a, b) -> a[1] - b[1]);

        int idx = Integer.MIN_VALUE;

        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i)[0] > idx) {
                idx = list.get(i)[1];
                answer++;
            }
        }

        return answer;
    }
}
