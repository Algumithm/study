import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static int[][] field;
	static boolean[][] visit;
	static int row;
	static int col;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int TC = Integer.parseInt(br.readLine());
    	for(int tc = 1; tc <= TC; tc++) {
    		st = new StringTokenizer(br.readLine());
    		row = Integer.parseInt(st.nextToken());
    		col = Integer.parseInt(st.nextToken());
    		int K = Integer.parseInt(st.nextToken());
    		
    		field = new int[row][col];
    		visit = new boolean[row][col];
    		cnt = 0;
    		for(int i = 0; i < K; i++) {
    			st = new StringTokenizer(br.readLine());
    			field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
    		}
    		
    		for(int i = 0; i < row; i++) {
        		for(int j = 0; j < col; j++) {
        			if(field[i][j] == 1 && !visit[i][j]) {
        				dfs(i,j);
        				cnt++;
        			}
        		}
        	}
    		bw.write(cnt+"\n");
    	}
    	
    	bw.flush();
    }
    
    static void dfs(int x, int y) {
    	visit[x][y] = true;
    	for(int i = 0; i < 4; i++) {
    		int newx = x+dx[i];
    		int newy = y+dy[i];
    		if(check(newx, newy) && !visit[newx][newy] && field[newx][newy] == 1) dfs(newx, newy);
    	}
    }
    
    static boolean check(int x, int y) {
    	if(x < 0 || y < 0 || x >= row || y >= col) return false;
    	else return true;
    }
}
