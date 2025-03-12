import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static List<Integer>[] map;
    static boolean[] visit;
    static int ans;
    static Queue<int[]> q;
    static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	map = new ArrayList[N + 1];
    	visit = new boolean[N+1];
    		
    	for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
    	
    	for(int i = 0; i < N-1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		map[a].add(b);
            map[b].add(a);
    	}
    	
    	bfs(1, 1);
    	for(int i = 2; i <= N; i++) {
    		bw.write(hm.get(i) + "\n");
    	}
        bw.flush();
    }

    static void bfs(int start, int prev) throws Exception{
    	q = new LinkedList<int[]>();
    	q.add(new int[] {start, prev});
    	visit[start] = true;
    	while(!q.isEmpty()) {
    		int[] temp = q.poll();
//    		if(temp[0] == goal) {
//    			ans = temp[1];
//    			return;
//    		}
    		hm.put(temp[0], temp[1]);
    		for (int next : map[temp[0]]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new int[]{next, temp[0]});
                }
            }
    	}
    }
}
