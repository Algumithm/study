import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] money;
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	money = new int[N];
    	st = new StringTokenizer(br.readLine());
    	int max = -1;
    	for(int i = 0; i < N; i++) {
    		money[i] = Integer.parseInt(st.nextToken());
    		max = Math.max(max, money[i]);
    	}
    	M = Integer.parseInt(br.readLine());
    	int low = 0;
    	int high = max;
    	int mid = (low + high) / 2;
    	while(low <= high) {
    		int temp = calc(mid); 
    		if(temp < M) {
    			low = mid +1;
    		} else if (temp > M) {
    			high = mid - 1;
    		} else {
    			break;
    		}
    		mid = (low + high) / 2;
    	}
    	bw.write(mid + "\n");
    	bw.flush();
    }
    
    static int calc(int n) {
    	int sum = 0;
    	for(int i = 0; i < N; i++) {
    		if(money[i] < n) {
    			sum += money[i];
    		} else {
    			sum += n;
    		}
    	}
    	return sum;
    }
}
