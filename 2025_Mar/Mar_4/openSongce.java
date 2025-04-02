import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque();
		
		for(int i = n; i > 0; i--) {
			stack.push(i);
		}
		
		while(stack.size() > 1) {
			stack.pop();
			stack.addLast(stack.pop());
		}

		int result = stack.pop();
		System.out.println(result);
		
	}
}
