import java.util.*;
import java.lang.*;
import java.io.*;



public class Main {
	public static void main(String[] args) throws Exception{
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap();
		for(int i = 1; i <= n; i++) {
			String[] strs = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				if(i==j+1) {
					continue;
				}
				String key = i + ", " +(j+1);
				map.put(key, Integer.parseInt(strs[j]));
			}
		}
		for(int i = 1; i <=n; i++) {
			list.add(i);
		}
		
		combine(list, n/2, 0, new ArrayList<>(), result);
		
		list.clear();
		int min = Integer.MAX_VALUE;
		for(List<Integer> a : result) {
			list.add(getPermutations(a, map));
		}
		for(int i = 0; i < list.size()/2; i++) {
			if(min > Math.abs(list.get(i)-list.get(list.size()-1-i))) {
				min = Math.abs(list.get(i)-list.get(list.size()-1-i));
			}
		}
		System.out.println(min);
	}
	
	
	
	public static void combine(List<Integer> arr, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));  // k개를 고른 조합을 결과에 추가
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            current.add(arr.get(i));  // 선택한 원소 추가
            combine(arr, k, i + 1, current, result);  // 다음 원소로 재귀 호출
            current.remove(current.size() - 1);  // 선택한 원소 제거 (백트래킹)
        }
    }
	
	static int getPermutations(List<Integer> list, Map<String, Integer> map) {
        int n = list.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) { // 같은 원소를 두 번 선택하지 않도록!!!
                    String key = list.get(i) + ", " + list.get(j);
                    sum += map.get(key);
                }
            }
        }
        
        return sum;
    }

}
