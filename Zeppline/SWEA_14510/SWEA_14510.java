import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tree_count = Integer.parseInt(br.readLine());
			int[] tree = new int[tree_count];
			int[] grow = new int[tree_count];
					
			int max_tree = 0;
			int total_count = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < tree_count; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max_tree = Math.max(max_tree, tree[i]);
			}
			for(int i = 0; i < tree_count; i++) {
				grow[i] = max_tree - tree[i];
				total_count += grow[i];
			}
			
			int day = 0;
			
			while(true) {
				Arrays.sort(grow);
				boolean tf = true;
				for(int i = 0; i < tree_count; i++) {
					if(grow[i] > 0) {
						tf = false;
						break;
					}
				}
				if(tf == true) break;
				
				day++;
				
				if(day % 2 == 1) {
					if(total_count == 2 && grow[tree_count-1] == 2) {
						day++;
						grow[tree_count-1] -= 2;
						total_count -= 2;
					} else {
						boolean tf2 = false;
						for(int i = 0; i < tree_count; i++) {
							if(grow[i] % 2 == 1) {
								grow[i]--;
								total_count--;
								tf2 = false;
								break;
							} else tf2 = true;
						}
						if(tf2) {
							for(int i = 0; i < tree_count; i++) {
								if(grow[i] >= 1) {
									grow[i]--;
									total_count--;
									break;
								}
							}
						}
					}
				} else {
					if(grow[tree_count-1] >= 2) {
						grow[tree_count-1] -= 2;
						total_count -= 2;
					}
				}
			}
			System.out.println("#" + test_case + " " + day);
		}
		br.close();
	}
}
