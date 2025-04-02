import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] food;
    static int maxEnergy = 0;

    static void findMaxEnergy(int start, int currentEnergy) {
        if (start == N) {
            maxEnergy = Math.max(maxEnergy, currentEnergy);
            return;
        }
        
        int sumEnergy = 0;
        int count = 0;
        for(int i = start; i < N; i++) {
        	sumEnergy += food[i];
        	if(sumEnergy >= K || food[i] == 0) {
        		count = i;
        		break;
        	}
        }
        
        if (sumEnergy >= K) {
            findMaxEnergy(count + 1, currentEnergy + (sumEnergy - K));
        }
        
        findMaxEnergy(start + 1, currentEnergy);
    }

    public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        food = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }
        
        findMaxEnergy(0, 0);
        
        System.out.println(maxEnergy);
        br.close();
    }
}
