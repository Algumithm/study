import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tg = Integer.parseInt(br.readLine());
			String text = br.readLine();
			int length = text.length();
			int size = (length+1)*(length)/2;
			String[] dict = new String[size];
			
			Set<String> s = new HashSet<String>();
			
			int count = 0;
			for(int i = 0; i <= length; i++) {
				for(int j = i+1; j <= length; j++) {
					String temp = text.substring(i, j);
					if(!s.contains(temp)) {
						s.add(temp);
						dict[count++] = temp;
					}
				}
			}
			
			String[] newDict = new String[count];
			
			for(int i = 0; i < count; i++) {
				newDict[i] = dict[i];
			}
			
			Arrays.sort(newDict, (o1, o2) -> o1.compareTo(o2));
			
			String result = tg-1 >= count ? "none" : newDict[tg-1];
			
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}
}
