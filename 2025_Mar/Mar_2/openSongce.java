import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int n;
	static boolean[] visited;
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited = new boolean[n];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			String[] strs = br.readLine().split(" ");
			for(int j = 0; j <n; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		p(0,new ArrayList());
		
		System.out.println(min);
		
	}
	
	
	
	static void p(int depth, List<Integer> list) {
		if(depth == n-1) {
			int sum = 0;
			sum += arr[0][list.get(0)];
			if(arr[0][list.get(0)]==0) {
				return;
			}
			for(int i = 0; i < list.size()-1; i++) {
				sum += arr[list.get(i)][list.get(i+1)];
				if(arr[list.get(i)][list.get(i+1)]==0) {
					return;
				}
			}
			sum += arr[list.get(list.size()-1)][0];
			if(arr[list.get(list.size()-1)][0]==0) {
				return;
			}
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 1; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list.add(i);
				p(depth+1, list);
				visited[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
	
	
}
