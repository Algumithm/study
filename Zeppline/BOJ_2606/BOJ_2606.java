import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int cur;
		int next;
		
		Node(int c, int n){
			cur = c;
			next = n;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());
		
		List<Node> comLines= new ArrayList<Node>();
		
		for(int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			if(first < second) comLines.add(new Node(first, second));
			else comLines.add(new Node(second, first));
		}		
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		Set<Integer> s = new HashSet<Integer>();
		
		while(!q.isEmpty()) {
			int tg = q.poll();
			s.add(tg);
			for(int i = 0; i < comLines.size(); i++) {
				if(comLines.get(i).cur == tg) {
					if(!s.contains(comLines.get(i).next)) q.add(comLines.get(i).next);
					comLines.remove(i--);
				} else if(comLines.get(i).next == tg) {
					if(!s.contains(comLines.get(i).cur)) q.add(comLines.get(i).cur);
					comLines.remove(i--);
				}
			}
		}
		
		System.out.println(s.size()-1);
		
		br.close();
	}
}
