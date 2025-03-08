import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int cnt;
    static ArrayList<int[]> arr = new ArrayList<int[]>();
    static HashMap<Integer, Integer> meeting = new HashMap<Integer, Integer>();
    
    public static void main(String[] args) throws Exception {
    	int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr.add(new int[] {a, b});
        }
        arr.sort((o1, o2) -> (o1[1] == o2[1]) ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        int endTime = 0; 
        for (int[] meeting : arr) {
            if (meeting[0] >= endTime) {
                cnt++;
                endTime = meeting[1];
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
    }

}
