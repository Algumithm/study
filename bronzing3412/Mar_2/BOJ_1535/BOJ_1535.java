import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] happy;
    static int[] sad;
    static int max = Integer.MIN_VALUE;
    static int N;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sad = new int[N];
        happy = new int[N];
        for(int i = 0; i < N; i++) {
        	sad[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	happy[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,100,0);
        bw.write(max+"\n");
        bw.flush();
    }
    
    static void dfs(int cur, int health, int happy_sum) {
    	if(health <= 0) return;
    	max = Math.max(max, happy_sum);
    	if(cur < N) {
    		dfs(cur + 1, health - sad[cur], happy_sum + happy[cur]);
    		dfs(cur+1, health, happy_sum);
    	}
    }
}
