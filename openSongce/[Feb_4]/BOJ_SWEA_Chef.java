package exam_0228;

import java.util.*;
import java.lang.*;
import java.io.*;


public class Ex_0228_1 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= test_n; i++) {
			int min = Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int k = 0; k <n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				} // for k
			} // for j
			
			
			
			List<List<Integer>> result = new ArrayList();
			combine(n, n/2, 0, new ArrayList(), result);
			
			
			List<Integer> score = new ArrayList();
			for(List<Integer> a : result) {
				score.add(getScore(a, arr));
//				for(int b : a) {
//					System.out.println(b);
//				}
				
			} // for a
			
//			for(int a : score) {
//				System.out.println(a);
//			}
			
			
			for(int m = 0; m < score.size(); m++) {
				min = Math.min(min, Math.abs(score.get(m)-score.get(score.size()-1-m)));
			}
			
			
			
			System.out.println("#" + i + " " + min);
			
		} // for i
		
	} //main
	
	static void combine(int n, int k, int start, List<Integer> temp,List<List<Integer>> result) {
		if(temp.size() == k) {
			result.add(new ArrayList(temp));
			return;
		} // if
		
		for(int i = start; i < n; i++) {
			temp.add(i);
			combine(n, k, i+1, temp, result);
			temp.remove(temp.size()-1);
		} // for i
	} // combine
	
	
	
	static int getScore(List<Integer> list, int[][] arr) {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			for(int j = i+1; j < list.size(); j++) {
				sum += arr[list.get(i)][list.get(j)] + arr[list.get(j)][list.get(i)];
			} // for j
		} // for i
		
		return sum;
	} //getScore
	
	
} // Ex_0228_1
