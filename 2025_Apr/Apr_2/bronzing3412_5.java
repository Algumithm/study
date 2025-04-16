import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int sum = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dice = {1, 6, 2, 5, 4, 3};
    static int dir = 3;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int sx = 0;
        int sy = 0;
        int s = 6;
        for(int i = 0; i < K; i++) {
        	if(sx + dx[dir] < 0 || sy + dy[dir] < 0 
        			|| sy + dy[dir] >= M || sx + dx[dir] >= N) {
        		if(dir == 0) dir = 1;
        		else if(dir == 1) dir = 0;
        		else if(dir == 2) dir = 3;
        		else if(dir == 3) dir = 2;
        	}
        	sx = sx + dx[dir];
        	sy = sy + dy[dir];
        	s = dicemove(dir, s);
        	sum += bfs(sx, sy, map[sx][sy]) * map[sx][sy];
        	if(s > map[sx][sy]) {
        		if(dir == 0) dir = 3;
        		else if(dir == 1) dir = 2;
        		else if(dir == 2) dir = 0;
        		else if(dir == 3) dir = 1;
        	} else if(s < map[sx][sy]) {
        		if(dir == 0) dir = 2;
        		else if(dir == 1) dir = 3;
        		else if(dir == 2) dir = 1;
        		else if(dir == 3) dir = 0;
        	}
        }
        bw.write(sum+"\n");
        bw.flush();
    }
    
    static int bfs(int sx, int sy, int num) {
    	Queue<int[]> q = new LinkedList<int[]>();
    	int cnt = 1;
    	q.add(new int[] {sx, sy});
    	boolean[][] visit = new boolean[N][M];
    	visit[sx][sy] = true;
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int nx = cur[0] + dx[i];
    			int ny = cur[1] + dy[i];
    			if(check(nx, ny) && !visit[nx][ny] && map[nx][ny] == num) {
    				q.add(new int[] {nx, ny});
    				visit[nx][ny] = true;
    				cnt++;
    			}
    		}
    	}
    	return cnt;
    }
    
    static boolean check(int x, int y) {
    	if(x < 0 || y < 0 || x >= N || y >= M) return false;
    	else return true;
    }
    
    static int dicemove(int dir, int cur) {
    	int temp;
        if (dir == 0) {
            temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        } else if (dir == 1) {
            temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        } else if (dir == 2) {
            temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        } else {
            temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        }
        return dice[1];
    }
}
