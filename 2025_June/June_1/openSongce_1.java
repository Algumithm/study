package exam_0610;

import java.lang.*;
import java.io.*;
import java.util.*;

public class lotto {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static int[] temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] strs = br.readLine().split(" ");
			n = Integer.parseInt(strs[0]);
			if(n == 0) {
				return;
			}
			arr = new int[n];
			temp = new int[6];
			visited = new boolean[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(strs[i+1]);
			}
			answer(0, 0);
			System.out.println();
		}
		
	}
	
	static void answer(int count, int start) {
		if(count == 6) {
			for(int a : temp) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				temp[count] = arr[i];
				visited[i] = true;
				answer(count + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
