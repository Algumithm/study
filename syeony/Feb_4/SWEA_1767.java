import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw_1767 {
	static int n;
	static int[][] arr;
	static ArrayList<int[]> core;
	static int minres=Integer.MAX_VALUE;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static int maxCoreCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			n=Integer.parseInt(br.readLine());
			
			core=new ArrayList<int[]>();
			
			arr=new int[n][n];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken()); 
					if(arr[i][j]==1 && !(i==0 | j==0 || i==n-1 ||j==n-1)) {
						core.add(new int[] {i,j});
					}
				}
			}
			maxCoreCnt=0;
			findMinlen(0,0,0);
			
			System.out.println("#"+t+" "+minres);
		}
	}
	
	static void findMinlen(int idx, int corecnt, int wirelen) {
		if(idx==core.size()) {
			if(maxCoreCnt<corecnt) {
				minres=wirelen;
				maxCoreCnt=corecnt;
			}else if(maxCoreCnt==corecnt) {
				minres=Math.min(minres, wirelen);
			}			
			return;
		}
		
		int[] c=core.get(idx);
		int x=c[0];
		int y=c[1];
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(canConnect(nx,ny,i)) {
				findMinlen(idx+1,corecnt+1,wirelen+connectWire(nx,ny,i));
				unconnectWire(nx,ny,i);
			}
		}
		findMinlen(idx+1,corecnt,wirelen);
	}
	
	static int connectWire(int x, int y, int direct) {
		int count=0;
		while(x>=0&&y>=0&&x<n&&y<n) {
			arr[x][y]=-1;
			x+=dx[direct];
			y+=dy[direct];
			count++;
		}
		return count;
	}
	
	static void unconnectWire(int x, int y, int direct) {
		while(x>=0&&y>=0&&x<n&&y<n) {
			arr[x][y]=0;
			x+=dx[direct];
			y+=dy[direct];
		}
	}
	
	static boolean canConnect(int x, int y, int direct) {
		while(x>=0&&y>=0&&x<n&&y<n) {
			if(arr[x][y]!=0) return false;
			x+=dx[direct];
			y+=dy[direct];
		}
		return true;
	}
	

}
