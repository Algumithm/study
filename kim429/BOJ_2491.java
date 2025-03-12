package swea;

import java.util.*;
import java.io.*;

public class BOJ2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		int count = 1;
		int max_count = 1;
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = array[0];
		
		for(int i = 0; i < N; i++) {
			if(array[i] >= s && i > 0) {
				count++;
			} else {
				count = 1;
			}
			if(count > max_count) {
				max_count = count;
			}
			s = array[i];
			//System.out.println("i : " + i + " s : " + s + " count : " + count);
		}
		
		s = array[0];
		count = 1;
		
		for(int i = 0; i < N; i++) {
			if(array[i] <= s && i > 0) {
				count++;
			} else {
				count = 1;
			}
			if(count > max_count) {
				max_count = count;
			}
			s = array[i];
			//System.out.println("i : " + i + " s : " + s + " count : " + count);
		}
		System.out.println(max_count);
	}
}
