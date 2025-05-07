package exam_0507;

import java.lang.*;
import java.util.*;
import java.io.*;

public class ex_11497 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_n = Integer.parseInt(br.readLine().trim());
		for(int test = 1; test <= test_n; test++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[n];
			String[] strs = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(strs[i]);
			}
			
			Arrays.sort(arr);
			
			int sub = Integer.MIN_VALUE;
			
			for(int i = 0; i < n/2 - 1; i++) {
				sub = Math.max(arr[2 * (i + 1)]-arr[2 * i], sub);
			}
			
			
			for(int i = 0; i < n/2 - 1; i++) {
				sub = Math.max(arr[2 * (i + 1) + 1] - arr[2 * i + 1], sub);
			}
			
			sub = Math.max(arr[n-1]-arr[n-3], sub);
			sub = Math.max(arr[n-1]-arr[n-2], sub);
			sub = Math.max(arr[1] - arr[0], sub);
			
			System.out.println(sub);
		}
	}
}
