import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] food;
    static ArrayList<Integer> eat = new ArrayList<Integer>();
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	food = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		food[i] = Integer.parseInt(st.nextToken());
    	}
    	find(0);
    	bw.write(max + "\n");
    	bw.flush();
    }
    
    static void find(int idx) {
    	if(idx >= N) {
    		max = Integer.max(max, calc());
    		return;
    	}
    	int sum = 0;
    	int cnt = 0;
    	while(sum < K && idx + cnt < N) {
    		eat.add(food[idx+cnt]);
    		sum += food[idx+cnt];
    		cnt++;
    	}
    	find(idx+cnt);
    	for(int a = 0; a < cnt; a++) {
    		eat.remove(eat.size()-1);
    	}
    	find(idx+1);
    }
    
    static int calc() {
    	int ans = 0;
    	int temp = 0;
    	for(int i = 0; i < eat.size(); i++) {
    		temp += eat.get(i);
    		if(temp >= K) {
    			ans += temp-K;
    			temp = 0;
    		}
    	}
    	return ans;
    }
}
