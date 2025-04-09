import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1946 {
	static class Empl implements Comparable<Empl> {
		int test;
		int interview;
		
		Empl(String test, String interview){
			this.test = Integer.parseInt(test);
			this.interview = Integer.parseInt(interview);
		}

		@Override
		public int compareTo(Empl o) {
			return this.test == o.test ? this.interview - o.interview : this.test - o.test;
		}
	}
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int test = 1; test <= t; test++) {
        	int size = Integer.parseInt(br.readLine());
        	
        	PriorityQueue<Empl> pq = new PriorityQueue<>();
        	
        	for(int i = 0; i < size; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		pq.add(new Empl(st.nextToken(), st.nextToken()));
        	}
        	
        	int count = 0;
        	
        	int topTest = size;
        	int topInterview = size;
        	
        	while(!pq.isEmpty()) {
        		Empl e = pq.poll();
        		
        		if(e.test > topTest && e.interview > topInterview) continue;
        		
        		count++;
        		topTest = Math.min(topTest, e.test);
        		topInterview = Math.min(topInterview, e.interview);
        	}
        	
        	System.out.println(count);
        }
        br.close();
    }
}

