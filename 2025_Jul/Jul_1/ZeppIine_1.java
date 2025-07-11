import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	class End {
	    int time;
	    int count;
	    
	    End(int time, int count){
	        this.time = time;
	        this.count = count;
	    }
	}
	
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<End> q = new LinkedList<>();
        
    	int addSize = 0;
        
        for(int i = 0; i < 24; i++) {
        	while (!q.isEmpty() && q.peek().time == i) {
            	addSize -= q.poll().count;
            }
        	
        	int n = players[i] - addSize * m;
        	
        	if(n >= m) {
        		int add = n/m;
        		q.add(new End(i + k, add));
        		addSize += add;
        		answer += add;
        	}
        	//System.out.println(players[i] + " " + addSize + " " + answer);
        }
        
        return answer;
    }
}
