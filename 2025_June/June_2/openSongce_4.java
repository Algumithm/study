import java.util.*;

public class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> parent = new HashMap<>(room_number.length * 2);
        for (int i = 0; i < room_number.length; i++) {
            long want = room_number[i];
            long avail = find(want, parent);
            answer[i] = avail;
            parent.put(avail, find(avail + 1, parent));
        }
        return answer;
    }

    private long find(long x, Map<Long, Long> parent) {
        Long p = parent.get(x);
        if (p == null) {
            return x;
        }
        long root = find(p, parent);
        parent.put(x, root);
        return root;
    }
}
