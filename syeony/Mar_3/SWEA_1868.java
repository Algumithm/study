package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1868 {
	static int n;
	static char[][] map;
	static int[] dx= {0,0,1,-1,1,-1,1,-1};
	static int[] dy= {1,-1,0,0,1,-1,-1,1};
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			n=Integer.parseInt(br.readLine());
			
			map=new char[n][n];
			for(int i=0;i<n;i++) {
				String line=br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j]=line.charAt(j);
				}
			}
			
//			System.out.println(Arrays.deepToString(map));
			answer=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]=='.' && isZero(i,j)) {
						bfs(i,j);
						answer++;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]=='.') {
						answer++;
					}
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
		
	}
	
	static boolean isZero(int x,int y) {
		int cnt=0;
		
		for(int i=0;i<8;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(isEdge(nx,ny)) {
				cnt++;
				continue;
			}
			
			if(map[nx][ny]!='*') {
				cnt++;
			}
		}
		
		if(cnt==8) return true;
		else return false;
	}
	
	static boolean isEdge(int x,int y) {
		return (x<0 || y<0 || x>=n || y>=n);
	}
	
	static void bfs(int x,int y) {
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {x,y});
		map[x][y]=0;
		
		while(!q.isEmpty()) {
			int[] c=q.poll();
			int cx=c[0];
			int cy=c[1];
			
			for(int i=0;i<8;i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				
				if(isEdge(nx,ny)) continue;
				
				if(map[nx][ny]=='.') {
					if(isZero(nx,ny)) {
						q.add(new int[] {nx,ny});
						map[nx][ny]=0;
					}else {
						map[nx][ny]=1;
					}
				}
			}
		}
	}
	
}
