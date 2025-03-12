import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long A, B ,ans;
    static Queue<long[]> q = new LinkedList<long[]>();
    static HashSet<Long> hs = new HashSet<Long>();
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	bfs(A, B);
    	bw.write((ans+1)+"\n");
        bw.flush();
    }

    static void bfs(long start, long goal) throws Exception{
    	q.add(new long[] {start, 0});
    	while(!q.isEmpty()) {
    		long[] num = q.poll();
//    		System.out.println(num[0] + " " + num[1]);
    		if(num[0] == goal) {
    			ans = num[1];
    			return;
    		}
    		if(!hs.contains(num[0]*2) && num[0]*2 <= goal) {
    			q.add(new long[] {num[0]*2, num[1]+1});
    			hs.add(num[0]*2);
    		}
    		if(!hs.contains(num[0]*10+1) && num[0]*10+1 <= goal) {
    			q.add(new long[] {num[0]*10+1, num[1]+1});
    			hs.add(num[0]*10+1);
    		}
    	}
    	ans = -2;
    	return;
    }
}
