import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static int[][] field;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int V;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
    public static void main(String[] args) throws Exception{
        
    	
    	
    	st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	int start = Integer.parseInt(st.nextToken());
    	
    	field = new int[V+1][V+1];
    	visit = new boolean[V+1];
    	
    	for(int i = 0; i < E; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		field[a][b] = 1;
    		field[b][a] = 1;
    	}
    	visit[start] = true;
    	dfs(start);
    	bw.write("\n");
    	visit = new boolean[V+1];
    	visit[start] = true;
    	bfs(start);
    	bw.flush();
    }
    
    static void dfs(int index) throws Exception{
    	bw.write(index + " ");
    	for(int i = 1; i <= V; i++) {
    		if(field[index][i] == 1 && !visit[i]) {
    			visit[i] = true;
    			dfs(i);
    		}
    	}
    }
    
    static void bfs(int index) throws Exception{
    	queue.add(index);
    	while(!queue.isEmpty()) {
    		int a = queue.poll();
    		bw.write(a+" ");
    		for(int i = 1; i <= V; i++) {
        		if(field[a][i] == 1 && !visit[i]) {
        			visit[i] = true;
        			queue.add(i);
        		}
        	}
    	}
    }
}
