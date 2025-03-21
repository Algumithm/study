import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
	int start, end, diff;

	public Meeting(int x, int y) {
		start = x;
		end = y;
		diff = end - start;
	}

	@Override
	public int compareTo(Meeting o) {
		if (this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
}

public class Main {
	static List<Meeting> list = new ArrayList<>();
    static int N;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }
        
        list.sort(null);
        int cnt = 0, time = 0, n = 0;
        
        for (int j = n; j < list.size(); j++) {
			if(time <= list.get(j).start) {
				time = list.get(j).end;
				cnt++;
			}
		}
        
        System.out.println(cnt);
    }//main
}
