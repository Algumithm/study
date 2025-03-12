import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static String[] p = {
			"0001101" 
			, "0011001" 
			, "0010011" 
			, "0111101"
			, "0100011"
			, "0110001"
			, "0101111"
			, "0111011"
			, "0110111"
			, "0001011" 
			};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x;
		int y;
		int[][] grid;
		int[] arr;
		int[] result;
		
		int cs = Integer.parseInt(br.readLine());
		for (int c = 1; c <= cs; c++) {
			int ans = 0;
			result = new int[56];
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			grid = new int[x][y];
			arr = new int[y];
			int target = -1;
			
			for (int i = 0; i < x; i++) {
				String s = br.readLine();
				for (int j = 0; j < y; j++) {
					grid[i][j] = Character.getNumericValue(s.charAt(j));
					if(grid[i][j] == 1 && arr[y-1] != 1)
						target = i;
				}
				
				if(target != -1) {
					for (int j = 0; j < y; j++) {
						arr[j] = grid[target][j];
					}
				}
			}
			
			int index = findLastOne(arr);
			int k = 0;
			for (int i = index - 55; i <= index; i++) {
				result[k++] = arr[i]; 
			}
			
			List<String> stArr = getBit(result);
			int[] intArr = new int[8];
			for (int i = 0; i < stArr.size(); i++) {
				intArr[i] = getNum(stArr.get(i));
			}
			
			if(isRight(intArr)) {
				ans = count(intArr);
			}
			
			System.out.println("#" + c + " " + ans);
		}//cs
	}//main
	
	static int findLastOne(int[] arr) {
		int index = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}//findlast
	
	static List<String> getBit(int[] arr) {
		List<String> stArr = new ArrayList<>();
		
		String st = "";
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			st += Integer.toString(arr[i]);
			count++;
			if(count == 7) {
				count = 0;
				stArr.add(st);
				st = "";
			}
		}
		
		return stArr;
	}//getBit
	
	static int getNum(String st) {
		int result = -1;
		for (int i = 0; i < p.length; i++) {
			if(st.equals(p[i])){
				result = i;
				break;
			}
		}
		return result;
	}//getNum
	
	static boolean isRight(int[] arr) {
		boolean result = false;
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(i%2 == 0)
				count += arr[i]*3;
			else count += arr[i];
		}
		if(count % 10 == 0) {
			result = true;
		}
		
		return result;
	}//isright
	
	static int count(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += arr[i];
		}
		return count;
	}//count
	
}//swea
