import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {-1,1, 0, 0, 0, 0};
    static int[] dy;
    static int[][] tomato, dis;
    static boolean[][] visit;
    static int N, M, H;
    static int max = Integer.MIN_VALUE;
    static Queue<int[]> q;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	H = Integer.parseInt(st.nextToken());
    	tomato = new int[N*H][M];
    	visit = new boolean[N*H][M];
    	dis = new int[N*H][M];
    	dx = new int[] {-1,1,0,0, -N, N};
    	dy =new int[]{0,0,-1,1, 0, 0};
    	
    	for(int i = 0; i < N*H; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			int a = Integer.parseInt(st.nextToken());
    			tomato[i][j] = a;
    			if(a == -1) dis[i][j] = -1;
    		}
    	}
    	bfs();
//		for(int j = 0; j < N*H; j++) {
//    		for(int k = 0; k < M; k++) {
//    			System.out.print(dis[j][k] + " ");
//    		}
//    		System.out.println();
//    	}
//		System.out.println();
    	if(!notomato()) bw.write(-1+"\n");
    	else bw.write(findmax()-1+"\n");
        bw.flush();
    }
    
    static void bfs() {
    	q = new LinkedList<int[]>();
    	for(int i = 0; i < N*H; i++) {
    		for(int j = 0; j < M; j++) {
    			if(tomato[i][j] == 1) {
    				q.add(new int[] {i, j});
    				dis[i][j] = 1;
    			}
    		}
    	}
    	
    	while(!q.isEmpty() ) {
    		int[] temp = q.poll();
    		for(int i = 0; i < 6; i++) {
    			int nx = temp[0] + dx[i];
    			int ny = temp[1] + dy[i];
    			if(i != 4 && i != 5) {
    				if(checklayer(temp[0], temp[1], nx, ny) && check(nx, ny) && !visit[nx][ny] && tomato[nx][ny] == 0) {
        				q.add(new int[] {nx,ny});
        				visit[nx][ny] = true;
        				dis[nx][ny] = dis[temp[0]][temp[1]]+1;
        			}
    			}
    			else {
	    			if(check(nx, ny) && !visit[nx][ny] && tomato[nx][ny] == 0) {
	    				q.add(new int[] {nx,ny});
	    				visit[nx][ny] = true;
	    				dis[nx][ny] = dis[temp[0]][temp[1]]+1;
//    					for(int j = 0; j < N*H; j++) {
//    			    		for(int k = 0; k < M; k++) {
//    			    			System.out.print(dis[j][k] + " ");
//    			    		}
//    			    		System.out.println();
//    			    	}
//    					System.out.println();
	    			}
    			}
    		}
    	}
    }
    
    static boolean checklayer(int x, int y,int nx, int ny) {
        int cur = x / N;
        
        int s = cur * N;
        int e = s + N;
        if (nx < s || nx >= e) return false;
        
        return true;
    }
    
    static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= N * H || y >= M) return false;
        return true;
    }

    
    static int findmax() {
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < N*H; i++) {
    		for(int j = 0; j < M; j++) {
    				max = Math.max(max, dis[i][j]);
    		}
    	}
    	return max;
    }
    
    static boolean notomato() {
    	for(int i = 0; i < N*H; i++) {
    		for(int j = 0; j < M; j++) {
    				if(dis[i][j] == 0) return false;
    		}
    	}
    	return true;
    }
}
