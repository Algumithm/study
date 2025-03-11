import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<String[]> q;
    static boolean[] visit;
    

    public static void main(String[] args) throws Exception {
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
        	q = new LinkedList<String[]>();
        	visit = new boolean[10001];
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int goal = Integer.parseInt(st.nextToken());
        	System.out.println(bfs(start, goal));
        }
        bw.flush();
    }
    
    static String bfs(int start, int goal) {
    	q.add(new String[] {Integer.toString(start), ""});
    	visit[start] = true;
    	while(!q.isEmpty()) {
    		String[] temp = q.poll();
    		int num = Integer.parseInt(temp[0]);
    		String s = temp[1];
    		if(num == goal) return s;
    		if(num*2 > 9999) {
    			if(!visit[(num*2)%10000]) {
	    			q.add(new String[] {Integer.toString((num*2)%10000), s+"D"});
	    			visit[(num*2)%10000] = true;
    			}
    		} else {
    			if(!visit[(num*2)]) {
	    			q.add(new String[] {Integer.toString((num*2)), s+"D"});
	    			visit[num*2] = true;
    			}
    		}
    		
    		if(num-1 < 0) {
    			if(!visit[9999]) {
	    			q.add(new String[] {Integer.toString(9999), s+"S"});
	    			visit[9999] = true;
    			}
    		} else {
    			if(!visit[num-1]) {
	    			q.add(new String[] {Integer.toString(num-1), s+"S"});
	    			visit[num-1] = true;
    			}
    		}
    		if(!visit[LL(num)]) {
	    		q.add(new String[] {Integer.toString(LL(num)), s+"L"});
	    		visit[LL(num)] = true;
    		}
    		
    		if(!visit[RR(num)]) {
	    		q.add(new String[] {Integer.toString(RR(num)), s+"R"});
	    		visit[RR(num)] = true;
    		}
    	}
    	return "??";
    }
    
    static int LL(int num) {
    	return (num % 1000) * 10 + num / 1000;
    }
    
    static int RR(int num) {
    	return (num % 10) * 1000 + num / 10;
    }
}
