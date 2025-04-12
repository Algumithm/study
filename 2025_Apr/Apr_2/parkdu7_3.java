import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Classroom implements Comparable<Classroom>{
	int start, end;
	
	Classroom(int s, int e){
		start = s; end = e;
	}
	
	@Override
	public int compareTo(Classroom o) { //수업 시작 시간을 기준으로 오름차순 정렬
		return this.start - o.start;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Classroom> list = new ArrayList<Classroom>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Classroom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		list.sort(null); //정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료 시간 저장 (빠른 종료 시간이 가장 앞으로 옴)
		pq.offer(list.get(0).end); // 첫 수업 종료 시간 등록

		for (int i = 1; i < N; i++) {
			if (pq.peek() <= list.get(i).start) {
				// 시작 시간이 이전 수업이 끝나고 나면 강의실 재사용
				pq.poll();
			}
			pq.offer(list.get(i).end); // 현재 수업 종료 시간 등록
		}
		//모든 수업을 돌고나서 큐에 남아있는 것들의 수가 필요한 강의실 수
		System.out.println(pq.size());
	}
}
