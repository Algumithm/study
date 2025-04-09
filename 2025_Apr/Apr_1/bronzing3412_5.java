import java.util.*;
import java.io.*;

class Main
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] num;
	static boolean[] team;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		map = new int[N+1][N+1];
		team = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= M; j++) {
				int L = Integer.parseInt(st.nextToken());
				map[i][L] = 1;
				map[L][i] = 1;
			}
		}
		
		findteam(1);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	static void findteam(int pos) {
		if(pos > N) {
			ArrayList<Integer> team1 = new ArrayList<Integer>();
			ArrayList<Integer> team2 = new ArrayList<Integer>();
			for(int i = 1; i <= N; i++) {
				if(team[i]) team1.add(i);
				else team2.add(i);
			}
			if(team1.size() == 0 || team2.size() == 0){
				return;
			}
			int res = calc(team1, team2);
			if(res >= 0) {
				min = Math.min(min, res);
			}
			return;
		}
		team[pos] = true;
		findteam(pos+1);
		team[pos] = false;
		findteam(pos+1);
	}
	
	static int calc(ArrayList<Integer> t1, ArrayList<Integer> t2) {
		if(bfs(t1)&& bfs(t2)) {			
			int num1 = 0;
			int num2 = 0;
			for(int i = 0; i < t1.size(); i++) {
				num1 += num[t1.get(i)];
			}
			for(int i = 0; i < t2.size(); i++) {
				num2 += num[t2.get(i)];
			}
			return Math.abs(num1-num2);
		}
		return -1;
	}
	
	static boolean bfs(ArrayList<Integer> t) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[N+1];
		q.add(t.get(0));
		visit[t.get(0)] = true;
		int count = 0;
		while(!q.isEmpty()) {
			int num = q.poll();
			count++;
			
			for(int i = 1; i <= N; i++) {
				if(!visit[i] && map[num][i] == 1 && t.contains(i)) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
		if(count == t.size()) return true;
		else return false;
	}
}
