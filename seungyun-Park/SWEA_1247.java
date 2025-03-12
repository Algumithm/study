import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Customer{
	int x;
	int y;
	boolean visited;
	
	public Customer(int x, int y, boolean visited) {
		this.x = x;
		this.y = y;
		this.visited = visited;
	}
}

public class Solution {
	static int grid[][];
	static List<Customer> customers;
	static int[] company;
	static int[] home;
	static int min;
	static boolean visitedHome;
	static int o;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cs = Integer.parseInt(br.readLine());
		for (int c = 1; c <= cs; c++) {
			grid = new int[101][101];
			min = Integer.MAX_VALUE;
			visitedHome = false;
			customers = new ArrayList<>();
			
			o = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			company = new int[] {cx, cy};

			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			home = new int[] {hx, hy};
			
			while(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customers.add(new Customer(x, y, false));
			}
			
			dfs(company[0], company[1], 0, 0);

			System.out.println("#" + c + " " + min);
		}//for cs
	}//main
	
	static void dfs(int x, int y, int d, int cnt) {
//		System.out.println("cnt : " + cnt + ", dist : " + d);
		if(cnt == o) {
			d += Math.abs(home[0] - x) +  Math.abs(home[1] - y);
			min = Math.min(min, d);
			return;
		}
		
		for (int i = 0; i < o; i++) {
			Customer c = customers.get(i);
			if(!c.visited) {
				c.visited = true;
				int dist = Math.abs(c.x - x) +  Math.abs(c.y - y);
				dfs(c.x, c.y, d + dist, cnt + 1);
				c.visited = false;
			}
		}
	}
}//swea
