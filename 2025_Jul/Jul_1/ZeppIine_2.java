import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cam = -30001;
        
        for(int[] car:routes) {
        	int in = car[0];
        	int out = car[1];
        	
        	if(in > cam) {
        		answer++;
        		cam = out;
        	}
        }
        
        return answer;
    }
}
