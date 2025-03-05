import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static ArrayList<Integer> arr2 = new ArrayList<Integer>();
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int rank = 0;
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr.add(a);
			arr2.add(a);
		}
		arr2.sort(null);
		
		for(int i = 0; i < N; i++) {
			if(!hm.containsKey(arr2.get(i))) {
				hm.put(arr2.get(i), rank++);
			}
		}
		for(int i = 0; i < N; i++) {
			bw.write(hm.get(arr.get(i)) + " ");
		}
		bw.flush();
	}

}
