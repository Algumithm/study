import java.lang.*;
import java.io.*;
import java.util.*;

class score implements Comparable<score>{
	int a,b;
	score(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(score o) {
		return this.a-o.a;
	}
	
	
}

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			List<score> list = new ArrayList();
			int n = Integer.parseInt(br.readLine());
			for(int j = 0; j < n; j++) {
				String[] strs = br.readLine().split(" ");
				list.add(new score(Integer.parseInt(strs[0]),Integer.parseInt(strs[1])));
			}
			Collections.sort(list);
			int temp = list.get(0).b;
			for(score a : list) {
				if(temp < a.b) {
					n--;
				}else {
					temp = a.b;
				}
				
			}
			
			System.out.println(n);
			
		}
	}
}
