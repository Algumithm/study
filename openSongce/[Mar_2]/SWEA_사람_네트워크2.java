import java.util.*;
import java.io.*;
import java.lang.* ;

public class Solution {
	static int[][] arr;
	static int min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= test_n; i++) {
			
			

			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			min = Integer.MAX_VALUE;
			
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					if(j != k && arr[j][k]==0) {
						arr[j][k] = Integer.MAX_VALUE;
					}
				}
			}
			
//			for(int j = 0; j < n; j++) {
//	        	for(int k = 0; k < n; k++) {
//	        		System.out.print(arr[j][k] + " ");
//	        	}
//	        	System.out.println();
//	        }
			
			
	        // 플로이드 워셜 알고리즘 수행
	        for (int k = 0; k < n; k++) { // 경유지 k
	            for (int a = 0; a < n; a++) { // 출발점 i
	                for (int j = 0; j < n; j++) { // 도착점 j
	                    if (arr[a][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
	                    	arr[a][j] = Math.min(arr[a][j], arr[a][k] + arr[k][j]);
	                    }
	                }
	            }
	        }
	        
	        
	        for(int j = 0; j < n; j++) {
	        	int sum = 0;
	        	for(int k = 0; k < n; k++) {
	        		if(arr[j][k] != Integer.MAX_VALUE) {
	        			sum += arr[j][k];
	        		}
	        	}
	        	min = Math.min(sum, min);
	        }
	        
	        System.out.println("#" + i + " " + min);
		}
	}
}
