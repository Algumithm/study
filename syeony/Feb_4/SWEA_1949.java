import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_1949 {
	static int[][] arr;
	static int n,k,max_height,max_path;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			max_height=0;
			
			arr=new int[n][n];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					max_height=Math.max(max_height, arr[i][j]);
				}
			}
			
			max_path=0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]==max_height) {
						v=new boolean[n][n];
						v[i][j]=true;
						update(i,j,1,arr[i][j],k);
					}
				}
			}
			
			System.out.println("#"+t+" "+max_path);
			
		}
	}
	
	static void update(int x,int y, int path, int h, int k) {
		max_path=Math.max(max_path, path);
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx>=n || nx<0 || ny>=n || ny<0 || v[nx][ny]) continue;
			if(arr[nx][ny]<h) {
				v[nx][ny]=true;
				update(nx,ny,path+1,arr[nx][ny],k);
				v[nx][ny]=false;
			}
			
			if(arr[nx][ny]>=h && k!=0) {
				if(arr[nx][ny]-k<h) {
					v[nx][ny]=true;
					update(nx,ny,path+1,h-1,0);
					v[nx][ny]=false;
				}
			}
			
		}
	}

}
