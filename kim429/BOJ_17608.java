package swea;

import java.util.*;
import java.io.*;

public class BOJ17608 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < N; i++) {
			stack.add(Integer.parseInt(br.readLine()));
		}
		
		int count = 1;
		int highest = stack.pop();
		
		while(!stack.isEmpty()) {
			int num = stack.pop();
			if(highest < num) {
				count++;
				highest = num;
			}
		}
		
		System.out.println(count);
		
	}
}
