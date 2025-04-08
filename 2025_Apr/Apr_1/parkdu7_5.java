package _0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Ward{
	int population;
	List<Integer> adjacent  = new ArrayList<>();
	
	Ward(int p){
		population = p;
	}
	
	@Override
	public String toString() {
		
		return population + " " + adjacent.toString();
	}
}

public class bj17471 {
	static int N, min;
	static boolean visited[];
	static List<Ward> ward = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());//인구수
		for (int i = 0; i < N; i++) {
			ward.add(new Ward(Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());//인접 정보
			st.nextToken();
			while(st.hasMoreTokens()) {
				ward.get(i).adjacent.add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
//		for (int i = 0; i < ward.size(); i++) {
//			System.out.println(ward.get(i));
//		}
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}
		
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		
		System.out.println(min);
		
		
	}//main
	
	static void dfs(int idx, int cnt) {
		if(cnt == N)
			return;
//		for (int i = 0; i < visited.length; i++) {
//			System.out.print(visited[i] + " ");
//		}
//		System.out.println();
		
		
//		System.out.println("dfs" + " " + idx + ", next : " + next);
		
		//돌때마다 나머지(방문하지 않은 곳)가 모두 연결되어있는지 확인하고 연결되어있다면 diff 계산
		//혼자일떄도 확인 필요
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i])
				tmp.add(i);
		}//방문하지 않은 곳 전부 넣기
		for (int i = 0; i < tmp.size(); i++) {
			System.out.print(tmp.get(i) + " ");
		}
		System.out.println();
		if(checkConnection(tmp)){
			
			for (int i = 0; i < visited.length; i++) {
				System.out.print(visited[i] + " ");
			}
			System.out.println();
			
//			System.out.println(calcDiff());
			min = Math.min(min, calcDiff());
			//diff 계산
//			for (int i = 0; i < visited.length; i++) {
//				System.out.print(visited[i] + " ");
//			}
//			System.out.println();
		}
		
//		int next = -1;
//		for (int i = 0; i < ward.get(idx).adjacent.size(); i++) {
//			if (!visited[ward.get(idx).adjacent.get(i)]) {
//				next = ward.get(idx).adjacent.get(i);
//				visited[next] = true;
//				dfs(next);
//				visited[next] = false;
//			}
//		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
		
		
	}//main
	
	static boolean checkConnection(List<Integer> list) {
		if(list.size() == 0 || list.size() == N)
			return false;
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
//		System.out.println();
			
		visited[list.get(0)] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < ward.get(list.get(0)).adjacent.size(); i++) {
			if(!visited[ward.get(list.get(0)).adjacent.get(i)]) {
				q.add(ward.get(list.get(0)).adjacent.get(i));
				visited[ward.get(list.get(0)).adjacent.get(i)] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for (int i = 0; i < ward.get(tmp).adjacent.size(); i++) {
				if(!visited[ward.get(tmp).adjacent.get(i)]) {
					q.add(ward.get(tmp).adjacent.get(i));
					visited[ward.get(tmp).adjacent.get(i)] = true;
				}
			}
		}
//		for (int i = 0; i < visited.length; i++) {
//			System.out.print(visited[i] + " ");
//		}
//		System.out.println();
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				for (int j = 0; j < list.size(); j++) {
					visited[list.get(j)] = false;
				}//초기화
				
				return false;
			}
		}
		
//		System.out.println();
		for (int j = 0; j < list.size(); j++) {
			visited[list.get(j)] = false;
		}//초기화
		
//		for (int i = 0; i < visited.length; i++) {
//			System.out.print(visited[i] + " ");
//		}
		return true;
	}//checkConnection
	
	static int calcDiff() {
		int visitedCount = 0;
		int inVisitedCount = 0;
		
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				visitedCount += ward.get(i).population;
			}
			else {
				inVisitedCount += ward.get(i).population;
			}
		}
		
		return Math.abs(inVisitedCount - visitedCount);
	}//calcDiff
}
