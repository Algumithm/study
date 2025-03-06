import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine()); 
        String s = br.readLine(); 

        int cnt = 0;
        int pcnt = 0;

        for (int i = 1; i < M - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                pcnt++;
                if (pcnt >= N) {
                    cnt++;
                }
                i++; 
            } else {
                pcnt = 0;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
