import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<Integer> fruit = new ArrayList<Integer>();
    static HashSet<Integer> hs = new HashSet<Integer>();
    static int max = Integer.MIN_VALUE;
//    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
    	int TC = Integer.parseInt(br.readLine());
    	
    	for(int tc = 1; tc <= TC; tc++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int M = Integer.parseInt(st.nextToken());
    		int N = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		int ans;
    		for(ans = x; ans <= M*N; ans+=M) { 
    			int b = ans%N;
    			if(b == 0) b = N;
    			if(b == y) break;
    		}
    		if(ans > M*N) ans = -1;
    		bw.write(ans + "\n");
    	}
        bw.flush();
    }
}
