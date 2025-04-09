import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1915 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int maxSquare = 0;
        
        int[][] graph = new int[N+1][M+1];
        int[][] dp_graph = new int[N+1][M+1];
        
        for(int i = 1; i <= N; i++) {
        	String line = br.readLine();
        	for(int j = 1; j <= M; j++) {
        		graph[i][j] = line.charAt(j-1)-'0';
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= M; j++) {
        		int max = Math.min(Math.min(dp_graph[i-1][j], dp_graph[i][j-1]), dp_graph[i-1][j-1]);
        		if(graph[i][j] == 1) dp_graph[i][j] = max + 1;
        		maxSquare = Math.max(maxSquare, dp_graph[i][j]);
        	}
        }
        	
        System.out.println(maxSquare * maxSquare);
        br.close();
    }
}
