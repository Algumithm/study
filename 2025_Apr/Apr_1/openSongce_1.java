import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
	static int n,max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] strs = new String[5];
		int[] arr = new int[5];
		Map<Integer, Integer> map = new HashMap();
		List<Integer> list = new ArrayList();
		for(int k = 1; k <= n; k++) {
			max = Integer.MIN_VALUE;
			strs = br.readLine().split(" ");
			for(int i = 0; i < 5; i++) {
				arr[i] = Integer.parseInt(strs[i]);
			}
			dfs(arr, 0, 0, 0);
			map.put(max, k);
			list.add(max);
		}
		list.sort(Comparator.reverseOrder());
		for(int a: list) {
			System.out.println(a);
		}
		System.out.println(map.get(list.get(0)));
		
		
	}
	
	
	static void dfs(int[] arr, int depth, int start, int temp) {
		if(depth == 3) {
			temp %= 10;
			max = Math.max(max, temp);
			return;
		}
		for(int i = start; i < 5; i++) {
			dfs(arr, depth+1, i+1, temp+arr[i]);
		}
	}
}
