import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class AlpabetNum implements Comparable<AlpabetNum>{
		int num;
		String alpabet;
		
		AlpabetNum(String alpabet){
			this.alpabet = alpabet;
			
			switch (alpabet) {
				case "ZRO": {
					num = 0;
					break;
				} case "ONE": {
					num = 1;
					break;
				} case "TWO": {
					num = 2;
					break;
				} case "THR": {
					num = 3;
					break;
				} case "FOR": {
					num = 4;
					break;
				} case "FIV": {
					num = 5;
					break;
				} case "SIX": {
					num = 6;
					break;
				} case "SVN": {
					num = 7;
					break;
				} case "EGT": {
					num = 8;
					break;
				} case "NIN": {
					num = 9;
					break;
				}
			}
		}

		@Override
		public int compareTo(AlpabetNum o) {
			return this.num - o.num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String testCase = st.nextToken();
			
			int size = Integer.parseInt(st.nextToken());
			
			AlpabetNum[] base = new AlpabetNum[size];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++) {
				base[i] = new AlpabetNum(st.nextToken());
			}
			
			Arrays.sort(base);
			
			sb.append(testCase).append("\n");
			
			for(int i = 0; i < size; i++) {
				sb.append(base[i].alpabet).append(" ");
			}
            sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}