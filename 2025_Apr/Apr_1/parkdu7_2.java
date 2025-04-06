import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Person implements Comparable<Person> {
		int a, b;

		public Person(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Person o) {
			return this.a - o.a;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		List<Integer> clist = new ArrayList<Integer>();
		for (int cs = 0; cs < T; cs++) {
			int N = Integer.parseInt(br.readLine());
			List<Person> list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Person(a, b));
			}

			list.sort(null);
			
			
			int minRank = list.get(0).b;
			int count = 1; // 1등 뽑고 시작
			for (int i = 1; i < list.size(); i++) {
				if(list.get(i).b < minRank) {
					count++;
					minRank = list.get(i).b; //b순위가 최소 순위보다 높으면 선택
				}
			}
			
			clist.add(count);
		}//case
		
		for (int i = 0; i < clist.size(); i++) {
			System.out.println(clist.get(i));
		}
	}//main
}
