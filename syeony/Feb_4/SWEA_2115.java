import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m,c;
	static int[][] arr;
	static int ma;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			arr=new int[n][n];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			} // 입력

			int one=0;
			int two=0;
			int res=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-m+1;j++) {
					//one 저장
					ma=0;
					getMax(i,j,0,0,0);
					one=ma;
					
					ma=0;
					//two 저장 
					//two-1:one이랑 같은열에서 
					for(int y=j+m;y<n-m+1;y++) {
						getMax(i,y,0,0,0);
					}
					
					//two-2:one 다음열에서
					for(int x=i+1;x<n;x++) {
						for(int y=0;y<n-m+1;y++) {
							getMax(x,y,0,0,0);
						}
					}
					two=ma;
					
					res=Math.max(res, one+two);
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	
	static void getMax(int x, int y, int idx, int sum, int jegop) {
		if(sum>c) return;
		
		if(idx==m) {
			ma=Math.max(ma, jegop);
			return;
		}
		
		getMax(x,y+1,idx+1,sum+arr[x][y],jegop+(arr[x][y]*arr[x][y]));
		getMax(x,y+1,idx+1,sum,jegop);
	}
}
