import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visit = new boolean[123456*2+1];
    public static void main(String[] args) throws Exception {
    	for(int i = 2; i*i <= 123456*2; i++) {
    		if(!visit[i]) {
	    		for(int j = i*i; j <= 123456*2; j+=i) {
	    			visit[j] = true;
	    		}
    		}
    	}
    	while(true) {
    		int N = Integer.parseInt(br.readLine());
    		int cnt = 0;
    		if(N == 0) break;
    		else {
    			for(int i = N+1; i <=N*2; i++) {
    				if(!visit[i]) cnt++;
    			}
    		}
    		bw.write(cnt+"\n");
    	}
        bw.flush();
    }
}
