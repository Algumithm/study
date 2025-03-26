import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int cache[][];
	static String s1, s2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1=br.readLine();
		s2=br.readLine();
		cache= new int[s1.length()][s2.length()];
		for(int i=0; i<cache.length; ++i)
			Arrays.fill(cache[i],-1);
		System.out.println(LCS(0, 0));
	}
	
	static int LCS(int idx1, int idx2) {
		if(idx1>=s1.length() || idx2>=s2.length())
			return 0;
		if(cache[idx1][idx2]!=-1)
			return cache[idx1][idx2];

		if(s1.charAt(idx1)==s2.charAt(idx2)) {
			cache[idx1][idx2]=Math.max(LCS(idx1+1, idx2+1)+1, Math.max(LCS(idx1+1,idx2), LCS(idx1,idx2+1)));
		}else {
			cache[idx1][idx2]=Math.max(LCS(idx1+1,idx2), LCS(idx1,idx2+1));
		}
				
		return cache[idx1][idx2];
	}
}
