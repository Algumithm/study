package swea;

import java.util.*;
import java.io.*;

public class BOJ_1182 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int subSum = 0;
		int count = 0;
		
		for(int i = 1; i < (1 << N); i++) {
			subSum = 0;
			for(int j = 0; j < N; j++) {
				if((i & ( 1 << j)) != 0) {
					//System.out.println("test");
					subSum += array[j];
				}
			}
			if(subSum == S) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
	}
}
