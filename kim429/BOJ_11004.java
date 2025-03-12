package swea;

import java.util.*;
import java.io.*;

public class BOJ_11004 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i < N ; i++) {
			array.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(array);
		
		System.out.println(array.get(K-1));
	}
}
