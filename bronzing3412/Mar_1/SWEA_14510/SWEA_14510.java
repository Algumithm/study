import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> tree;
	static ArrayList<Integer> tree2;
	static int max;
	static int cnt_one;
	static int cnt_two;
	
	public static void main(String[] args) throws Exception{
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++ ) {
			int N = Integer.parseInt(br.readLine());
			tree = new ArrayList<Integer>();
			tree2 = new ArrayList<Integer>();
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			cnt_one = 0;
			cnt_two = 0;
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				tree.add(a);
				max = Math.max(max, a);
			}
			
			for(int i = 0; i < N; i++) {
				tree2.add(max - tree.get(i));
				if(tree2.get(i)%2 == 0) {
					cnt_two += tree2.get(i)/2;
				} else {
					cnt_two += tree2.get(i)/2;
					cnt_one++;
				}
			}
			
			while(cnt_one < cnt_two && (cnt_two-cnt_one) >= 2) {
				cnt_one += 2;
				cnt_two--;
			}
			
			int day = Math.min(cnt_one, cnt_two);
			ans += day*2;
			cnt_one -= day;
			cnt_two -= day;
			
			if(cnt_one > 0) ans += 2*(cnt_one-1) + 1;
			if(cnt_two > 0) ans += 2;
			bw.write("#" + tc + " "+ ans+"\n");
		}
		bw.flush();
	}
}
