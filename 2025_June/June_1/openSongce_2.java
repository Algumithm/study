package exam_0610;

import java.lang.*;
import java.io.*;
import java.util.*;


public class Stock {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_n = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < test_n; i++) {
			n = Integer.parseInt(br.readLine().trim());
			String[] strs = br.readLine().split(" ");
			arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(strs[j]);
			}
			
			int index = 0;
			int start = 0;
			long profit = 0;
			
			while(start < n) {
				int max = Integer.MIN_VALUE;
				for(int k = start; k < n; k++) {
					if(arr[k] >= max) {
						max = arr[k];
						index = k;
					}
				}
				
				for(int j = start; j < index; j++) {
//					System.out.println(max - arr[start]);
					profit += (max - arr[j]);
				}
				start = index + 1;	
//				System.out.println(start);
			}
			
			System.out.println(profit);
		}
	}
}
