import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        int TC = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= TC; tc++) {
            String s = br.readLine();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            
            Deque<Integer> arr = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            boolean r = false;
            boolean error = false;

            for (char cmd : s.toCharArray()) {
                if (cmd == 'R') {
                    r = !r;
                } else if (cmd == 'D') {
                    if (arr.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (r) {
                        arr.pollLast();
                    } else {
                        arr.pollFirst();
                    }
                }
            }

            if (error) {
                bw.write("error\n");
            } else {
                bw.write("[");
                while (!arr.isEmpty()) {
                    if (r) {
                        bw.write(arr.pollLast() + "");
                    } else {
                        bw.write(arr.pollFirst() + "");
                    }
                    if (!arr.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
            bw.flush();
        }
    }
}
