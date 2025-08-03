import java.util.*;

class Solution {
    List<int[]> answer = new ArrayList();
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 3, 2);
        int[][] result = answer.toArray(new int[0][]);
        
        
        return result;
    }
    
    public void hanoi(int n, int start, int end, int middle){
        if(n == 1){
            answer.add(new int[]{start, end});
            return;
        }
        
        hanoi(n-1, start, middle, end);
        answer.add(new int[]{start, end});
        hanoi(n-1, middle, end, start);
    }
    
}
