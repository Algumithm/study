import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014 {
	
	static int[] visited;
	static int f,s,g,u,d;
	
	
	static int bfs() {
		
	Queue<Integer> q=new ArrayDeque<>();
	
	q.offer(s);
	visited[s]=0;
	
	while(!q.isEmpty()) {
		int cur=q.poll();
		if(cur==g) {
			return visited[g];
		}
		if(cur+u<=f && cur+u>0 &&visited[cur+u]==-1) {
			q.offer(cur+u);
			visited[cur+u]=visited[cur]+1;
				
		}
		if(cur-d<=f&&cur-d>0&& visited[cur-d]==-1) {
			q.offer(cur-d);
			visited[cur-d]=visited[cur]+1;
				
		}
		
		
		
		
		
	}
		
	return -1;
		
	
		
	}
	
	
	
	
public static void main(String[] args) throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	
	f=Integer.parseInt(st.nextToken());
	s=Integer.parseInt(st.nextToken());
	g=Integer.parseInt(st.nextToken());
	u=Integer.parseInt(st.nextToken());
	d=Integer.parseInt(st.nextToken());
	
	visited=new int[f+1];
	
	//-1로 초기화
	Arrays.fill(visited, -1);
	
	int answer=bfs();
	if(answer==-1) {
		System.out.println("use the stairs");
	}else {
		System.out.println(answer);
			
	}
	
	
	
	
}
}
