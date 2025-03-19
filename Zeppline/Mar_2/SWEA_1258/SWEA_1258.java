import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Arr implements Comparable<Arr>{
		int n;
		int m;
		int count;
		
		Arr(int n, int m){
			this.n = n;
			this.m = m;
			this.count = n*m;
		}

		@Override
		public int compareTo(Arr o) {		    		    
		    return this.count == o.count ? this.m - o.m : this.count - o.count;
		}
	}
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = Integer.parseInt(br.readLine());
			
			int[][] map = new int[size][size];
			
			for(int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			List<Arr> lArr = new ArrayList<>();
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(map[i][j] != 0) {
						int x = 0, y = 0;
						for(int xj = j; xj < size; xj++) {
							if(map[i][xj] == 0) break;
							x++;
						}
						for(int yi = i; yi < size; yi++) {
							if(map[yi][j] == 0) break;
							y++;
						}
						lArr.add(new Arr(x, y));
						for(int yi = 0; yi < y; yi++) {
							for(int xj = 0; xj < x; xj++) {
								map[i + yi][j + xj] = 0;
							}
						}
					}
				}
			}
			int result = lArr.size();
			Collections.sort(lArr);
			
			System.out.print("#" + test_case + " " + result + " ");
			for(int i = 0; i < lArr.size(); i++) {
				System.out.print(lArr.get(i).m + " " + lArr.get(i).n + " ");
			}
			System.out.println();
		}
		br.close();
	}
}
