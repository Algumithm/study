import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) == Math.abs(o2)) return o1- o2;
			else return Math.abs(o1) - Math.abs(o2);
		}
	});
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
            	if(pq.isEmpty()) bw.write(0 + "\n");
            	else bw.write(pq.poll() + "\n");
            } else {
            	pq.add(num);
            }
        }

        bw.flush();
    }
}
