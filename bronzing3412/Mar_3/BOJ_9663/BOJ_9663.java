import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] visit;
    static int count, N;
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	visit = new int[N];
    	Arrays.fill(visit, -1);
    	dfs(0);
    	bw.write(count+"\n");
    	bw.flush();
    }
    
    static void dfs(int cnt) {
    	if(cnt == N) {
    		count++;
    		return;
    	}
    	for(int i = 0 ; i < N; i++) {
    		if(check(i, cnt)) {
    			visit[i] = cnt;
    			dfs(cnt+1);
    			visit[i] = -1;
    		}
    	}
    }
    
    static boolean check(int n, int cnt) {
    	if(visit[n] != - 1) return false;
    	for(int i = 0; i < N; i++) {
    		if(visit[i] != -1 && Math.abs(n-i) == Math.abs(cnt-visit[i])) {
    			return false;
    		}
    	}
    	return true;
    }
}
