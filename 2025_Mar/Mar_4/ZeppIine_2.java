import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Tree implements Comparable<Tree>{
		int height;
		int growHeight;
		
		Tree(int height, int growHeight){
			this.height = height;
			this.growHeight = growHeight;
		}
		
		@Override
		public int compareTo(Tree o) {
			return this.growHeight == o.growHeight ? o.height - this.height : this.growHeight - o.growHeight;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		int[] height = new int[size];
		int[] growHeight = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			growHeight[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Tree> pq = new PriorityQueue<>();
		
		for(int i = 0; i < size; i++) {
			pq.add(new Tree(height[i], growHeight[i]));
		}
		
		int count = 0;
		long result = 0;
		while(!pq.isEmpty()) {
			Tree t = pq.poll();
			result += t.height + t.growHeight*count++;
		}
		
		System.out.println(result);
		br.close();
	}
}
