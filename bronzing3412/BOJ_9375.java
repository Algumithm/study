import java.io.*;
import java.util.*;

public class Main {
	static HashMap<String, Integer> clothmap;
	static ArrayList<String> cloth;
	static int cnt;
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
        	cnt = 1;
        	int n = Integer.parseInt(br.readLine());
        	cloth = new ArrayList<String>();
        	clothmap = new HashMap<String, Integer>();
        	for(int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine());
        		String s1 = st.nextToken();
        		String s2 = st.nextToken();
        		cloth.add(s1);
        		clothmap.put(s2, clothmap.getOrDefault(s2, 0)+1);
        	}
        	
        	for (int count : clothmap.values()) {
                cnt *= (count + 1);
            }
        	cnt--;
        	bw.write((cnt)+"\n");
        }
        bw.flush();
    }
} 
