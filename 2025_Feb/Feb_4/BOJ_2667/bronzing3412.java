import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static int[][] map;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] dx = {-1, 1, 0 ,0};
	static int[] dy = {0, 0, -1 ,1};
	static int cnt = 0;
	static int N;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
    public static void main(String[] args) throws Exception{
        
    	N = Integer.parseInt(br.readLine());
    	
    	map = new int[N][N];
    	visit = new boolean[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < N; j++) {
    			map[i][j] = s.charAt(j) -'0';
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] == 1 && !visit[i][j]) {
    				cnt++;
    				dfs(i,j);
    			}
    		}
    	}
    	bw.write(cnt+"\n");
    	for(int i = 1; i <= cnt; i++) {
    		arr.add(cnt(i));
    	}
    	arr.sort(null);
    	for(int i = 0; i < arr.size(); i++) {
    		bw.write(arr.get(i)+"\n");
    	}
    	bw.flush();
    }
    
    static void dfs(int x, int y) {
    	visit[x][y] = true;
    	map[x][y] = cnt;
    	for(int i = 0; i < 4; i++) {
    		int newx = x+dx[i];
    		int newy = y+dy[i];
    		if(check(newx, newy) && !visit[newx][newy] && map[newx][newy] == 1) dfs(newx, newy);
    	}
    }
    
    static boolean check(int x, int y) {
    	if(x < 0 || y < 0 || x >= N || y >= N) return false;
    	else return true;
    }
    
    static int cnt(int n) {
    	int sum = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] == n) sum++;
    		}
    	}
    	
    	return sum;
    }
}
