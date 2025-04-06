package _0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj1946 {
	
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
			
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).a + " " + list.get(i).b);
			}
			
		}//case
	}//main
}
