package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class position {
	int x,y,dist,key;
	
	public position(int x,int y,int dist,int key) {
		this.x=x;
		this.y=y;
		this.dist=dist;
		this.key=key;
	}
}

public class BOJ_1194 {
	static int n,m;
	static char[][] map;
	static boolean[][][] v;
	static int startx,starty;
	static int answer;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map=new char[n][m];
		startx=starty=0;
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=line.charAt(j);
				if(map[i][j]=='0') {
					startx=i;
					starty=j;
				}
			}
		}
		v=new boolean[n][m][64];
		answer=0;
		bfs();
		
		if(answer==0) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
	}
	
	static void bfs() {
		Queue<position> q=new LinkedList<>();
		q.offer(new position(startx,starty,0,0));
		v[startx][starty][0]=true;
		
		while(!q.isEmpty()) {
			position pos=q.poll();
			
			if(map[pos.x][pos.y]=='1') {
				answer=pos.dist;
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx=pos.x+dx[i];
				int ny=pos.y+dy[i];
				
				if(isEdge(nx,ny) || map[nx][ny]=='#' || v[nx][ny][pos.key]) continue;
				
				if(map[nx][ny]>='a' && map[nx][ny]<='f') {
					int nextkey = pos.key | (1 << (map[nx][ny]-'a'));
					q.offer(new position(nx,ny,pos.dist+1,nextkey));
					v[nx][ny][nextkey]=true;
				}
				
				else if(map[nx][ny]>='A' && map[nx][ny]<='F') {
					int cango = pos.key & (1 << (map[nx][ny]-'A'));
					
					if(cango!=0) {
						q.offer(new position(nx,ny,pos.dist+1,pos.key));
						v[nx][ny][pos.key]=true;
					}
				}
				
				else {
					v[nx][ny][pos.key]=true;
					q.offer(new position(nx,ny,pos.dist+1,pos.key));
				}
				
			}
		}
	}
	
	static boolean isEdge(int x,int y) {
		return (x<0 || y<0 || x>=n ||y>=m);
	}
}
