import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<Integer> pq_max;
    static PriorityQueue<Integer> pq_min;
    static HashMap<Integer, Integer> hm;

    public static void main(String[] args) throws Exception {
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            pq_max = new PriorityQueue<>(Collections.reverseOrder());
            pq_min = new PriorityQueue<>();
            hm = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                char a = st.nextToken().charAt(0);
                int b = Integer.parseInt(st.nextToken());

                if (a == 'I') {
                    pq_max.add(b);
                    pq_min.add(b);
                    hm.put(b, hm.getOrDefault(b, 0) + 1);
                } else if (a == 'D') {
                    if (b == 1) remove_max();
                    else if (b == -1) remove_min();
                }
            }

            Integer max = getValidMax();
            Integer min = getValidMin();

            if (max == null || min == null) {
                bw.write("EMPTY\n");
            } else {
                bw.write(max + " " + min + "\n");
            }
        }
        bw.flush();
    }

    static void remove_min() {
        while (!pq_min.isEmpty()) {
            int val = pq_min.poll();
            if (hm.containsKey(val)) {
                if (hm.get(val) == 1) hm.remove(val);
                else hm.put(val, hm.get(val) - 1);
                return;
            }
        }
    }

    static void remove_max() {
        while (!pq_max.isEmpty()) {
            int val = pq_max.poll();
            if (hm.containsKey(val)) {
                if (hm.get(val) == 1) hm.remove(val);
                else hm.put(val, hm.get(val) - 1);
                return;
            }
        }
    }

    static Integer getValidMax() {
        while (!pq_max.isEmpty()) {
            int val = pq_max.peek();
            if (hm.containsKey(val)) return val;
            pq_max.poll();
        }
        return null;
    }

    static Integer getValidMin() {
        while (!pq_min.isEmpty()) {
            int val = pq_min.peek();
            if (hm.containsKey(val)) return val;
            pq_min.poll();
        }
        return null;
    }
}
