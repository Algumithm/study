import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
			cnt += list.get(i);
		}
		
		int M = Integer.parseInt(br.readLine());
		list.sort(null);
		
		if(cnt < M) {
			System.out.println(list.get(N - 1));
			return;
		}
		///////////////입력////////////////////
		
		int low = 0;
		int high = list.get(N - 1);
		int result = 0;
		
		while(low <= high) {
			int mid = (low + high) / 2;
		    int sum = 0;
		    for (int tmp : list) {
		        sum += Math.min(tmp, mid);
		    }

		    if (sum <= M) {
		        result = mid;
		        low = mid + 1;
		    } else {
		        high = mid - 1;
		    }
		}
		
		System.out.println(result);
		
		
	}
}
