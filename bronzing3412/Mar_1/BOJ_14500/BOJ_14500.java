import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static int N;
    static int M;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		visit[i][j] = true;
        		dfs(i, j, 1, 0);
        		visit[i][j] = false;
        		for (int k = 0; k < 4; k++) {
        		    int nx = i + dx[k];
        		    int ny = j + dy[k];
    		        if (check(i - 1, j) && check(i, j - 1) && check(i, j + 1)) {
    		            int sum = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i][j + 1];
    		            max = Math.max(max, sum);
    		        }
    		        if (check(i + 1, j) && check(i, j - 1) && check(i, j + 1)) {
    		            int sum = map[i][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1];
    		            max = Math.max(max, sum);
    		        }
    		        if (check(i - 1, j) && check(i + 1, j) && check(i, j - 1)) {
    		            int sum = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j - 1];
    		            max = Math.max(max, sum);
    		        }
    		        if (check(i - 1, j) && check(i + 1, j) && check(i, j + 1)) {
    		            int sum = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j + 1];
    		            max = Math.max(max, sum);
    		        }
        		}
        	}
        }
        bw.write(max + "\n");
        bw.flush();
    }
    
    static void dfs(int x, int y, int cnt, int sum) {
    	
    	sum += map[x][y];
//    	System.out.println(x + " " + y + " " + cnt + " " + sum);
    	if(cnt == 4) {
    		max = Math.max(max, sum);
    		return;
    	}
    	for(int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(check(nx, ny) && !visit[nx][ny]) {
    			visit[nx][ny] = true;
    			dfs(nx, ny, cnt+1, sum);
    			visit[nx][ny] = false;
    		}
    	}
    }
    
    static boolean check(int x, int y) {
    	if(x < 0 || y < 0 || x >= N || y >= M) return false;
    	else return true;
    }
}
