import java.io.*;
import java.util.*;

public class Main {
	static Queue<Integer> num = new LinkedList<Integer>();
	static int min = 999;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
       	
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
        	num.add(i);
        }
        while(num.size() != 1) {
        	num.remove();
        	num.add(num.peek());
        	num.remove();
        }
        
        bw.write(num.peek() + "\n");
        bw.flush();
    }
}
