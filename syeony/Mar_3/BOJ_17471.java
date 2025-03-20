package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_17471 {
	static int n;
	static ArrayList<Integer> one, two;
	static int[] people;
	static ArrayList<Integer>[] li;
	static int min;
	static boolean[] v_one, v_two;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		
		people=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			people[i]=Integer.parseInt(st.nextToken());
		}
		
		li=new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			li[i]=new ArrayList<Integer>();
		}
		
		for(int i=1;i<n+1;i++) {
			st=new StringTokenizer(br.readLine());
			int idx=Integer.parseInt(st.nextToken());
			for(int j=0;j<idx;j++) {
				li[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		one=new ArrayList<>();
		two=new ArrayList<>();
		min=Integer.MAX_VALUE;
		
		sub(1);
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
	}
	
	static void sub(int idx) {
		if(idx>n) {
			if(!one.isEmpty() && one.size()!=6) {
//				System.out.print(one+" ");
				two.clear();
				for(int i=1;i<n+1;i++) {
					if(!one.contains(i)) {
						two.add(i);
					}
				}
				
//				System.out.println(two);
				
				// 만약 `two`가 비어있다면 탐색할 필요 없음
                if (two.isEmpty()) return;

                v_one = new boolean[n + 1];
                v_two = new boolean[n + 1];

                // `one`과 `two`가 비어있지 않을 때만 탐색 수행
                if (!one.isEmpty()) dfs_one(one.get(0));
                if (!two.isEmpty()) dfs_two(two.get(0));
				
				if(isConnected(v_one,one) && isConnected(v_two,two)) {
					int o=0;
					int t=0;
					for(int i:one) {
						o+=people[i];
					}
					for(int j:two) {
						t+=people[j];
					}
					min=Math.min(min, Math.abs(o-t));
				}
			}
			
			return;
		}
		
		one.add(idx);
		sub(idx+1);
		one.remove(one.size()-1);
		
		sub(idx+1);
	}
	
	static boolean isConnected(boolean[] v, ArrayList<Integer> list) {
		for(int node:list) {
			if(!v[node]) return false;
		}
		
		return true;
	}
	
	static void dfs_one(int idx) {
		v_one[idx]=true;
		
		for(int i:li[idx]) {
			if(!v_one[i] && one.contains(i)) { //one 배열의 노드만 탐색
				dfs_one(i);
			}
		}
	}
	
	static void dfs_two(int idx) {
		v_two[idx]=true;
		
		for(int i:li[idx]) {
			if(!v_two[i] && two.contains(i)) { //two 배열의 노드만 탐색
				dfs_two(i);
			}
		}
	}
}
