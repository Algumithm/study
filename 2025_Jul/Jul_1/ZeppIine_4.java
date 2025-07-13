
public class Solution {

	public int steal(int[] money, int start, int end) {
		int n1 = 0;
		int n2 = 0;
		
		for(int i = start; i < end; i++) {
			int temp = Math.max(n1 + money[i], n2);
			n1 = n2;
			n2 = temp;
		}
		
		return n2;
	}
	
    public int solution(int[] money) {
        int size = money.length;
        
        if(size == 3) {
        	return Math.max(money[0], Math.max(money[1], money[2]));
        }
        
        int selStart = steal(money, 0, size-1);
        int selEnd = steal(money, 1, size);;
        
        return Math.max(selStart, selEnd);
    }
}
