package _0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2559 {
	static int[] arr;
	static int[] stackSum;
	static int N, K, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stackSum = new int[N];
		st = new StringTokenizer(br.readLine());
		int l = 0;
		while(st.hasMoreTokens()) {
			arr[l] = Integer.parseInt(st.nextToken());
			l++;
		}
		max = stackSum[K-1];
		stackSum[0] = arr[0];
		for (int i = 1; i < N; i++) {
			stackSum[i] = stackSum[i - 1] + arr[i];
		}
		
		for(int i = K-1; i < N; i++ ) {
		    if (i == K-1) {
		        max = stackSum[i]; // 첫 번째 K개의 합
		    } else {
		        max = Math.max(max, stackSum[i] - stackSum[i-K]);
		    }
		}
		System.out.println(max);
	}//main
	
	
}//bj2559
