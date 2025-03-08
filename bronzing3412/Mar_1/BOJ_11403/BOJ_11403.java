import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] graph;
    static boolean[] visit;
    static int N;
    static int temp;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); 
        graph = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 0; i < N; i++) {
        	temp = i;
        	visit = new boolean[N]; 
        	dfs(i);
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		bw.write(graph[i][j] + " ");
        	}
        	bw.write("\n");
        }
        bw.flush();
    }
    
    static void dfs(int n) {
    	visit[n] = true;
    	for(int i = 0; i < N; i++) {
    		if(graph[n][i] == 1) {
    			if(!visit[i]) {
    				graph[temp][i] = 1;
    				dfs(i);
    			} else {
    				if(i == temp) graph[temp][i] = 1;
    			}
    		}
    	}
    }
}
