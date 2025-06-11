import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int c = 0; c < T; c++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			int start = 0;
			long profit = 0;
			
			while(start < n) {
				int max = Integer.MIN_VALUE;
				for(int k = n - 1; k >= start; k--) {
					if(arr[k] > max) {
						max = arr[k];
						idx = k;
					}
				}
				
				for(int j = start; j < idx; j++) {
					profit += (max - arr[j]);
				}
				start = idx + 1;
			}
			
			System.out.println(profit);
		}
	}
}
