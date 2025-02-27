import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] com;
	static boolean[] visit;
	static int cnt = 0;;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        com = new boolean[V+1][V+1];
        visit = new boolean[V+1];
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a =Integer.parseInt(st.nextToken());
        	int b =Integer.parseInt(st.nextToken());
        			
        	com[a][b] = true;
        	com[b][a] = true;
        }
        dfs(1, V);
        bw.write((cnt-1)+"\n");
        bw.flush();
    }
    
    static void dfs(int index,int V) {
    	visit[index] = true;
    	cnt++;
    	for(int i = 1; i <= V; i++) {
    		if(com[index][i] == true && visit[i] == false) {
    			dfs(i, V);
    		}
    	}
    }
}
