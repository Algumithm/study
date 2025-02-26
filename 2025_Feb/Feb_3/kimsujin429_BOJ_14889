import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] S;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		int min = Integer.MAX_VALUE;
		
		// 팀 인원 수
		int r = N/2;
		// 조합을 만들기 위해 번호를 저장하는 배열
		int[] elements = new int[N];
		
		for (int i = 0; i < N ; i++) {
			elements[i] = i;
		}
		
		// 배열에 입력값 입력
		for(int i = 0 ; i < N ; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j ++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<List<Integer>> combi_result = new ArrayList<>();
		Combinations(elements, new ArrayList<>(), 0, r, combi_result);
		
		List<Integer> link_team = new ArrayList<>();
		
		
		// 각 조합에서 순열 생성
		for(List<Integer> combination : combi_result) {
			int start_sum = 0;
			
			List<List<Integer>> perm_result = new ArrayList<>();
			boolean[] visited = new boolean[combination.size()];
			Permutation(combination, new ArrayList<>(), visited, 2, perm_result);
			
//			for(int index = 0 ; index < combination.size() ; index++) {
//				
//			}
			
			for(List<Integer>perm : perm_result) {
				int x = perm.get(0);
				int y = perm.get(1);
				start_sum += S[x][y];
			}
			
			int link_sum = 0;
			List<Integer> link_list = new ArrayList<>();
			for(int num : elements) {
				if (!combination.contains(num)) {
					link_list.add(num);
				}
			}
			
			List<List<Integer>> perm_result_link = new ArrayList<>();
			boolean[] visited_link = new boolean[link_list.size()];
			Permutation(link_list, new ArrayList<>(), visited_link, 2, perm_result_link);
			
//			for(int index = 0 ; index < combination.size() ; index++) {
//				
//			}
			
			for(List<Integer>perm_link : perm_result_link) {
				int x = perm_link.get(0);
				int y = perm_link.get(1);
				link_sum += S[x][y];
			}
			
			min = Math.min(min, Math.abs(start_sum - link_sum));
		}
		
		System.out.println(min);
	}
	
	public static void Combinations (int[] elements, List<Integer> combination, int start, int r, List<List<Integer>> result) {
		if (combination.size() == r) {
			result.add(new ArrayList<>(combination));
			return;
		}
		for (int i = start ; i < elements.length ; i++) {
			combination.add(elements[i]);
			Combinations(elements, combination, i+1, r, result);
			combination.remove(combination.size()-1);
		}
	}
	
	public static void Permutation(List<Integer> elements, List<Integer> current, boolean[] visited, int r, List<List<Integer>> result){
		if(current.size() == r) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		for(int i = 0; i < elements.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				current.add(elements.get(i));
				Permutation(elements, current, visited, r, result);
				current.remove(current.size() -1);
				visited[i] = false;
			}
		}
	}
	
	
	
	
	
}
