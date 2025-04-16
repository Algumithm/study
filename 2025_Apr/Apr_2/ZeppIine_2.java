import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9465 {
    
	final static int BUFFER = 2;
	
    public static void main(String[] args) throws IOException {
    	
    	System.setIn(new FileInputStream("src/input.txt"));
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int test = 0; test < t; test++) {
        	
        	int size = Integer.parseInt(br.readLine());
        	
        	int[][] graph = new int[2][size + BUFFER]; 
        	
        	int[][] dp_graph = new int[2][size + BUFFER]; 
        	
        	int max = 0;
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < size; i++) {
        		graph[0][i+BUFFER] = Integer.parseInt(st.nextToken());
        	}
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < size; i++) {
        		graph[1][i+BUFFER] = Integer.parseInt(st.nextToken());
        	}
        	
        	for(int i = 0 + BUFFER; i < size + BUFFER; i++) {
        		dp_graph[0][i] = Math.max(dp_graph[1][i-1], dp_graph[1][i-2]) + graph[0][i];
        		dp_graph[1][i] = Math.max(dp_graph[0][i-1], dp_graph[0][i-2]) + graph[1][i];
        		max = Math.max(Math.max(dp_graph[0][i], dp_graph[1][i]), max);
        	}
        	System.out.println(max);
        }        
        br.close();
    }
}

