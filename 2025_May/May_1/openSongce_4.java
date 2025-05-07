package exam_0507;

import java.lang.*;
import java.io.*;
import java.util.*;

public class ex5014 {
	static int ceilF, startF, targetF, upF, downF;
	static int[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		ceilF = Integer.parseInt(strs[0]);
		startF = Integer.parseInt(strs[1]);
		targetF = Integer.parseInt(strs[2]);
		upF = Integer.parseInt(strs[3]);
		downF = Integer.parseInt(strs[4]);
		visited = new int[ceilF + 1];
		
		Arrays.fill(visited, -1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startF);
		visited[startF] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == targetF) break;
			
			if(cur + upF <= ceilF && visited[cur + upF] == -1) {
				visited[cur + upF] = visited[cur] + 1;
				q.add(cur + upF);
			}
			
			if(cur - downF >= 1 && visited[cur - downF] == -1) {
				visited[cur - downF] = visited[cur] + 1;
				q.add(cur - downF);
			}
			
		}
		
		if(visited[targetF] != -1) {
			System.out.println(visited[targetF]);
		}else {
			System.out.println("use the stairs");
		}
		
		
//		if(startF > targetF) {
//			if(downF == 0) {
//				System.out.println("use the stairs");
//				return;
//			}
//			else {
//				int sub = startF - targetF;
//				if(sub % downF == 0) {
//					System.out.println(sub / downF);
//					return;
//				}else {
//					int div = downF - (sub % downF);
//					if(div % upF == 0) {
//						System.out.println((sub / downF) + 1 + (div / upF));
//						return;
//					}else {
//						if(sub % (Math.abs(upF-downF)) == 0){
//							System.out.println((sub / downF) + (div / Math.abs(upF-downF))*2);
//							return;
//						}
//						else {
//							System.out.println("use the stairs");
//							return;
//						}
//					}
//				}
//			}
//		}else if(startF == targetF){
//			System.out.println(cnt);
//			return;
//		}else {
//			if(upF == 0) {
//				System.out.println("use the stairs");
//				return;
//			}else {
//				int sub = targetF - startF;
//				if(sub % upF == 0) {
//					System.out.println(sub / upF);
//					return;
//				}else {
//					int div = upF - (sub % upF);
//					if(div % downF == 0) {
//						System.out.println((sub / upF) + 1 + (div / downF));
//						return;
//					}else {
//						if(sub % (Math.abs(upF-downF)) == 0){
//							System.out.println((sub / upF) + (div / Math.abs(upF-downF)*2));
//							return;
//						}
//						else {
//							System.out.println("use the stairs");
//							return;
//						}
//					}
//				}
//			}
//		}
		
	}
	
	
}
