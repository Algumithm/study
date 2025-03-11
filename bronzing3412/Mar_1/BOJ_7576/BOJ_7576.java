import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] tomato, dis;
    static boolean[][] visit;
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static Queue<int[]> q;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	tomato = new int[N][M];
    	visit = new boolean[N][M];
    	dis = new int[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			int a = Integer.parseInt(st.nextToken());
    			tomato[i][j] = a;
    			if(a == -1) dis[i][j] = -1;
    		}
    	}
    	
    	bfs();
    	if(!notomato()) bw.write(-1+"\n");
    	else bw.write(findmax()-1+"\n");
        bw.flush();
    }
    
    static void bfs() {
    	q = new LinkedList<int[]>();
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(tomato[i][j] == 1) {
    				q.add(new int[] {i, j});
    				dis[i][j] = 1;
    			}
    		}
    	}
    	
    	while(!q.isEmpty() ) {
    		int[] temp = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int nx = temp[0] + dx[i];
    			int ny = temp[1] + dy[i];
    			if(check(nx, ny) && !visit[nx][ny] && tomato[nx][ny] == 0) {
    				q.add(new int[] {nx,ny});
    				visit[nx][ny] = true;
    				if(dis[nx][ny] > dis[temp[0]][temp[1]]+1 || dis[nx][ny] == 0)
    					dis[nx][ny] = dis[temp[0]][temp[1]]+1;
    			}
    		}
    	}
    }
    
    static boolean check(int x, int y) {
    	if(x < 0 || y < 0 || x >= N || y >= M) return false;
    	else return true;
    }
    
    static int findmax() {
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    				max = Math.max(max, dis[i][j]);
    		}
    	}
    	return max;
    }
    
    static boolean notomato() {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    				if(dis[i][j] == 0) return false;
    		}
    	}
    	return true;
    }
}
