import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<int[]> study;
    static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	study = new ArrayList<int[]>();
    	visit = new boolean[N];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		study.add(new int[] {a, b});
    	}
    	Collections.sort(study, (o1, o2) -> Integer.compare(o1[0], o2[0]));
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	pq.add(study.get(0)[1]);
    	for(int i = 1; i < N; i++) {
    		if(study.get(i)[0] >= pq.peek()) {
    			pq.poll();
    		}
    		pq.add(study.get(i)[1]);
    	}
    	bw.write(pq.size() + "\n");
    	bw.flush();
    }
}
