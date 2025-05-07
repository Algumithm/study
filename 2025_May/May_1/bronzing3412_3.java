import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static String A, B, C;
	static char[] aarr;
	static boolean[] visit;
	static int ans = -1;
	
	public static void main(String[] args) throws IOException {	
		st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
		aarr = A.toCharArray();
		visit = new boolean[A.length()];
		dfs("");
		bw.write(ans + "\n");
		bw.flush();
	}
	
	static void dfs(String cur) {
		if(cur.length() != 0 && cur.charAt(0) == '0') return;
		if(cur.length() == A.length()) {
			if(Integer.parseInt(cur) > Integer.parseInt(B)) return;
			else {
				ans = Math.max(ans, Integer.parseInt(cur));
				return;
			}
		}
		for(int i = 0; i < A.length(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(cur+A.charAt(i));
				visit[i] = false;
			}
		}
	}
}
