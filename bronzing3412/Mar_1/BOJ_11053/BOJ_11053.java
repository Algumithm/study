import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] arr, len;
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	arr = new int[N];
    	len = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		len[i] = 1;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = i+1; j < N; j++) {
    			if(arr[j] > arr[i]) len[j] = Math.max(len[j], len[i]+1);
    		}

    	}
    	int max = 0;
		for(int j = 0; j < N; j++) {
    		max = Math.max(max, len[j]);
    	}
		bw.write(max+"\n");
        bw.flush();
    }


}
