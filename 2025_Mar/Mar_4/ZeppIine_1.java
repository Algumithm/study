import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= number; i++) {
			q.add(i);
		}
		int count = 1;
		while(q.size() != 1) {
			int temp = q.poll();
			if((count++)%2 == 1) continue;
			else q.add(temp);
		}
		int last = q.poll();
		
		System.out.println(last);
		
		br.close();
	}
}