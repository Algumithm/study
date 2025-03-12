import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> tree;
		ArrayList<Integer> tree2;
		int max;
		int cntOne;
		int cntTwo;

		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++ ) {
			int N = Integer.parseInt(br.readLine());
			tree = new ArrayList<Integer>();
			tree2 = new ArrayList<Integer>();
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			cntOne = 0;
			cntTwo = 0;
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				tree.add(a);
				max = Math.max(max, a);
			}
			
			for(int i = 0; i < N; i++) {
				tree2.add(max - tree.get(i));
				if(tree2.get(i)%2 == 0) {
					cntTwo += tree2.get(i)/2;
				} else {
					cntTwo += tree2.get(i)/2;
					cntOne++;
				}
			}
			
			while(cntOne < cntTwo && (cntTwo-cntOne) >= 2) {
				cntOne += 2;
				cntTwo--;
			}
			
			int day = Math.min(cntOne, cntTwo);
			ans += day*2;
			cntOne -= day;
			cntTwo -= day;
			
			if(cntOne > 0) ans += 2*(cntOne-1) + 1;
			if(cntTwo > 0) ans += 2;
			
			System.out.println("#" + tc + " " + ans);
		}
	}//main
}
