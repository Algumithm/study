import java.util.*;

class Solution {

    class Food implements Comparable<Food> {
        int index;
        int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Food o) {
            return this.time - o.time;
        }
    }

    public int solution(int[] food_times, long k) {
        long total = 0;
        for (int time : food_times) total += time;
        if (total <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i, food_times[i]));
        }

        long prevTime = 0;
        long sumTime = 0;
        long remaining = food_times.length;

        while (!pq.isEmpty()) {
            long current = pq.peek().time;
            long diff = current - prevTime;
            long spend = diff * remaining;

            if (sumTime + spend > k) break;

            sumTime += spend;
            prevTime = current;
            pq.poll();
            remaining--;
        }

        List<Food> remainList = new ArrayList<>(pq);
        remainList.sort(Comparator.comparingInt(f -> f.index));

        long left = k - sumTime;
        return remainList.get((int)(left % remaining)).index + 1;
    }
}
