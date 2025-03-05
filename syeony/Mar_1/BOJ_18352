import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k,x;
	static ArrayList<Integer>[] list;
	static PriorityQueue<Integer> pq;
	static boolean[] v;
	static int[] depth;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		
		pq=new PriorityQueue<>();
		v=new boolean[n+1];
		depth=new int[n+1];
		
		bfs(x);
		
//		System.out.println(Arrays.toString(depth));
		
		if(pq.isEmpty()) {
			System.out.println(-1);
		}else {
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
		}
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		v[start]=true;
		
		while(!q.isEmpty()) {
			int s=q.poll();
			
			for(int i:list[s]) {
				if(!v[i]) {
					v[i]=true;
					depth[i]=depth[s]+1;
					if(depth[i]==k) pq.add(i);
					q.add(i);
				}
			}
			
			
		}
		
	}

}
