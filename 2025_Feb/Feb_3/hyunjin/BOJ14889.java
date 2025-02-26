import java.io.*;
import java.util.*;

public class Main {
	static int[][] member;
	static boolean[] check;
	static int n = 0;
	static int min = 9999;
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
       	
        n = Integer.parseInt(br.readLine());
        member = new int[n][n];
        check = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		member[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dfs(n/2, 0);
        
        bw.write(min + "\n");
        bw.flush();
    }
    
    static void dfs(int count, int index) {
    	if(count == 0) {
    		min = Math.min(min, team_min());
            return;  		
    	}
    	for(int i = index; i < n; i++) {
    		if(check[i] == false) {
    			check[i] = true;
    			dfs(count-1, i+1);
    			check[i] = false;
    		}
    	}
    }
    
    static int team_min() {
    	int sum1 = 0;
    	int sum2 = 0;
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(check[i] == true && check[j] == true) {
    				sum1 += member[i][j];
    			} else if (!check[i] && !check[j]) {
    				sum2 += member[i][j];
    			}
    		}
    	}
    	if(sum1 - sum2 < 0) return -1*(sum1-sum2);
    	else return sum1-sum2;
    }
}
