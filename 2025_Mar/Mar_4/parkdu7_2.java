import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> grow = new ArrayList<Integer>();
		long result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			result += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			grow.add(Integer.parseInt(st.nextToken()));
		}
		/////////////////////////입력//////////////////////////
		grow.sort(null);
		for (int i = 0; i < N; i++) {
			result += grow.get(i) * i;
		}
		
		System.out.println(result);
	}//main
}
