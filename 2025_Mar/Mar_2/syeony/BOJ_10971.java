package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {
	static int n;
	static int[][] arr;
	static int mi;
	static boolean[] v;
	static int[] b;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		b=new int[n];
		
		mi=Integer.MAX_VALUE;
		v=new boolean[n];
		dfs(0);
		
		System.out.println(mi);
	}
	
	static void dfs(int idx) {
		if(idx==n) {
//			System.out.println(Arrays.toString(b));
			int dist=0;
			for(int i=0;i<n-1;i++) {
				if(arr[b[i]][b[i+1]]==0) {
					return;
				}
				dist+=(arr[b[i]][b[i+1]]);
			}
			if(arr[b[n-1]][b[0]]==0) {
				return;
			}else {
				dist+=(arr[b[n-1]][b[0]]);
			}
			
			mi=Math.min(mi, dist);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!v[i]) {
				v[i]=true;
				b[idx]=i;
				dfs(idx+1);
				v[i]=false;
			}
		}
	}

}
