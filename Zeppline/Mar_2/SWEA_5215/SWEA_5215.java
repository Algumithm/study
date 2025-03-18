import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int SIZE;
	static int BURGER;
	static int MAX_CAL;
	static InBurger[] IN_BURGER;
	static boolean[] USED;
	
	static class InBurger implements Comparable<InBurger>{
		int score;
		int cal;
		
		InBurger(String score, String cal){
			this.score = Integer.parseInt(score);
			this.cal = Integer.parseInt(cal);
		}

		@Override
		public int compareTo(InBurger o) {
			return o.cal == this.cal ? o.score - this.score : o.cal - this.cal;
		}
	}
	
	static void select(int count, int score, int cal) {
	    if (cal < 0) return;
	    
	    BURGER = Math.max(BURGER, score);

	    if (count == SIZE) return;

	    InBurger ib = IN_BURGER[count];
	    select(count+1, score+ib.score, cal-ib.cal);
	    select(count+1, score, cal);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			SIZE = Integer.parseInt(st.nextToken());
			MAX_CAL = Integer.parseInt(st.nextToken());
			
			BURGER = Integer.MIN_VALUE;
			
			IN_BURGER = new InBurger[SIZE];
			USED = new boolean[SIZE];
			
			for(int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				IN_BURGER[i] = new InBurger(st.nextToken(), st.nextToken());
			}
			
			Arrays.sort(IN_BURGER);
			
			select(0, 0, MAX_CAL);
			
			System.out.println("#" + test_case + " " + BURGER);
		}
		br.close();
	}
}
