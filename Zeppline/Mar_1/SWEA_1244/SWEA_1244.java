import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int NUMBER;
	static Set<String> visited;
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int getNumber(int[] arr) {
		int result = 0;
		int k = arr.length;
		while(k > 0) {
			result += arr[arr.length - k] * Math.pow(10, k-1);
			k--;
		}
		
		return result;
	}
	
	static void getMaxMoney(int[] arr, int trade) {
		if(trade == 0) {
			NUMBER = Math.max(NUMBER, getNumber(arr));
			return;
		}
		
		String key = getNumber(arr) + "," + trade;
		if(visited.contains(key)) return;
		visited.add(key);
		
		for(int i = 0 ; i < arr.length-1; i++) {
			for(int j = i+1; j< arr.length; j++) {
				if(j == i) continue;
				swap(arr, i, j);
				getMaxMoney(arr, trade-1);
				swap(arr, i, j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s_num = st.nextToken();	
			int num = Integer.parseInt(s_num);
			int trade = Integer.parseInt(st.nextToken());
			NUMBER = Integer.MIN_VALUE;
			visited = new HashSet<String>();
			
			int[] numArr = new int[s_num.length()];
			
			for(int i = 0; i < s_num.length(); i++) {
				numArr[i] = s_num.charAt(i) - '0';
			}
			
			getMaxMoney(numArr, trade);
			
			System.out.println("#" + test_case + " " + NUMBER);
		}
		br.close();
	}
}
