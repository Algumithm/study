import java.io.*;
import java.util.*;

public class Main {
	static int[][] day;
	static boolean[] check;
	static int n = 0;
	static int max = 0; 
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
       	
        int sum = 0;
        n = Integer.parseInt(br.readLine());
        day = new int[n][2];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	day[i][0] = Integer.parseInt(st.nextToken());
        	day[i][1] = Integer.parseInt(st.nextToken());
        }
        
        find_max(0, 0);
        
        bw.write(max + "\n");
        bw.flush();
    }
    
    static void find_max(int index, int sum) {	
    	if (index >= n) { 
            max = Math.max(max, sum);
            return;
        }

        if (index + day[index][0] <= n) { 
            find_max(index + day[index][0], sum + day[index][1]);
        }
        
        find_max(index + 1, sum);
    }
}
