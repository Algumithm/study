import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution {
	
	static int[] score;
	static int[] kcal;
	static int n;
	static int l;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= test_n; i++) {
			String[] strs = br.readLine().split(" ");
			n = Integer.parseInt(strs[0]);
			l = Integer.parseInt(strs[1]);
			
			score = new int[n];
			kcal = new int[n];
			max = Integer.MIN_VALUE;
			for(int j = 0; j < n; j++) {
				strs = br.readLine().split(" ");
				
				score[j] = Integer.parseInt(strs[0]);
				kcal[j] = Integer.parseInt(strs[1]);
			}
			part();
			
			System.out.println("#" + i + " " + max);
			
		}
	} // main
	
	static void part() {
		for(int i = 0; i < (1<<n); i++) {
			int score_sum = 0;
			int kcal_sum = 0;
			for(int j = 0; j < n; j++) {
				if((i & (1<<j)) != 0) {
					score_sum += score[j];
					kcal_sum += kcal[j];
				}
			}
			
			if(kcal_sum <= l) {
				max = Math.max(max, score_sum);
			}
		}
	}
	
} // Hamburger
