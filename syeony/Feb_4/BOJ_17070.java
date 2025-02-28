import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,1,1);
		System.out.println(cnt);
	}
	
	static void dfs(int x, int y, int direct) {
		if(x==n-1 && y==n-1) {
			cnt+=1;
			return;
		}
		
		if(direct==1) {//가로
			if(x+1<n&&y+1<n&&arr[x+1][y+1]!=1&&arr[x+1][y]!=1&&arr[x][y+1]!=1) dfs(x+1,y+1,3);
			if(y+1<n&&arr[x][y+1]!=1) dfs(x,y+1,1);
		}
		if(direct==2) {//세로
			if(x+1<n&&arr[x+1][y]!=1) dfs(x+1,y,2);
			if(x+1<n&&y+1<n&&arr[x+1][y+1]!=1&&arr[x+1][y]!=1&&arr[x][y+1]!=1) dfs(x+1,y+1,3);
		}
		if(direct==3) {//대각선
			if(x+1<n&&y+1<n&&arr[x+1][y+1]!=1&&arr[x+1][y]!=1&&arr[x][y+1]!=1) dfs(x+1,y+1,3);
			if(x+1<n&&arr[x+1][y]!=1) dfs(x+1,y,2);
			if(y+1<n&&arr[x][y+1]!=1) dfs(x,y+1,1);
		}
	}
}
