import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static int[][] field;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<String> arr = new ArrayList<String>();
	
    public static void main(String[] args) throws Exception{
        
    	st = new StringTokenizer(br.readLine(), "-+", true); 	
    	while(st.hasMoreTokens()) {
    		arr.add(st.nextToken());
    	}
    	int sum = 0;
    	int temp = 0;
    	for(int i = arr.size()-1; i >=0; i--) {
    		if (arr.get(i).equals("-")) {
    			sum += temp*-1;
    			temp = 0;
    		}
    		else if(!arr.get(i).equals("+")) temp += Integer.parseInt(arr.get(i));
    	}
    	if(temp != 0) sum+=temp;
    	bw.write(sum+"\n");
    	bw.flush();
    }
}
