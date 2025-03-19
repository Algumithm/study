import java.io.*;
import java.util.*;

public class BJ10971 {
	static int[][] arr;
	static boolean[] visited;
	static int result;
	static int n;
	static int[] perm;
	
	public static void solve(int idx,int previous,int current) {
		if(result<current) {
			return;
		}
		if(idx==n) {//n개도시 방문했을때
			int xIndex=perm[n-1];// 마지막에 방문했던곳
			int yIndex=perm[0]; //처음 방문했던곳
			if(arr[xIndex][yIndex]!=0) {
				current=current+arr[xIndex][yIndex];
				result=Math.min(result,current);
				
			}
			return;
			
		}else { //n개도시 방문못했을때
			
			for(int i=0;i<n;i++) {
				if(!visited[i]&&arr[previous][i]!=0) {
					visited[i]=true;
					perm[idx]=i;
					solve(idx+1,i,current+arr[previous][i]);
					visited[i]=false;					

				}
			}
			
		
			
		}
	}
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		visited=new boolean[n];
		perm=new int[n];
		
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			st=new StringTokenizer(line);
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		
		result=Integer.MAX_VALUE;

		for(int k=0;k<n;k++) { //시작도시 정하기
			visited[k]=true;
			perm[0]=k;
			solve(1,k,0);
			visited[k]=false;
		}
		
		System.out.println(result);		
		
	}
	

	
}
