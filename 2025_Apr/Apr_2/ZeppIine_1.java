import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2512 {
    public static void main(String[] args) throws IOException {
    	
    	System.setIn(new FileInputStream("src/input.txt"));
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());
        
        int[] cost = new int[size];

        int maxCost;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = 0;
        int min = 0;
        
        int mid = 0;
        
        for(int i = 0; i < size; i++) {
        	cost[i] = Integer.parseInt(st.nextToken());
        	max = Math.max(max, cost[i]);
        	mid += cost[i];
        }
        mid /= size;
        
        maxCost = Integer.parseInt(br.readLine());
        
        while(max >= min) {
        	int totalCost = 0;
        	for(int c:cost) {
        		if(c > mid) totalCost += mid;
        		else totalCost += c;
        	}
        	
        	if(totalCost > maxCost) {
        		max = mid - 1;
        		mid = (max + min) / 2;
        	} else if(totalCost <= maxCost) {
        		min = mid + 1;
        		mid = (max + min) / 2;
        	}
        }
        System.out.println(mid);
        br.close();
    }
}
