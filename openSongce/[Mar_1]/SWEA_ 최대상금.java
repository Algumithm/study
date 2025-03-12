import java.lang.*;
import java.io.*;
import java.util.*;


public class Solution {
	static int max;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= test_n; i++) {
			String[] strs = br.readLine().split(" ");
			String[] num = strs[0].split("");
			int chance = Integer.parseInt(strs[1]);
			
			int[] calc = new int[num.length];
			for(int j = 0; j < num.length; j++) {
				calc[j] = Integer.parseInt(num[j]);
			}
			
			
			
			if(chance > calc.length) {
				chance = calc.length;
			}
			
			
			max = 0;
			find(chance, calc, 0);
			System.out.println("#" + i + " " + max);
			
		}
		
	}
	
	
//	static void comb(int n, int k, List<Integer> temp, List<List<Integer>> list, int start) {
//		if(temp.size()==k) {
//			list.add(new ArrayList<>(temp));
//			return;
//		}
//		
//		for(int i = start; i < n; i++) {
//			temp.add(i);
//			comb(n, k, temp, list, start);
//			temp.remove(temp.size()-1);
//		}
//	}
	
	
	static void change(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return;
	}
	
	static void find(int chance, int[] arr, int num) {

	
		if(num == chance) {
			int temp = 0;
			for(int a : arr) {
				temp = temp*10+a;
			}

			max = Math.max(max, temp);
			return;
		}
		
//		for(int i = start; i < list.size(); i++) {
//			change(list.get(i).get(0), list.get(i).get(1), arr);
//			find(chance, arr, num+1, i+1, list);
//			change(list.get(i).get(1), list.get(i).get(0), arr);
//		}
		
		
		
		int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                change(i, j, arr);  //  숫자 위치 교환
                find(chance, arr, num + 1);  // 다음 단계 탐색
                change(i, j, arr);  //  원상 복구
            }
        }

	}
}
