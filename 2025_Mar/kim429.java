package algo.boj;

import java.util.*;
import java.io.*;

public class BOJ_2164 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		int num = 0;
		
		while(!q.isEmpty()) {
			num = q.remove();
			if(!q.isEmpty()) {
				num = q.remove();
				q.add(num);
			}
		}
		System.out.println(num);
	}
}
