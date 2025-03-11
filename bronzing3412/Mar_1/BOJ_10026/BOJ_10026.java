import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map1, map2;
    static boolean[][] visit1, visit2;
    static int N;

    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	map1 = new int[N][N];
    	map2 = new int[N][N];
    	visit1 = new boolean[N][N];
    	visit2 = new boolean[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < N; j++) {
    			char a = s.charAt(j);
    			if(a == 'B') {
    				map1[i][j] = 1;
    				map2[i][j] = 1;
    			} else if(a == 'R') {
    				map1[i][j] = 2;
    				map2[i][j] = 2;
    			} else {
    				map1[i][j] = 3;
    				map2[i][j] = 2;
    			}
    		}
    	}
    	int cnt = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(!visit1[i][j]) {
    				dfs1(i, j, map1[i][j]);
    				cnt++;
    			}
    		}
    	}
    	bw.write(cnt + " ");
    	cnt = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(!visit2[i][j]) {
    				dfs2(i, j, map2[i][j]);
    				cnt++;
    			}
    		}
    	}
    	bw.write(cnt + "\n");
        bw.flush();
    }
    
    static void dfs1(int x, int y, int cur) {
    	for(int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(check(nx, ny) && !visit1[nx][ny] && map1[nx][ny] == cur) {
    			visit1[nx][ny] = true;
    			dfs1(nx, ny, cur);
    		}
    	}
    }
    
    static void dfs2(int x, int y, int cur) {
    	for(int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(check(nx, ny) && !visit2[nx][ny] && map2[nx][ny] == cur) {
    			visit2[nx][ny] = true;
    			dfs2(nx, ny, cur);
    		}
    	}
    }
    
    static boolean check(int x, int y) {
    	if(x < 0 || y < 0 || x >= N || y >= N) return false;
    	else return true;
    }
}
