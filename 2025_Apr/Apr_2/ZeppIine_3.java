import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11000 {

	static class Time implements Comparable<Time> {
		
		int start;
		int end;
		
		public Time(int start, int end) {
		    this.start = start;
		    this.end = end;
		}
		
		@Override
		public int compareTo(Time o) {
		    return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());

	    List<Time> classList = new ArrayList<>();
	
	    for (int i = 0; i < n; i++) {
	         StringTokenizer st = new StringTokenizer(br.readLine());
	         int start = Integer.parseInt(st.nextToken());
	         int end = Integer.parseInt(st.nextToken());
	         classList.add(new Time(start, end));
	    }
	
	    Collections.sort(classList);
	
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    pq.offer(classList.get(0).end);
	    
	    for (int i = 1; i < n; i++) {
	        Time current = classList.get(i);
	        
	        if (current.start >= pq.peek()) {
	            pq.poll();
	        }

	        pq.offer(current.end);
	    }
	
	    System.out.println(pq.size());
	    br.close();
	}
}