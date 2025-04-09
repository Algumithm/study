import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2303 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());

        int[] number = new int[5];
        
        int[] max = {0, 0};
        
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < 5; j++) {
        		number[j] = Integer.parseInt(st.nextToken());
        	}

        	for(int x = 0; x < 4; x++) {
        		for(int y = x+1; y < 5; y++) {
            		int sum = 0;
        			for(int z = 0; z < 5; z++) {
        				if(z == x || z == y) continue;
        				sum += number[z];
        			}
        			if(sum % 10 >= max[1]) {
        				max[0] = i;
        				max[1] = sum % 10;
        			}
        		}
        	}
        }

        System.out.println(max[0] + 1);
        br.close();
    }
}
