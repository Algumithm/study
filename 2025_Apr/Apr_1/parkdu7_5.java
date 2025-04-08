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

public class Main {
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
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}
		
		
		if(min == Integer.MAX_VALUE) { //선거구를 나눌 수 없는 경우
			min = -1;
		}
		
		System.out.println(min);
	}//main
	
	static void dfs(int idx, int cnt) {
	//dfs돌때마다 나머지방문하지 않은 곳과 방문한 곳가 모두 연결되어있는지 확인하고 연결되어있다면 diff 계산
		if(cnt == N)
			return;
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i])
				tmp.add(i);
		}//방문하지 않은 곳 전부 넣기
		
		if(checkInvistedConnection(tmp) && checkVisitedConnection()){
			//방문한 것들과 방문하지 않은 것들이 모두 이어져 있다면
			min = Math.min(min, calcDiff());//diff 계산
		}
		
		for (int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
		
		
	}//main
	
	static boolean checkInvistedConnection(List<Integer> list) { //방문 안한것들 연결 확인
		if(list.size() == 0 || list.size() == N)
			return false;
			
		visited[list.get(0)] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i: ward.get(list.get(0)).adjacent) {
			if(!visited[i]) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for (int i : ward.get(tmp).adjacent) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				for (int j = 0; j < list.size(); j++) {
					visited[list.get(j)] = false;
				}//초기화
				
				return false;
			}
		}
		
		for (int j = 0; j < list.size(); j++) {
			visited[list.get(j)] = false;
		}//초기화
		
		return true;
	}//checkConnection
	
	static boolean checkVisitedConnection() { //방문한것들 연결 확인
	    boolean[] tempVisited = new boolean[N];
	    
	    int start = -1;
	    for (int i = 0; i < N; i++) {
	        if (visited[i]) {
	            start = i;
	            break;
	        }
	    }
	    
	    if (start == -1)
	    	return false;
	     
	    Queue<Integer> q = new LinkedList<>();
	    q.add(start);
	    tempVisited[start] = true;

	    while (!q.isEmpty()) {
	        int tmp = q.poll();
	        for (int i : ward.get(tmp).adjacent) {
	            if (visited[i] && !tempVisited[i]) {
	                tempVisited[i] = true;
	                q.add(i);
	            }
	        }
	    }

	    for (int i = 0; i < N; i++) {
	    	//방문한 것 중에 이어져 있지 않은 노드가 있으면
	        if (visited[i] && !tempVisited[i]) 
	        	return false;
	    }

	    return true;
	}

	
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
