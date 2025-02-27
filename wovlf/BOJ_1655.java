import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> max_queue;
    static PriorityQueue<Integer> min_queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        max_queue = new PriorityQueue<>(Collections.reverseOrder());
        min_queue = new PriorityQueue<>();
        max_queue.add(num);
        bw.write(max_queue.peek()+"\n");
        for(int i = 0;i<n -1;i++){
            num = Integer.parseInt(br.readLine());
            if(max_queue.size() == min_queue.size()){
                max_queue.add(num);
            }
            else{
                min_queue.add(num);
            }
            if(min_queue.peek() < max_queue.peek()){
                int min = min_queue.poll();
                int max = max_queue.poll();
                max_queue.add(min);
                min_queue.add(max);
            }
            bw.write(max_queue.peek()+"\n");
        }
        bw.close();
    } 
}
