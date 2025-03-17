import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int SIZE = 100;
	
	static boolean isPalindromes(char[] str) {
	    int left = 0, right = str.length - 1;
	    while (left < right) {
	        if (str[left] != str[right]) return false;
	        left++;
	        right--;
	    }
	    return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			String tc = br.readLine();
			
			char[][] map = new char[SIZE][SIZE];
			
			for(int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[i] = st.nextToken().toCharArray();
			}
			
			int result = 1;
			
            for (int count = 1; count <= SIZE; count++) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j <= SIZE - count; j++) {
                        char[] strArr = new char[count];
                        for (int k = 0; k < count; k++) {
                            strArr[k] = map[i][j + k];
                        }
                        if (isPalindromes(strArr)) result = Math.max(result, count);
                    }
                }

                for (int i = 0; i <= SIZE - count; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        char[] strArr = new char[count];
                        for (int k = 0; k < count; k++) {
                            strArr[k] = map[i + k][j];
                        }
                        if (isPalindromes(strArr)) result = Math.max(result, count);
                    }
                }
            }
			System.out.println("#" + tc + " " + result);
		}
		br.close();
	}
}