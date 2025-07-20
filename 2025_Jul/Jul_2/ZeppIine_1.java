
public class Solution {
	
    public int solution(int n, int w, int num) {
    	int answer = 1;
    
        int row = (num - 1) / w;
        int col = (num - 1) % w;
        
        col = (row % 2 == 0) ? col : (w - 1 - col);

        int height = (n + w - 1) / w;

        for (int r = row + 1; r < height; r++) {
            int realCol = (r % 2 == 0) ? col : (w - 1 - col);
            int idx = r * w + realCol + 1;

            if (idx <= n) answer++;
        }

        return answer;
    }
}
