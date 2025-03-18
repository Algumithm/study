import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visit;
    static int[] dis;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int goal = Integer.parseInt(st.nextToken());
    	visit = new boolean[100001];
    	dis = new int[100001];
    	bfs(start, goal);
    	bw.write(dis[goal]+"\n");
    	bw.flush();
    }
    
    static void bfs(int start, int goal) {
    	Deque<Integer> q = new ArrayDeque<Integer>();
    	q.add(start);
    	dis[start] = 0;
    	visit[start] = true;
    	while(!q.isEmpty()) {
    		int num = q.poll();
    		if(num == goal) return;
    		if(num*2 <= 100000 && !visit[num*2]) {
    			q.addFirst(num*2);
    			visit[num*2] = true;
    			dis[num*2] = dis[num];
    		}
    		if( num-1 >= 0 && !visit[num-1]) {
    			q.add(num-1);
    			visit[num-1] = true;
    			dis[num-1] = dis[num]+1;
    		}
    		if(num +1 <= 100000 && !visit[num+1]) {
    			q.add(num+1);
    			visit[num+1] = true;
    			dis[num+1] = dis[num]+1;
    		}
    		
    	}
    }
}
