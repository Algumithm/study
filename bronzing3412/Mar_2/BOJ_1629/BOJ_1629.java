import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
    	
    	st = new StringTokenizer(br.readLine());
    	long A = Integer.parseInt(st.nextToken());
    	long B = Integer.parseInt(st.nextToken());
    	long C = Integer.parseInt(st.nextToken());
    	System.out.println(calc(A,B,C));
    }
    
    static long calc(long A, long B, long C) {
    	if(B == 0) return 1;
    	
    	long temp = calc(A, B / 2, C);
    	temp = temp*temp%C;
    	if(B%2 == 1) {
    		return temp*A%C;
    	}
    	return temp;
    }
}
