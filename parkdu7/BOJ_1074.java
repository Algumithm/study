import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int ans = 0;

        while( N != 0 ) {
        	N -= 1;
        	
        	// 제2사분면
        	if (r < Math.pow(2, N) && c < Math.pow(2, N)) {
        		ans += Math.pow(2, N) * Math.pow(2, N) * 0;
        	}
        	// 제1사분면
        	else if (r < Math.pow(2, N) && c >= Math.pow(2, N)){
	        	ans += Math.pow(2, N) * Math.pow(2, N) * 1;
	        	c -= Math.pow(2, N);
        	}
        	// 제3사분면    
        	else if( r >= Math.pow(2, N) && c < Math.pow(2, N) ){
	        	ans += Math.pow(2, N)*Math.pow(2, N) * 2;
	        	r -= Math.pow(2, N);
        	}
        	// 제4사분면    
        	else {
        		ans += Math.pow(2, N) * Math.pow(2, N) * 3;
        		r -= Math.pow(2, N);
        		c -= Math.pow(2, N);
        	}
        }
        
        System.out.println(ans);
	}
}
