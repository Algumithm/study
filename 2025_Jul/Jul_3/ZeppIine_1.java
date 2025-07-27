
public class PGM_하노이의탑 {
	
	int count = 0;
	int[][] answer;
	
	public int[][] solution(int n) {        
        answer = new int[(int) Math.pow(2, n) - 1][2];
        
        hanoi(n, 1, 3, 2);
        	
        return answer;
    }	

	public void hanoi(int n, int start, int target, int end) {
		
        if (n == 1) {
        	answer[count++] = new int[]{start, target};
            return;
        }
        
        hanoi(n - 1, start, end, target);
        
        answer[count][0] = start;
        answer[count][1] = target;
        
        count++;
        
        hanoi(n - 1, end, target, start);
    }
}